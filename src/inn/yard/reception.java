
package inn.yard;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class reception extends JFrame implements ActionListener{
    
    JButton new_customer, rooms, department, all_employee, customer_info, manager, checkuout, update, room_status, pickup, search_room, logout;
    
    reception(){
        
        setLayout(null);
        
        
        
        new_customer = new JButton("NEW CUSTOMER FORM");
        new_customer.setFont(new Font("Tohoma", Font.BOLD, 14));
        new_customer.setBackground(colors.INSTANCE.reception_button_bg());
        new_customer.setForeground(colors.INSTANCE.reception_button_text());
        new_customer.setBounds(20,30,200,40);
        new_customer.addActionListener(this);
        add(new_customer);
        
        rooms = new JButton("ROOMS");
        rooms.setFont(new Font("Tohoma", Font.BOLD, 14));
        rooms.setBackground(colors.INSTANCE.reception_button_bg());
        rooms.setForeground(colors.INSTANCE.reception_button_text());
        rooms.setBounds(20,85,200,40);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("DEPARTMENT");
        department.setFont(new Font("Tohoma", Font.BOLD, 14));
        department.setBackground(colors.INSTANCE.reception_button_bg());
        department.setForeground(colors.INSTANCE.reception_button_text());
        department.setBounds(20,140,200,40);
        department.addActionListener(this);
        add(department);
        
        all_employee = new JButton("ALL EMPLOYEE");
        all_employee.setFont(new Font("Tohoma", Font.BOLD, 14));
        all_employee.setBackground(colors.INSTANCE.reception_button_bg());
        all_employee.setForeground(colors.INSTANCE.reception_button_text());
        all_employee.setBounds(20,195,200,40);
        all_employee.addActionListener(this);
        add(all_employee);
        
        customer_info = new JButton("CUSTOMER INFO");
        customer_info.setFont(new Font("Tohoma", Font.BOLD, 14));
        customer_info.setBackground(colors.INSTANCE.reception_button_bg());
        customer_info.setForeground(colors.INSTANCE.reception_button_text());
        customer_info.setBounds(20,250,200,40);
        customer_info.addActionListener(this);
        add(customer_info);
        
        
        manager = new JButton("MANAGER INFO");
        manager.setFont(new Font("Tohoma", Font.BOLD, 14));
        manager.setBackground(colors.INSTANCE.reception_button_bg());
        manager.setForeground(colors.INSTANCE.reception_button_text());
        manager.setBounds(20,305,200,40);
        manager.addActionListener(this);
        add(manager);
        
        checkuout = new JButton("CHECKOUT");
        checkuout.setFont(new Font("Tohoma", Font.BOLD, 14));
        checkuout.setBackground(colors.INSTANCE.reception_button_bg());
        checkuout.setForeground(colors.INSTANCE.reception_button_text());
        checkuout.setBounds(20,360,200,40);
        checkuout.addActionListener(this);
        add(checkuout);
        
        update = new JButton("UPDATE STATUS");
        update.setFont(new Font("Tohoma", Font.BOLD, 14));
        update.setBackground(colors.INSTANCE.reception_button_bg());
        update.setForeground(colors.INSTANCE.reception_button_text());
        update.setBounds(20,415,200,40);
        update.addActionListener(this);
        add(update);
        
        room_status = new JButton("UPDATE ROOM STATUS");
        room_status.setFont(new Font("Tohoma", Font.BOLD, 14));
        room_status.setBackground(colors.INSTANCE.reception_button_bg());
        room_status.setForeground(colors.INSTANCE.reception_button_text());
        room_status.setBounds(20,470,200,40);
        room_status.addActionListener(this);
        add(room_status);
        
        pickup = new JButton("PICKUP SERVICES");
        pickup.setFont(new Font("Tohoma", Font.BOLD, 14));
        pickup.setBackground(colors.INSTANCE.reception_button_bg());
        pickup.setForeground(colors.INSTANCE.reception_button_text());
        pickup.setBounds(20,525,200,40);
        pickup.addActionListener(this);
        add(pickup);
        
        search_room = new JButton("SEARCH ROOM");
        search_room.setFont(new Font("Tohoma", Font.BOLD, 14));
        search_room.setBackground(colors.INSTANCE.reception_button_bg());
        search_room.setForeground(colors.INSTANCE.reception_button_text());
        search_room.setBounds(20,580,200,40);
        search_room.addActionListener(this);
        add(search_room);
        
        logout = new JButton("LOGOUT");
        logout.setFont(new Font("Tohoma", Font.BOLD, 14));
        logout.setBackground(colors.INSTANCE.reception_button_bg());
        logout.setForeground(colors.INSTANCE.reception_button_text());
        logout.setBounds(20,635,200,40);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/reception.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(255, 150, 400, 400);
        add(image);
        
        getContentPane().setBackground(colors.INSTANCE.reception_bg());
        setBounds(600,210,700,737);
        setVisible(true);
        

        
        
    }
     
    public static void main(String[ ] args){
        
        new reception();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== new_customer){
            
            setVisible(false);
            new add_customer();
            
        }else if(e.getSource()== rooms){
            
            setVisible(false);
            new room();
            
        }else if(e.getSource()== department){
            
            setVisible(false);
            new department();
            
        }else if(e.getSource() == manager){
            setVisible(false);
            new manager_info();
        }
        
        else if(e.getSource() == all_employee){
            setVisible(false);
            new employee_info();
        }
        
        else if(e.getSource() == customer_info){
            setVisible(false);
            new customer_info();
        }
        else if(e.getSource() == search_room){
            setVisible(false);
            new search_room();
        }
        else if(e.getSource() == update){
            setVisible(false);
            new update_check();
        }
        else if(e.getSource() == room_status){
            setVisible(false);
            new update_room();
        }
        else if(e.getSource() == pickup){
            setVisible(false);
            new pick_up();
        } 
        
        else if(e.getSource() == checkuout){
            setVisible(false);
            new check_out();
        } 
        else if(e.getSource() == logout){
            setVisible(false);
            System.exit(0);
        } 
       
        
        
    }
}
