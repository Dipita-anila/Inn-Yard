
package inn.yard;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class dashboard extends JFrame implements ActionListener{
    
   dashboard(){
       
       setBounds(0, 0, 1920, 1080);
       
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/background.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,1920,1080);
       add(image);
       
       JLabel text = new JLabel("Four Seasons Resort Welcomes You");
       text.setBounds(400,90,1300,70);
       text.setFont(new Font("Tahoma", Font.PLAIN,70));
       text.setForeground(colors.INSTANCE.dtitle());
       image.add(text);
       
       JMenuBar mb = new JMenuBar();
       mb.setBounds(0,0,1920,30);
       image.add(mb);
       
       JMenu hotel = new JMenu("HOTEL MANAGEMENT");
       hotel.setForeground(colors.INSTANCE.dmenu());
       mb.add(hotel);
       
       JMenuItem reception = new JMenuItem("RECEPTION");
       reception.setForeground(colors.INSTANCE.dmenu());
       reception.addActionListener(this);
       hotel.add(reception);
       
       
       JMenu admin = new JMenu("ADMIN");
       admin.setForeground(colors.INSTANCE.dmenu1());
       mb.add(admin);
       
       JMenuItem add_employee = new JMenuItem("ADD EMPLOYEE");
       add_employee.setForeground(colors.INSTANCE.dmenu1());
       add_employee.addActionListener(this);
       admin.add(add_employee);
       
       JMenuItem add_rooms = new JMenuItem("ADD ROOMS");
       add_rooms.setForeground(colors.INSTANCE.dmenu1());
       add_rooms.addActionListener(this);
       admin.add(add_rooms);
       
       JMenuItem add_drivers = new JMenuItem("ADD DRIVERS");
       add_drivers.setForeground(colors.INSTANCE.dmenu1());
       add_drivers.addActionListener(this);
       admin.add(add_drivers);
       
       
       setVisible(true);
   }
   



public static void main(String[] args) {

    new dashboard();
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equals("ADD EMPLOYEE")){
            new add_employee();
        }
        else if(e.getActionCommand().equals("ADD ROOMS")){
            new add_rooms();
        }
        else if(e.getActionCommand().equals("ADD DRIVERS")){
            new add_driver();
        }
        else if(e.getActionCommand().equals("RECEPTION")){
            new reception();
        }
    }

}
