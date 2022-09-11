
package inn.yard;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class department extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    department() {

        setLayout(null);

        JLabel room_no = new JLabel("Department");
        room_no.setForeground(colors.INSTANCE.room_table_head());
        room_no.setFont(new Font("Tahoma", Font.BOLD, 18));
        room_no.setBounds(100, 10, 200, 20);
        add(room_no);

        JLabel availability = new JLabel("Budget");
        availability.setBounds(390, 10, 100, 20);
        availability.setFont(new Font("Tahoma", Font.BOLD, 18));
        availability.setForeground(colors.INSTANCE.room_table_head());
        add(availability);

        back = new JButton("Back");
        back.setFont(new Font("Tohoma", Font.BOLD, 20));
        back.setBackground(colors.INSTANCE.room_button_bg());
        back.setForeground(colors.INSTANCE.room_bg());
        back.setBounds(235, 350, 120, 40);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setBounds(20, 50, 600, 350);
        table.setBackground(colors.INSTANCE.room_bg());
        add(table);

        try {

            connection c = new connection();

            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(colors.INSTANCE.room_bg());
        setBounds(570, 300, 600, 480);
        setVisible(true);

    }

    public static void main(String[] args) {

        new department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new reception();

    }

}
