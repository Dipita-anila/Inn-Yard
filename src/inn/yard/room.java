
package inn.yard;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;




public class room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    room(){
        
        setLayout(null);
       
        JLabel heading = new JLabel("ALL ROOMS INFORMATION");
        heading.setFont(new Font("Tohoma", Font.BOLD, 19));
        heading.setForeground(colors.INSTANCE.room_heading());
        heading.setBounds(120, 25, 300, 20);
        add(heading);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/room_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(520,560, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,30,520,500);
        add(image);
        
        JLabel room_no = new JLabel("Room Number");
        room_no.setForeground(colors.INSTANCE.room_table_head());
        room_no.setBounds(10,0,100,200);
        add(room_no);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(120,0,100,200);
        availability.setForeground(colors.INSTANCE.room_table_head());
        add(availability);
        
        JLabel status = new JLabel("Status");
        status.setBounds(222,0,100,200);
        status.setForeground(colors.INSTANCE.room_table_head());
        add(status);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(318,0,100,200);
        l4.setForeground(colors.INSTANCE.room_table_head());
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(408,0,100,200);
        l5.setForeground(colors.INSTANCE.room_table_head());
        add(l5);
        
        back = new JButton("Back");
        back.setFont(new Font("Tohoma", Font.BOLD, 18));
        back.setBackground(colors.INSTANCE.room_button_bg());
        back.setForeground(colors.INSTANCE.room_bg());
        back.setBounds(190,450,120,40);
        back.addActionListener(this);
        add(back);
        
        
        
        
        table = new JTable();
        table.setBounds(10,130,480,390);
        table.setBackground(colors.INSTANCE.room_bg());
        add(table);
        
        try{
            
            connection c = new connection();

            ResultSet rs = c.s.executeQuery("select * from add_rooms");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        
         getContentPane().setBackground(colors.INSTANCE.room_bg());
        
        
        setBounds(450,250,1050,600);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        
        new room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new reception();
        
    }
    
}
