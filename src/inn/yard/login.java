
package inn.yard;

import javax.swing.*;
import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class login extends JFrame implements ActionListener{
    
    JTextField username;
    JButton login, cancel;
    JPasswordField pass;
    
    login(){
        
        getContentPane().setBackground(colors.INSTANCE.loginBackground());
        
        setLayout(null);
        
        JLabel user = new JLabel("Username :");
        user.setBounds(50, 30, 110, 40);
        add(user);
        username = new JTextField();
        username.setBounds(170,30,170,40);
        add(username);
        
        JLabel password = new JLabel("Password :");
        password.setBounds(50, 90, 110, 40);
        add(password);
        pass = new JPasswordField();
        pass.setBounds(170,90,170,40);
        add(pass);
        
        login = new JButton("Login");
        login.setBounds(50, 180, 120,40);
        login.setBackground(colors.INSTANCE.loginButtonb());
        login.setForeground(colors.INSTANCE.loginButtonf());
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(210, 180, 120,40);
        cancel.setBackground(colors.INSTANCE.loginButtonb());
        cancel.setForeground(colors.INSTANCE.loginButtonf());
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image i2 = i1.getImage().getScaledInstance(180, 190, SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,25,180,190);
        add(image);
        
       
        
        
        
        setBounds(700, 350, 630, 320);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == login){
            
            String user = username.getText();
            String passw = pass.getText();
            
           
            
            try{
                
                connection c = new connection();
                
                 String query = "select *from login where username = '"+ user +"' and password = '"+ passw +"'";
            
            ResultSet rs = c.s.executeQuery(query);
            
            if(rs.next()){
                
                setVisible(false);
                new dashboard();
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new login();
    }
}
