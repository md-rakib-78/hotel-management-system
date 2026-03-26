package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class viewEmployee extends JFrame implements ActionListener {

    JTable table;
    JButton de, ue, ex, se, al;
    JTextField s, d;

    viewEmployee() {
        JLabel ad = new JLabel("EMPLOYEE INFORMATION");
        ad.setFont(new Font("Tohoma", Font.BOLD, 40));
        ad.setBounds(500, -120, 800, 300);
        ad.setForeground(Color.DARK_GRAY);
        add(ad);

        // Searche employee
        se = new JButton("SEARCHE");
        se.setBounds(200, 130, 100, 35);
        se.setBackground(Color.CYAN);
        se.setForeground(Color.DARK_GRAY);
        se.addActionListener(this);
        add(se);

        /// Search text field
        s = new JTextField();
        s.setBounds(10, 130, 200, 35);
        s.setBackground(Color.WHITE);
        add(s);

        // Delete Employee  Button
        de = new JButton("DELETE");
        de.setBounds(200, 180, 100, 35);
        de.setBackground(Color.DARK_GRAY);
        de.setForeground(Color.WHITE);
        de.addActionListener(this);
        add(de);

        /// Delete text field
        d = new JTextField();
        d.setBounds(10, 180, 200, 35);
        d.setBackground(Color.WHITE);
        add(d);

// All Employee  Info
        al = new JButton("LOAD ALL EMPLOYEE INFO");
        al.setBounds(10, 230, 200, 35);
        al.setBackground(Color.DARK_GRAY);
        al.setForeground(Color.WHITE);
        al.addActionListener(this);
        add(al);

        // Update Employee  info Button
        ue = new JButton("UPDATE EMPLOYEE INFO");
        ue.setBounds(10, 280, 200, 35);
        ue.setBackground(Color.DARK_GRAY);
        ue.setForeground(Color.WHITE);
        ue.addActionListener(this);
        add(ue);

        // Exit 
        ex = new JButton("EXIT");
        ex.setBounds(10, 330, 200, 35);
        ex.setBackground(Color.DARK_GRAY);
        ex.setForeground(Color.CYAN);
        ex.addActionListener(this);
        add(ex);

        JLabel l1 = new JLabel("NAME");
        l1.setBounds(350, 100, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("AGE");
        l2.setBounds(465, 100, 100, 30);
        add(l2);

        JLabel l3 = new JLabel("SALARY");
        l3.setBounds(580, 100, 100, 30);
        add(l3);

        JLabel l4 = new JLabel("NATIONALITY");
        l4.setBounds(700, 100, 100, 30);
        add(l4);

        JLabel l5 = new JLabel("NID");
        l5.setBounds(815, 100, 100, 30);
        add(l5);

        JLabel l6 = new JLabel("PHONE NO.");
        l6.setBounds(930, 100, 100, 30);
        add(l6);

        JLabel l7 = new JLabel("EMAIL");
        l7.setBounds(1050, 100, 100, 30);
        add(l7);

        JLabel l8 = new JLabel("GENDER");
        l8.setBounds(1165, 100, 100, 30);
        add(l8);

        JLabel l9 = new JLabel("POSITION");
        l9.setBounds(1285, 100, 100, 30);
        add(l9);

        JLabel l10 = new JLabel("EMP ID");
        l10.setBounds(1400, 100, 100, 30);
        add(l10);

        /// Table Layout size
        table = new JTable();
        table.setBounds(350, 130, 1160, 640);
        table.setBackground(Color.LIGHT_GRAY);
        add(table);

        setLayout(null);
        setSize(19290, 1090);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = s.getText();
        String nam = s.getText();
        String io = d.getText();

        if (e.getSource() == al) {

            try {
                dbmsCon c = new dbmsCon();
                ResultSet rs = c.s.executeQuery("select* from addemployee");

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ee) {
                ee.printStackTrace();
            }

        }

        /// Search condition
        if (e.getSource() == se) {

            try {
                
                dbmsCon c = new dbmsCon();
                String q2 = "select* from addemployee where id='" + id + "'or Name='" + nam + "'";
                ResultSet rs = c.s.executeQuery(q2);

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception a) {
                a.printStackTrace();
            }

        }

        if (e.getSource() == de) {

            try {

                dbmsCon c = new dbmsCon();

                String qu = "Delete from addemployee where id='" + io + "'";

                c.s.executeUpdate(qu);

                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!!");
            } catch (Exception o) {
                o.printStackTrace();
            }

        }

        if (e.getSource() == ue) {

            setVisible(false);
            new updateEmployee();

        }

        if (e.getSource() == ex) {
            setVisible(false);
            new employee();
        }

    }

    public static void main(String[] args) {

        new viewEmployee();

    }

}
