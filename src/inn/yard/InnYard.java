
package inn.yard;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class  InnYard extends JFrame implements ActionListener{
    
    InnYard ( )
    {
       setSize(1000,798);
       setLocation(470,146);
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/1.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(0,0,1000,798);//location x, location y, length , breath
       add(image);
       
       JLabel text = new JLabel("Welcome to Inn Yard");
       text.setBounds(20, 25, 1000, 80);
       text.setForeground(colors.INSTANCE.primaryColor());
       text.setFont(new Font("serif", Font.PLAIN, 70));
       image.add(text);
       
       JButton next = new JButton("Next");
       next.setBounds(870,700,100,30);
       next.setBackground(colors.INSTANCE.nextBackground());
       next.setForeground(colors.INSTANCE.nextFont());
       next.addActionListener(this);
       next.setFont(new Font("serif", Font.PLAIN, 18));
       image.add(next);
       
       setVisible(true);
       
       /*while(true){
           text.setVisible(false);
           try{
               Thread.sleep(500);
           }catch(Exception e)
           {
               e.printStackTrace();
           }
           text.setVisible(true);
           try{
               Thread.sleep(500);
           }catch(Exception e)
           {
               e.printStackTrace();
           }
       }*/
       
       
    }
    
    public void actionPerformed(ActionEvent ae){
      setVisible(false);
      new login( );
    }

   
    public static void main(String[] args) {
        
        new InnYard( );
        
    }

    
    
}
