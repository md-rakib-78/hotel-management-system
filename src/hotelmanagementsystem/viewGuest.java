package hotelmanagementsystem;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class viewGuest extends JFrame implements ActionListener {

    JTable table2, table;
    JTextField se;
    JButton cheak, ex, see, ref;

    viewGuest() {

        JLabel lab1 = new JLabel("GUEST INFO AND CHEAKOUT ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lab1.setBounds(128, -200, 800, 500);
        lab1.setForeground(Color.WHITE);
        add(lab1);

        JLabel l1 = new JLabel("ROOM NO.");
        l1.setBounds(10, 108, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("NID NO.");
        l2.setBounds(150, 108, 100, 30);
        add(l2);

        JLabel l3 = new JLabel("NAME");
        l3.setBounds(290, 108, 100, 30);
        add(l3);

        JLabel l4 = new JLabel("AGE");
        l4.setBounds(430, 108, 100, 30);
        add(l4);

        JLabel l5 = new JLabel("PHONE NO.");
        l5.setBounds(550, 108, 100, 30);
        add(l5);

        // Refresh
        ref = new JButton("REFRESH");
        ref.setBounds(275, 600, 125, 25);
        ref.setBackground(Color.DARK_GRAY);
        ref.setForeground(Color.GREEN);
        ref.addActionListener(this);
        add(ref);

        // Search guest
        see = new JButton("SEARCH");
        see.setBounds(130, 670, 125, 25);
        see.setBackground(Color.DARK_GRAY);
        see.setForeground(Color.WHITE);
        see.addActionListener(this);
        add(see);

        se = new JTextField();
        se.setBounds(255, 670, 275, 25);
        se.setBackground(Color.WHITE);
        add(se);

        /// Cheak button
        cheak = new JButton("CHEACKOUT");
        cheak.setBounds(130, 700, 400, 25);
        cheak.setBackground(Color.DARK_GRAY);
        cheak.addActionListener(this);
        cheak.setForeground(Color.CYAN);
        add(cheak);

        /// EXIT button
        ex = new JButton("EXIT");
        ex.setBounds(130, 730, 400, 25);
        ex.setBackground(Color.DARK_GRAY);
        ex.addActionListener(this);
        ex.setForeground(Color.RED);
        add(ex);

        //Uper layout
        table2 = new JTable();
        table2.setBounds(0, 0, 1600, 105);
        table2.setBackground(Color.DARK_GRAY);
        add(table2);

        /// Table Layout size
        table = new JTable();
        table.setBounds(8, 135, 670, 400);
        table.setBackground(Color.WHITE);
        add(table);

        try {
            dbmsCon c = new dbmsCon();
            ResultSet rs = c.s.executeQuery("select* from bookedroom");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setBounds(400, 0, 700, 1090);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = se.getText();

        if (e.getSource() == ref) {
            setVisible(false);
            new viewGuest();

        }

        if (e.getSource() == see) {
            try {
                dbmsCon c = new dbmsCon();
                String q2 = "select* from bookedroom where Room_No ='" + s + "'";
                ResultSet rs = c.s.executeQuery(q2);

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception a) {
                a.printStackTrace();
            }
        }

        if (e.getSource() == cheak) {

            try {

                dbmsCon c = new dbmsCon();

                String avl = "Available";
                String cl ="Cleaned";

                String qu = "Delete from bookedroom where Room_No ='" + s + "'";
                String que = "Update addroom set Available = '" + avl + "'where Room_No = '" + s + "'";
                String quu = "Update addroom set Cleaning_Status ='"+cl+"'where Room_No = '" + s + "'";

                c.s.executeUpdate(qu);
                c.s.executeUpdate(que);
                c.s.executeUpdate(quu);

                JOptionPane.showMessageDialog(null, "Guest Cheakout Successfully!!");
            } catch (Exception o) {
                o.printStackTrace();
            }
        }

        if (e.getSource() == ex) {
            setVisible(false);
            new admin();
        }

    }

    public static void main(String[] args) {

        new viewGuest();

    }

}
