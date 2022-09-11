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

public class add_rooms extends JFrame implements ActionListener {

    JTextField troom_no, tprice;
    JComboBox cstatus, cclean, ctype;
    JButton add, cancel;

    add_rooms() {

        setLayout(null);

        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tohoma", Font.BOLD, 19));
        heading.setForeground(colors.INSTANCE.room_heading());
        heading.setBounds(150, 27, 200, 20);
        add(heading);

        JLabel room_no = new JLabel("Room Number");
        room_no.setFont(new Font("Tohoma", Font.PLAIN, 16));
        room_no.setBounds(60, 85, 120, 30);
        add(room_no);

        troom_no = new JTextField();
        troom_no.setBounds(200, 85, 150, 30);
        add(troom_no);

        JLabel status = new JLabel("Avalability");
        status.setFont(new Font("Tohoma", Font.PLAIN, 16));
        status.setBounds(60, 140, 120, 30);
        add(status);

        String option[] = {"Available", "Occupied"};
        cstatus = new JComboBox(option);
        cstatus.setBounds(200, 140, 150, 30);
        cstatus.setBackground(colors.INSTANCE.add_emoloyee_background());
        add(cstatus);

        JLabel clean = new JLabel("Status");
        clean.setFont(new Font("Tohoma", Font.PLAIN, 16));
        clean.setBounds(60, 195, 120, 30);
        add(clean);

        String clean_option[] = {"Cleaned", "Dirty"};
        cclean = new JComboBox(clean_option);
        cclean.setBounds(200, 195, 150, 30);
        cclean.setBackground(colors.INSTANCE.add_emoloyee_background());
        add(cclean);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tohoma", Font.PLAIN, 16));
        price.setBounds(60, 250, 120, 30);
        add(price);

        tprice = new JTextField();
        tprice.setBounds(200, 250, 150, 30);
        add(tprice);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tohoma", Font.PLAIN, 16));
        type.setBounds(60, 305, 120, 30);
        add(type);

        String bed_type[] = {"Single Bed", "Double Bed"};
        ctype = new JComboBox(bed_type);
        ctype.setBounds(200, 305, 150, 30);
        ctype.setBackground(colors.INSTANCE.add_emoloyee_background());
        add(ctype);

        add = new JButton("ADD ROOM");
        add.setBackground(colors.INSTANCE.add_e_submit_b_back());
        add.setForeground(colors.INSTANCE.add_e_submit_button());
        add.setBounds(70, 383, 120, 33);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("CANCEL");
        cancel.setBackground(colors.INSTANCE.add_e_submit_b_back());
        cancel.setForeground(colors.INSTANCE.add_e_submit_button());
        cancel.setBounds(230, 383, 120, 33);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/add_room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(460, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 22, 460, 427);
        add(image);

        getContentPane().setBackground(colors.INSTANCE.add_emoloyee_background());
        setBounds(533, 275, 875, 515);
        setVisible(true);

    }

    public static void main(String[] args) {

        new add_rooms();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String room_No =  troom_no.getText();
            String avalability = (String) cstatus.getSelectedItem();
            String clean= (String) cclean.getSelectedItem();
            String Price = tprice.getText();
            String bed_type = (String) ctype.getSelectedItem();

            try {
                connection c = new connection();

                String query = "insert into add_rooms values('" + room_No + "','" + avalability + "','" + clean + "','" + Price + "','" + bed_type + "')";
                
                if(room_No.equals("")) {
               
               JOptionPane.showMessageDialog(null,"Roon Number feild is null");
        
           }if (room_No.equals("")){
               JOptionPane.showMessageDialog(null,"Age feild is null");
           
           }
           else if(avalability.equals("")){
               JOptionPane.showMessageDialog(null,"Availability feild is null");
           }
           else if(clean.equals("")){
               JOptionPane.showMessageDialog(null,"Status feild is null");
           }
           else if(Price.equals("")){
               JOptionPane.showMessageDialog(null,"Price feild is null");
           }
           else if(bed_type.equals("")){
               JOptionPane.showMessageDialog(null,"Bed Type feild is null");
           }
           else{

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rooms Information added succesfully");

                setVisible(false);

            } }catch (Exception ae) {

                System.out.println(ae);

            }

        } else {
            setVisible(false);
        }

    }

}
