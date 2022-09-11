

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




public class manager_info extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    manager_info(){
        
        setLayout(null);
       
        JLabel heading = new JLabel("MANAGERS  INFORMATION");
        heading.setFont(new Font("Tohoma", Font.BOLD, 19));
        heading.setForeground(colors.INSTANCE.room_heading());
        heading.setBounds(360, 25, 400, 30);
        add(heading);
        
        JLabel room_no = new JLabel("NAME");
        room_no.setForeground(colors.INSTANCE.room_table_head());
        room_no.setBounds(10,0,100,200);
        add(room_no);
        
        JLabel availability = new JLabel("AGE");
        availability.setBounds(155,0,100,200);
        availability.setForeground(colors.INSTANCE.room_table_head());
        add(availability);
        
        JLabel status = new JLabel("GENDER");
        status.setBounds(297,0,100,200);
        status.setForeground(colors.INSTANCE.room_table_head());
        add(status);
        
        JLabel l4 = new JLabel("JOB");
        l4.setBounds(440,0,100,200);
        l4.setForeground(colors.INSTANCE.room_table_head());
        add(l4);
        
        JLabel l5 = new JLabel("SALARY");
        l5.setBounds(582,0,100,200);
        l5.setForeground(colors.INSTANCE.room_table_head());
        add(l5);
        
        JLabel l6 = new JLabel("PHONE");
        l6.setBounds(725,0,100,200);
        l6.setForeground(colors.INSTANCE.room_table_head());
        add(l6);
        
        JLabel l7 = new JLabel("EMAIL");
        l7.setBounds(870,0,100,200);
        l7.setForeground(colors.INSTANCE.room_table_head());
        add(l7);
        
        back = new JButton("Back");
        back.setFont(new Font("Tohoma", Font.BOLD, 18));
        back.setBackground(colors.INSTANCE.room_button_bg());
        back.setForeground(colors.INSTANCE.room_bg());
        back.setBounds(410,450,120,40);
        back.addActionListener(this);
        add(back);
        
        
        
        
        table = new JTable();
        table.setBounds(10,130,1000,500);
        table.setBackground(colors.INSTANCE.room_bg());
        add(table);
        
        try{
            
            connection c = new connection();

            ResultSet rs = c.s.executeQuery("select *from add_employee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        
         getContentPane().setBackground(colors.INSTANCE.room_bg());
        
        
        setBounds(440,250,1000,600);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        
        new manager_info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new reception();
        
    }
    
}
