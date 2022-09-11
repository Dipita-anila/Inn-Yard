


package inn.yard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class add_employee extends JFrame implements ActionListener {
    
    JTextField tname, tage,tsalary,tphone, temail;
    JRadioButton rmale,rfemale;
    JComboBox cjob;
    JButton submit_btn,cancel;
    
   add_employee( ){
      
       setLayout(null);
       
       JLabel name = new JLabel("NAME");
       name.setBounds(60,40,120,30);
       name.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(name);
       
       tname = new JTextField();
       tname.setBounds(200,40,150,30);
       add(tname);
       
       JLabel age = new JLabel("AGE");
       age.setBounds(60,100,120,30);
       age.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(age);
       
        tage = new JTextField();
       tage.setBounds(200,100,150,30);
       add(tage);
       
       JLabel gender = new JLabel("GENDER");
       gender.setBounds(60,155,120,30);
       gender.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(gender);
       
       rmale = new JRadioButton("Male");
       rmale.setBounds(200,155,70,30);
       rmale.setFont(new Font("Tohoma",Font.PLAIN,14));
       rmale.setBackground(colors.INSTANCE.add_emoloyee_background());
       add(rmale);
       
       rfemale = new JRadioButton("Female");
       rfemale.setBounds(280,155,90,30);
       rfemale.setFont(new Font("Tohoma",Font.PLAIN,14));
       rfemale.setBackground(colors.INSTANCE.add_emoloyee_background());
       add(rfemale);
       
       ButtonGroup bg = new ButtonGroup();
       bg.add(rmale);
       bg.add(rfemale);
       
       JLabel job = new JLabel("JOB");
       job.setBounds(60,204,120,30);
       job.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(job);
       
       
       String str[] = { "Front Desk Clerks", "Porters", "House Keeping", "Kitchen Stuff", "Room Service", "Chefs","Waiters/Waitress","Manager","Accountants"};
       cjob = new JComboBox(str);
       cjob.setBounds(200,204,150,30);
       cjob.setBackground(colors.INSTANCE.add_emoloyee_background());
       add(cjob);
       
       JLabel salary = new JLabel("SALARY");
       salary .setBounds(60,260,120,30);
       salary .setFont(new Font("Tahoma",Font.PLAIN,17));
       add(salary );
       
       tsalary = new JTextField();
       tsalary.setBounds(200,260,150,30);
       add(tsalary);
       
       JLabel phone = new JLabel("PHONE");
       phone .setBounds(60,310,120,30);
       phone .setFont(new Font("Tahoma",Font.PLAIN,17));
       add(phone );
       
       tphone = new JTextField();
       tphone.setBounds(200,310,150,30);
       add(tphone);
       
       JLabel email = new JLabel("EMAIL");
       email .setBounds(60,360,120,30);
       email .setFont(new Font("Tahoma",Font.PLAIN,17));
       add(email);
       
       temail = new JTextField();
       temail.setBounds(200,360,150,30);
       add(temail);
       
       submit_btn = new JButton("SUBMIT");
       submit_btn.setBackground(colors.INSTANCE.add_e_submit_b_back());
       submit_btn.setForeground(colors.INSTANCE.add_e_submit_button());
       submit_btn.setBounds(60, 430, 130, 33);
       submit_btn.setFont(new Font("Tahoma",Font.BOLD,16));
       submit_btn.addActionListener(this);
       add(submit_btn);
       
     

        cancel = new JButton("CANCEL");
        cancel.setBackground(colors.INSTANCE.add_e_submit_b_back());
        cancel.setForeground(colors.INSTANCE.add_e_submit_button());
        cancel.setBounds(220, 430, 130, 33);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/add_employee.png"));
       Image i2 =i1.getImage().getScaledInstance(440,470,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i1);
       image.setBounds(380,2,440,470);
       add(image);
       
   
       
       
       getContentPane().setBackground(colors.INSTANCE.add_emoloyee_background());
       setBounds(550,250,850,540);
       setVisible(true);
       
       
   } 
   
   public static void main(String[] args){
       
       new add_employee();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== submit_btn){
        
        String name = tname.getText();
        String age = tage.getText();
        String salary = tsalary.getText();
        String phone = tphone.getText();
        String email = temail.getText();
        
        String gender = null;
        
        if(rmale.isSelected()){
            gender ="Male";
        }
        else if(rfemale.isSelected()){
            gender = "Female";
        }
        
        String job = (String)cjob.getSelectedItem();
        
        try{
            
            connection conn = new connection();
            
            String query ="insert into add_employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"')";
            
           if(name.equals("")) {
               
               JOptionPane.showMessageDialog(null,"Name feild is null");
        
           }else if (age.equals("")){
               JOptionPane.showMessageDialog(null,"Age feild is null");
           
           }
           else if(gender.equals("")){
               JOptionPane.showMessageDialog(null,"Gender feild is null");
           }
           else if(job.equals("")){
               JOptionPane.showMessageDialog(null,"Job feild is null");
           }
           else if(salary.equals("")){
               JOptionPane.showMessageDialog(null,"salary feild is null");
           }
           else if(phone.equals("")){
               JOptionPane.showMessageDialog(null,"Phone feild is null");
           }
           else if(email.equals("")){
               JOptionPane.showMessageDialog(null,"Email feild is null");
           }else{
    
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added succesflly");
            
            setVisible(false);}
            
            
        }catch(Exception ae){
            System.out.println(ae);
        }
        
        

    }else{
            setVisible(false);
        }
    }
}

    

