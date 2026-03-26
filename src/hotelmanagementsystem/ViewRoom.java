package hotelmanagementsystem;

import hotelmanagementsystem.dbmsCon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class ViewRoom extends JFrame implements ActionListener {

    JTable table;
    JButton sr, dr, ar, ex;
    JTextField r;

    ViewRoom() {

        JLabel ad = new JLabel("ROOM MANAGING");
        ad.setFont(new Font("Tohoma", Font.BOLD, 40));
        ad.setBounds(600, -115, 800, 300);
        ad.setForeground(Color.DARK_GRAY);
        add(ad);

        // Searche employee
        sr = new JButton("SEARCHE");
        sr.setBounds(200, 130, 100, 35);
        sr.setBackground(Color.CYAN);
        sr.setForeground(Color.DARK_GRAY);
        sr.addActionListener(this);
        add(sr);

        /// Search text field
        r = new JTextField();
        r.setBounds(10, 130, 200, 35);
        r.setBackground(Color.WHITE);
        add(r);

        // Delete Employee  Button
        dr = new JButton("DELETE");
        dr.setBounds(200, 180, 100, 35);
        dr.setBackground(Color.DARK_GRAY);
        dr.setForeground(Color.RED);
        dr.addActionListener(this);
        add(dr);

        // All Room  Info
        ar = new JButton("LOAD ALL ROOM");
        ar.setBounds(10, 390, 300, 85);
        ar.setBackground(Color.DARK_GRAY);
        ar.setForeground(Color.WHITE);
        ar.addActionListener(this);
        add(ar);

        // Exit 
        ex = new JButton("EXIT");
        ex.setBounds(70, 710, 150, 35);
        ex.setBackground(Color.DARK_GRAY);
        ex.setForeground(Color.CYAN);
        ex.addActionListener(this);
        add(ex);
        
        
        
        
        
         JLabel l1 = new JLabel("ROOM NO.");
        l1.setBounds(350, 100, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("AVAILABLE");
        l2.setBounds(580, 100, 100, 30);
        add(l2);

        JLabel l3 = new JLabel("CLEANING STATUS");
        l3.setBounds(820, 100, 160, 30);
        add(l3);

        JLabel l4 = new JLabel("PRICE");
        l4.setBounds(1050, 100, 100, 30);
        add(l4);

        JLabel l5 = new JLabel("BED TYPE");
        l5.setBounds(1275, 100, 100, 30);
        add(l5);


        /// Table Layout size
        table = new JTable();
        table.setBounds(350, 130, 1160, 640);
        table.setBackground(Color.LIGHT_GRAY);
        add(table);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String rn = r.getText();

        if (e.getSource() == ar) {

            try {
                dbmsCon c = new dbmsCon();
                ResultSet rs = c.s.executeQuery("select* from addroom");

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ee) {
                ee.printStackTrace();
            }

        }

        if (e.getSource() == sr) {

            try {
                dbmsCon c = new dbmsCon();
                String q2 = "select* from addroom where Room_No ='" + rn + "'";
                ResultSet rs = c.s.executeQuery(q2);

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception a) {
                a.printStackTrace();
            }
        }

        if (e.getSource() == dr) {

            try {

                dbmsCon c = new dbmsCon();

                String qu = "Delete from addroom where Room_No ='" + rn + "'";

                c.s.executeUpdate(qu);

                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!!");
            } catch (Exception o) {
                o.printStackTrace();
            }

        }

        if (e.getSource() == ex) {
            setVisible(false);
            new room();
          
        }

    }

    public static void main(String[] args) {

        new ViewRoom();

    }

}
