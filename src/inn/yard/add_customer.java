package inn.yard;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.Date;

public class add_customer extends JFrame implements ActionListener {

    JTextField tnumber, tname, tcountry, tage, tsalary, tphone, temail, tdeposit;
    JRadioButton rmale, rfemale;
    JComboBox cid, cjob;
    JButton add, back;
    Choice croom;
    JLabel checkIn_time;

    add_customer() {

        setLayout(null);

        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setFont(new Font("Tohoma", Font.BOLD, 19));
        heading.setForeground(colors.INSTANCE.room_heading());
        heading.setBounds(100, 20, 300, 30);
        add(heading);

        JLabel id = new JLabel("ID");
        id.setBounds(35, 80, 100, 20);
        id.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(id);

        String str[] = {"NID Card", "Passport", "Driving License"};
        cid = new JComboBox(str);
        cid.setBounds(200, 80, 150, 25);
        cid.setBackground(colors.INSTANCE.reception_bg());
        add(cid);

        JLabel number = new JLabel("Number");
        number.setBounds(35, 125, 100, 20);
        number.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(number);

        tnumber = new JTextField();
        tnumber.setBounds(200, 125, 150, 25);
        add(tnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(35, 170, 150, 20);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 170, 150, 25);
        add(tname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(35, 215, 100, 20);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(200, 215, 60, 25);
        rmale.setFont(new Font("Tohoma", Font.PLAIN, 14));
        rmale.setBackground(colors.INSTANCE.reception_bg());
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(270, 215, 100, 25);
        rfemale.setFont(new Font("Tohoma", Font.PLAIN, 14));
        rfemale.setBackground(colors.INSTANCE.reception_bg());
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel country = new JLabel("Country");
        country.setBounds(35, 260, 100, 20);
        country.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(country);

        tcountry = new JTextField();
        tcountry.setBounds(200, 260, 150, 25);
        add(tcountry);

        JLabel room = new JLabel("Room No");
        room.setBounds(35, 305, 100, 20);
        room.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(room);

        //till here
        croom = new Choice();
        try {

            connection c = new connection();
            String query = "select *from add_rooms where avalability = 'Available'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("room_num"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        croom.setBounds(200, 305, 150, 25);
        add(croom);

        JLabel time = new JLabel("Checkin Time");
        time.setBounds(35, 350, 150, 20);
        time.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(time);

        Date date = new Date();

        checkIn_time = new JLabel("" + date);
        checkIn_time.setBounds(200, 350, 200, 25);
        checkIn_time.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(checkIn_time);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(35, 395, 100, 20);
        deposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(deposit);

        tdeposit = new JTextField();
        tdeposit.setBounds(200, 395, 150, 25);
        add(tdeposit);

        add = new JButton("ADD");
        add.setBackground(colors.INSTANCE.reception_button_bg());
        add.setForeground(colors.INSTANCE.reception_button_text());
        add.setBounds(50, 445, 120, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBackground(colors.INSTANCE.reception_button_bg());
        back.setForeground(colors.INSTANCE.reception_button_text());
        back.setBounds(220, 445, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/add.png"));
        Image i2 = i1.getImage().getScaledInstance(370, 420, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(443, 50, 370, 420);
        add(image);

        getContentPane().setBackground(colors.INSTANCE.reception_bg());
        setBounds(550, 250, 840, 540);
        setVisible(true);

    }

    public static void main(String[] args) {

        new add_customer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String id = (String) cid.getSelectedItem();
            String number = tnumber.getText();
            String name = tname.getText();

            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            }
            if (rfemale.isSelected()) {
                gender = "Female";
            }

            String country = tcountry.getText();
            String room_no = croom.getSelectedItem();
            String time = checkIn_time.getText();
            String deposit = tdeposit.getText();

            try {
                
                connection c = new connection();

                String query = "insert into add_customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room_no + "','" + time + "','" + deposit + "')";
                String query2 = "update add_rooms set avalability = 'Occupied' where room_num = "+room_no;
                
                if (number.equals("")){
               JOptionPane.showMessageDialog(null,"Number field cannot be null");
           
           }
           else if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name field cannot be null");
           }
           else if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Nam field cannot be null");
           }
           else if(country.equals("")){
               JOptionPane.showMessageDialog(null,"Country field cannot be null");
           }
           else if(deposit.equals("")){
               JOptionPane.showMessageDialog(null,"Deposit field cannot be null");
           }
           
           else{
                

                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer added succesfully");

                setVisible(false);
                new reception();

            } }catch (Exception e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == back) {

            setVisible(false);
            new reception();

        }

        

    }

}
