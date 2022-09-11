


package inn.yard;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;



public class update_check extends JFrame implements ActionListener{
    
    Choice customer;
    JTextField troom, tname, tcheckin, tpaid, tpending;
    JButton check, update,back;
    
   update_check(){
       
       getContentPane().setBackground(colors.INSTANCE.room_bg());
       setLayout(null);
       
       JLabel text = new JLabel("UPDATE STATUS");
       text.setFont(new Font("Tahoma",Font.PLAIN,22));
       text.setForeground(colors.INSTANCE.room_table_head());
       text.setBounds(90,20,200,30);
       add(text);
       
       JLabel id = new JLabel("Customer ID");
       id.setFont(new Font("Tahoma",Font.PLAIN,16));
       id.setForeground(colors.INSTANCE.room_table_head());
       id.setBounds(30,80,100,20);
       add(id);
       
       customer = new Choice();
       customer.setBounds(200,80,150,25);
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
       room.setBounds(30,120,150,20);
       add(room);
       
       troom = new JTextField();
       troom.setBounds(200,120,150,25);
       add(troom);
       
       JLabel name = new JLabel("Name ");
       name.setFont(new Font("Tahoma",Font.PLAIN,16));
       name.setForeground(colors.INSTANCE.room_table_head());
       name.setBounds(30,160,100,20);
       add(name);
       
       tname = new JTextField();
       tname.setBounds(200,160,150,25);
       add(tname);
       
       JLabel checkin = new JLabel("CheckIn Time");
       checkin.setFont(new Font("Tahoma",Font.PLAIN,16));
       checkin.setForeground(colors.INSTANCE.room_table_head());
       checkin.setBounds(30,200,100,20);
       add(checkin);
       
       tcheckin = new JTextField();
       tcheckin.setBounds(200,200,150,25);
       add(tcheckin);
       
       JLabel paid = new JLabel("Amount Paid");
       paid.setFont(new Font("Tahoma",Font.PLAIN,16));
       paid.setForeground(colors.INSTANCE.room_table_head());
       paid.setBounds(30,240,100,20);
       add(paid);
       
       tpaid = new JTextField();
       tpaid.setBounds(200,240,150,25);
       add(tpaid);
       
       JLabel pending = new JLabel("Pending Amount");
       pending.setFont(new Font("Tahoma",Font.PLAIN,16));
       pending.setForeground(colors.INSTANCE.room_table_head());
       pending.setBounds(30,280,170,20);
       add(pending);
       
       tpending = new JTextField();
       tpending.setBounds(200,280,150,25);
       add(tpending);
       
       back = new JButton("BACK");
       back.setFont(new Font("Tohoma", Font.BOLD, 18));
       back.setBackground(colors.INSTANCE.room_button_bg());
       back.setForeground(colors.INSTANCE.room_bg());
       back.setBounds(125,400,130,35);
       back.addActionListener(this);
       add(back);
       
       check = new JButton("CHECK");
       check.setFont(new Font("Tohoma", Font.BOLD, 18));
       check.setBackground(colors.INSTANCE.room_button_bg());
       check.setForeground(colors.INSTANCE.room_bg());
       check.setBounds(35,340,130,35);
       check.addActionListener(this);
       add(check);
       
       update = new JButton("UPDATE");
       update.setFont(new Font("Tohoma", Font.BOLD, 18));
       update.setBackground(colors.INSTANCE.room_button_bg());
       update.setForeground(colors.INSTANCE.room_bg());
       update.setBounds(205,340,130,35);
       update.addActionListener(this);
       add(update);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/new.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,350, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(390,55,400,350);
        add(image);
       
       
       setBounds(510,290,850,500);
       setVisible(true);
   } 
    
   public static void main(String[] args){
       new update_check();
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
                    tname.setText(rs.getString("name"));
                    tcheckin.setText(rs.getString("time"));
                    tpaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2 = c.s.executeQuery("select *from add_rooms where room_num='"+troom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amount_paid = Integer.parseInt(price) - Integer.parseInt(tpaid.getText());
                    tpending.setText(""+amount_paid);
                    
                }
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
        }
        else if(e.getSource()== update){
            
            String id =customer.getSelectedItem();
            String room= troom.getText();
            String name= tname.getText();
            String checkIn= tcheckin.getText();
            String deposit= tpaid.getText();
            String pending= tpending.getText();
            
            try{
                connection c= new connection();
                 
                c.s.executeUpdate("update add_customer set room_no= '"+room+"', name='"+name+"', time='"+checkIn+"', deposit='"+deposit+"' where number='"+id+"'");
                
               
                
                JOptionPane.showMessageDialog(null, "Data Updated Succesfully");
                
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
