




package inn.yard;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;



public class update_room extends JFrame implements ActionListener{
    
    Choice customer;
    JTextField troom, tavailable, tstatus;
    JButton check, update,back;
    
   update_room(){
       
       getContentPane().setBackground(colors.INSTANCE.room_bg());
       setLayout(null);
       
       JLabel text = new JLabel("UPDATE ROOM STATUS");
       text.setFont(new Font("Tahoma",Font.PLAIN,25));
       text.setForeground(colors.INSTANCE.room_table_head());
       text.setBounds(60,20,300,30);
       add(text);
       
       JLabel id = new JLabel("Guest ID");
       id.setFont(new Font("Tahoma",Font.PLAIN,16));
       id.setForeground(colors.INSTANCE.room_table_head());
       id.setBounds(30,90,100,20);
       add(id);
       
       customer = new Choice();
       customer.setBounds(200,90,150,25);
       add(customer);
       
       try{
           connection c= new connection();
           
           ResultSet rs = c.s.executeQuery("select *from add_customer");
           while(rs.next()){
               customer.add(rs.getString("number"));
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       JLabel room = new JLabel("Room Number");
       room.setFont(new Font("Tahoma",Font.PLAIN,16));
       room.setForeground(colors.INSTANCE.room_table_head());
       room.setBounds(30,140,150,20);
       add(room);
       
       troom = new JTextField();
       troom.setBounds(200,140,150,25);
       add(troom);
       
       JLabel name = new JLabel("Avalability");
       name.setFont(new Font("Tahoma",Font.PLAIN,16));
       name.setForeground(colors.INSTANCE.room_table_head());
       name.setBounds(30,190,100,20);
       add(name);
       
       tavailable = new JTextField();
       tavailable.setBounds(200,190,150,25);
       add(tavailable);
       
       JLabel checkin = new JLabel("Cleaning Status");
       checkin.setFont(new Font("Tahoma",Font.PLAIN,16));
       checkin.setForeground(colors.INSTANCE.room_table_head());
       checkin.setBounds(30,240,150,20);
       add(checkin);
       
       tstatus = new JTextField();
       tstatus.setBounds(200,240,150,25);
       add(tstatus);
       
      
       
       back = new JButton("BACK");
       back.setFont(new Font("Tohoma", Font.BOLD, 18));
       back.setBackground(colors.INSTANCE.room_button_bg());
       back.setForeground(colors.INSTANCE.room_bg());
       back.setBounds(125,370,130,35);
       back.addActionListener(this);
       add(back);
       
       check = new JButton("CHECK");
       check.setFont(new Font("Tohoma", Font.BOLD, 18));
       check.setBackground(colors.INSTANCE.room_button_bg());
       check.setForeground(colors.INSTANCE.room_bg());
       check.setBounds(35,300,130,35);
       check.addActionListener(this);
       add(check);
       
       update = new JButton("UPDATE");
       update.setFont(new Font("Tohoma", Font.BOLD, 18));
       update.setBackground(colors.INSTANCE.room_button_bg());
       update.setForeground(colors.INSTANCE.room_bg());
       update.setBounds(205,300,130,35);
       update.addActionListener(this);
       add(update);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/room_status.png"));
       Image i2 = i1.getImage().getScaledInstance(350,350, Image.SCALE_SMOOTH);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i1);
       image.setBounds(370,35,350,350);
       add(image);
       
       
       setBounds(540,300,740,470);
       setVisible(true);
   } 
    
   public static void main(String[] args){
       new update_room();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== check){
            
            String id = customer.getSelectedItem();
            String query ="select *from add_customer where number = '"+id+"'";
            
            try{
                
                connection c = new connection();
                ResultSet rs = c.s.executeQuery(query);
                
                while (rs.next()){
                    troom.setText(rs.getString("room_no"));
                    
                }
                
                ResultSet rs2 = c.s.executeQuery("select *from add_rooms where room_num='"+troom.getText()+"'");
                while(rs2.next()){
                    tavailable.setText(rs2.getString("avalability"));
                    tstatus.setText(rs2.getString("status"));
                    
                }
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }
        else if(e.getSource()== update){
            
            String number =customer.getSelectedItem();
            String room= troom.getText();
            String available= tavailable.getText();
            String status = tstatus.getText();
           
            
            try{
                connection c= new connection();
                c.s.executeUpdate("update add_rooms set room_num='"+room+"', avalability='"+available+"',status='"+status+"' where room_num='"+room+"'");
                
                JOptionPane.showMessageDialog(null, "Room's Status Updated Succesfully");
                
                setVisible(false);
                new reception();
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }
        else if(e.getSource()== back){
            
            setVisible(false);
            new reception();
    
        }
         
    }
}


