

package inn.yard;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;




public class search_room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    
    search_room(){
        
        setLayout(null);
       
        
        JLabel text= new JLabel("Search For Room");
        text.setFont(new Font("Tahoma",Font.BOLD,26));
        text.setForeground(colors.INSTANCE.room_table_head());
        text.setBounds(370,20,300,60);
        add(text);
        
        JLabel  bedtype1 = new JLabel("Bed Type:");
        bedtype1.setFont(new Font("Tahoma",Font.PLAIN,16));
        bedtype1.setForeground(colors.INSTANCE.room_table_head());
        bedtype1.setBounds(60,100,100,25);
        add(bedtype1);
        
        bedtype = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setForeground(colors.INSTANCE.room_table_head());
        bedtype.setBackground(colors.INSTANCE.room_bg());
        add(bedtype);
        
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,250,25);
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        available.setForeground(colors.INSTANCE.room_table_head());
        available.setBackground(colors.INSTANCE.room_bg());
        add(available);
        
        JLabel room_no = new JLabel("Room Number");
        room_no.setForeground(colors.INSTANCE.room_table_head());
        room_no.setBounds(15,80,100,200);
        add(room_no);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(200,80,100,200);
        availability.setForeground(colors.INSTANCE.room_table_head());
        add(availability);
        
        JLabel status = new JLabel("Status");
        status.setBounds(400,80,100,200);
        status.setForeground(colors.INSTANCE.room_table_head());
        add(status);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(600,80,100,200);
        l4.setForeground(colors.INSTANCE.room_table_head());
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(800,80,100,200);
        l5.setForeground(colors.INSTANCE.room_table_head());
        add(l5);
        
        back = new JButton("BACK");
        back.setFont(new Font("Tohoma", Font.BOLD, 18));
        back.setBackground(colors.INSTANCE.room_button_bg());
        back.setForeground(colors.INSTANCE.room_bg());
        back.setBounds(500,450,120,40);
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Tohoma", Font.BOLD, 18));
        submit.setBackground(colors.INSTANCE.room_button_bg());
        submit.setForeground(colors.INSTANCE.room_bg());
        submit.setBounds(300,450,120,40);
        submit.addActionListener(this);
        add(submit);

        
        
        
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
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
        
        
        setBounds(450,200,1000,600);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        
        new search_room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == submit){
            
            try{
            
            connection c = new connection();
            
            String q1  = "select * from add_rooms where bed_type = '"+bedtype.getSelectedItem()+"'";
            String q2  = "select * from add_rooms where avalability = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"' ";
            
            ResultSet rs;
            
            if(available.isSelected()){
               rs = c.s.executeQuery(q2);  
            }
            else{
               rs = c.s.executeQuery(q1);  
            }
           
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ae)
        {
            ae.printStackTrace();
        }
        
            
            
        }
        else if(e.getSource() == back){
        setVisible(false);
        new reception();
        }
        
    }
    
}
