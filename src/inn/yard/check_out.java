
package inn.yard;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.Date;


public class check_out extends JFrame implements ActionListener{
    
    Choice customer;
    JLabel lroom,lcheckin, lcheckout;
    JButton check_out,back,display;
    
    check_out(){
        
     setLayout(null);
     
     
     
     JLabel text = new JLabel("CHECK OUT");
     text.setFont(new Font("Tahoma",Font.PLAIN,20));
     text.setForeground(colors.INSTANCE.room_table_head());
     text.setBounds(115,20,170,30);
     add(text);
     
     JLabel id = new JLabel("Customer ID:");
       id.setFont(new Font("Tahoma",Font.PLAIN,16));
       id.setForeground(colors.INSTANCE.room_table_head());
       id.setBounds(30,80,100,30);
       add(id);
       
       customer = new Choice();
       customer.setBounds(150,80,150,25);
       customer.setForeground(colors.INSTANCE.room_table_head());
       customer.setBackground(colors.INSTANCE.room_bg());
       add(customer);
       
      
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,56,70,70);
        add(image);
        
       JLabel room = new JLabel("Room Number:");
       room.setFont(new Font("Tahoma",Font.PLAIN,16));
       room.setForeground(colors.INSTANCE.room_table_head());
       room.setBounds(30,130,150,30);
       add(room);
       
       lroom = new JLabel();
       lroom.setBounds(150,130,150,30);
       lroom.setFont(new Font("Tahoma",Font.PLAIN,16));
       lroom.setForeground(colors.INSTANCE.room_table_head());
       add(lroom);
       
       JLabel checkin = new JLabel("CheckIn Time:");
       checkin.setFont(new Font("Tahoma",Font.PLAIN,16));
       checkin.setForeground(colors.INSTANCE.room_table_head());
       checkin.setBounds(30,180,150,30);
       add(checkin);
       
       lcheckin = new JLabel();
       lcheckin.setBounds(150,180,270,30);
       lcheckin.setFont(new Font("Tahoma",Font.PLAIN,16));
       lcheckin.setForeground(colors.INSTANCE.room_table_head());
       add(lcheckin);
       
       JLabel checkout = new JLabel("CheckOut Time:");
       checkout.setFont(new Font("Tahoma",Font.PLAIN,16));
       checkout.setForeground(colors.INSTANCE.room_table_head());
       checkout.setBounds(30,230,150,30);
       add(checkout);
       
       Date date =new Date();
       lcheckout = new JLabel(""+date);
       lcheckout.setBounds(150,230,270,30);
       lcheckout.setFont(new Font("Tahoma",Font.PLAIN,16));
       lcheckout.setForeground(colors.INSTANCE.room_table_head());
       add(lcheckout);
       
       
       display = new JButton("DISPLAY");
       display.setFont(new Font("Tohoma", Font.BOLD, 14));
       display.setBackground(colors.INSTANCE.room_button_bg());
       display.setForeground(colors.INSTANCE.room_bg());
       display.setBounds(30,290,130,30);
       display.addActionListener(this);
       add(display);
       
       check_out = new JButton("CHECK OUT");
       check_out.setFont(new Font("Tohoma", Font.BOLD, 14));
       check_out.setBackground(colors.INSTANCE.room_button_bg());
       check_out.setForeground(colors.INSTANCE.room_bg());
       check_out.setBounds(200,290,130,30);
       check_out.addActionListener(this);
       add(check_out);
       
       back = new JButton("BACK");
       back.setFont(new Font("Tohoma", Font.BOLD, 14));
       back.setBackground(colors.INSTANCE.room_button_bg());
       back.setForeground(colors.INSTANCE.room_bg());
       back.setBounds(120,345,130,30);
       back.addActionListener(this);
       add(back);
       
        try{
           connection c= new connection();
           
           ResultSet rs = c.s.executeQuery("select *from add_customer");
           while(rs.next()){
               customer.add(rs.getString("number"));
               
              
           }
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/checkout.png"));
       Image i5 = i4.getImage().getScaledInstance(330,250, Image.SCALE_SMOOTH);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel image1 = new JLabel(i6);
       image1.setBounds(420,50,320,300);
       add(image1);
       
       
     getContentPane().setBackground(colors.INSTANCE.room_bg());
     setBounds(540,300,810,450);
     setVisible(true);
        
    }
    
    public static void main(String[] args){
        new check_out();
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== check_out){
            
           // String id = customer.getSelectedItem();
            String query ="delete from add_customer where number = '"+customer.getSelectedItem()+"'";
            String q2 ="update add_rooms set avalability='Available' where room_num ='"+lroom.getText()+"'";
            
            try{
                
                connection c = new connection();
                c.s.executeUpdate(query);
                c.s.executeUpdate(q2);
                
                JOptionPane.showMessageDialog(null,"Checkout done succesfully");
                
                setVisible(false);
                new reception();
                
                
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }
        else if(e.getSource()== display){
            
           try{
                connection c= new connection();
           
           ResultSet rs1 = c.s.executeQuery("select *from add_customer where number = '"+customer.getSelectedItem()+"'");
           
           while(rs1.next()){
               
               lroom.setText(rs1.getString("room_no"));
               lcheckin.setText(rs1.getString("time"));
           }
           
       }catch(Exception re){
           re.printStackTrace();
       }
        }
        
        else if(e.getSource()== back){
            
            setVisible(false);
            new reception();
    
        }
       
    }
    
}
