package inn.yard;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class add_driver extends JFrame implements ActionListener {

    JTextField tname, tage, tcompany, tmodel, tlocation;
    JComboBox cstatus, cgender, ctype;
    JButton add, cancel;

    add_driver() {

        setLayout(null);

        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tohoma", Font.BOLD, 19));
        heading.setForeground(colors.INSTANCE.room_heading());
        heading.setBounds(150, 25, 200, 20);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tohoma", Font.PLAIN, 16));
        name.setBounds(60, 77, 120, 30);
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 77, 150, 30);
        add(tname);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tohoma", Font.PLAIN, 16));
        age.setBounds(60, 132, 120, 30);
        add(age);

        tage = new JTextField();
        tage.setBounds(200, 132, 150, 30);
        add(tage);

        JLabel clean = new JLabel("Gender");
        clean.setFont(new Font("Tohoma", Font.PLAIN, 16));
        clean.setBounds(60, 187, 120, 30);
        add(clean);

        String clean_option[] = {"Male", "Female"};
        cgender = new JComboBox(clean_option);
        cgender.setBounds(200, 187, 150, 30);
        cgender.setBackground(colors.INSTANCE.add_emoloyee_background());
        add(cgender);

        JLabel company = new JLabel("Car Company");
        company.setFont(new Font("Tohoma", Font.PLAIN, 16));
        company.setBounds(60, 242, 120, 30);
        add(company);

        tcompany = new JTextField();
        tcompany.setBounds(200, 242, 150, 30);
        add(tcompany);

        JLabel type = new JLabel("Car Model");
        type.setFont(new Font("Tohoma", Font.PLAIN, 16));
        type.setBounds(60, 297, 120, 30);
        add(type);

        tmodel = new JTextField();
        tmodel.setBounds(200, 297, 150, 30);
        add(tmodel);

        JLabel available = new JLabel("Avalability");
        available.setFont(new Font("Tohoma", Font.PLAIN, 16));
        available.setBounds(60, 352, 120, 30);
        add(available);

        String option[] = {"Available", "Busy"};
        cstatus = new JComboBox(option);
        cstatus.setBounds(200, 352, 150, 30);
        cstatus.setBackground(colors.INSTANCE.add_emoloyee_background());
        add(cstatus);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tohoma", Font.PLAIN, 16));
        location.setBounds(60, 407, 120, 30);
        add(location);

        tlocation = new JTextField();
        tlocation.setBounds(200, 407, 150, 30);
        add(tlocation);

        add = new JButton("ADD DRIVER");
        add.setBackground(colors.INSTANCE.add_e_submit_b_back());
        add.setForeground(colors.INSTANCE.add_e_submit_button());
        add.setBounds(60, 462, 130, 33);
        add.setFont(new Font("Tahoma",Font.BOLD,14));
        add.addActionListener(this);
        add(add);

        cancel = new JButton("CANCEL");
        cancel.setBackground(colors.INSTANCE.add_e_submit_b_back());
        cancel.setForeground(colors.INSTANCE.add_e_submit_button());
        cancel.setBounds(220, 462, 130, 33);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/add_driver.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 455, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(380, 61, 550, 432);
        add(image);

        getContentPane().setBackground(colors.INSTANCE.add_emoloyee_background());
        setBounds(533, 260, 975, 575);
        setVisible(true);

    }

    public static void main(String[] args) {

        new add_driver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String name = tname.getText();
            String age = tage.getText();
            String gender = (String) cgender.getSelectedItem();
            String company = tcompany.getText();
            String brand = tmodel.getText();
            String avalability = (String) cstatus.getSelectedItem();
            String loaction = tlocation.getText();

            try {
                connection c = new connection();

                String query = "insert into add_drivers values('" + name + "','" + age + "','" +gender + "','" + company+ "','" +brand + "','" +avalability+ "','" +loaction+ "')";
                
                if (name.equals("")){
               JOptionPane.showMessageDialog(null,"Name field cannot be null");
           
           }
           else if(avalability.equals("")){
               JOptionPane.showMessageDialog(null,"Availability field cannot be null");
           }
           else if(age.equals("")){
               JOptionPane.showMessageDialog(null,"Age field cannot be null");
           }
           else if(brand.equals("")){
               JOptionPane.showMessageDialog(null,"Car Model field cannot be null");
           }
           else if(company.equals("")){
               JOptionPane.showMessageDialog(null,"Car Company field cannot be null");
           }
           else if(loaction.equals("")){
               JOptionPane.showMessageDialog(null,"Location field cannot be null");
           }
           else{
                
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Driver's Information added succesfully");

                setVisible(false);

            } }catch (Exception ae) {

                System.out.println(ae);

            }

        } else {
            setVisible(false);
        }

    }

}
