



package inn.yard;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.Choice;
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




public class pick_up extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    Choice car_type;
    JCheckBox available;
    
    pick_up(){
        
        setLayout(null);
       
        
        JLabel text= new JLabel("PICKUP SERVICE");
        text.setFont(new Font("Tahoma",Font.BOLD,26));
        text.setForeground(colors.INSTANCE.room_table_head());
        text.setBounds(370,20,300,60);
        add(text);
        
        JLabel  bedtype1 = new JLabel("Type of Car:");
        bedtype1.setFont(new Font("Tahoma",Font.PLAIN,16));
        bedtype1.setForeground(colors.INSTANCE.room_table_head());
        bedtype1.setBounds(60,100,100,25);
        add(bedtype1);
        
        car_type = new Choice();
        car_type.setBounds(170,100,150,25);
        car_type.setForeground(colors.INSTANCE.room_table_head());
        car_type.setBackground(colors.INSTANCE.room_bg());
        add(car_type);
        try{
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select *from add_drivers");
            while(rs.next()){
                car_type.add(rs.getString("brand"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        JLabel room_no = new JLabel("Name");
        room_no.setForeground(colors.INSTANCE.room_table_head());
        room_no.setBounds(15,80,100,200);
        add(room_no);
        
        JLabel availability = new JLabel("Age");
        availability.setBounds(145,80,100,200);
        availability.setForeground(colors.INSTANCE.room_table_head());
        add(availability);
        
        JLabel status = new JLabel("Gender");
        status.setBounds(287,80,100,200);
        status.setForeground(colors.INSTANCE.room_table_head());
        add(status);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(430,80,100,200);
        l4.setForeground(colors.INSTANCE.room_table_head());
        add(l4);
        
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(572,80,100,200);
        l5.setForeground(colors.INSTANCE.room_table_head());
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(713,80,100,200);
        l6.setForeground(colors.INSTANCE.room_table_head());
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(857,80,100,200);
        l7.setForeground(colors.INSTANCE.room_table_head());
        add(l7);
        
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

            ResultSet rs = c.s.executeQuery("select * from add_drivers");
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
        
        new pick_up();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == submit){
            
            try{
            
            connection c = new connection();
            
            String q1  = "select * from add_drivers where brand = '"+car_type.getSelectedItem()+"'";
            
            
            ResultSet rs;
            
           
               rs = c.s.executeQuery(q1); 
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

