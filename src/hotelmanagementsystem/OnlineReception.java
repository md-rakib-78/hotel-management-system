package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class OnlineReception extends JFrame implements ActionListener {

    JTable table, table1, table2;
    JButton gp, cr, br, si, ex;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;

    OnlineReception() {

        JLabel ad = new JLabel("GUEST SERVICE");
        ad.setFont(new Font("Tohoma", Font.BOLD, 40));
        ad.setBounds(600, -120, 800, 300);
        ad.setForeground(Color.WHITE);
        add(ad);

        // Guest Profile
        gp = new JButton("GUEST PROFILE");
        gp.setBounds(0, 150, 200, 35);
        gp.setBackground(Color.DARK_GRAY);
        gp.setForeground(Color.CYAN);
        gp.addActionListener(this);
        add(gp);

        // Cheak room
        cr = new JButton("CHEAKED ROOM");
        cr.setBounds(0, 185, 200, 35);
        cr.setBackground(Color.DARK_GRAY);
        cr.setForeground(Color.CYAN);
        cr.addActionListener(this);
        add(cr);

        // Cheak room
        br = new JButton("ROOM BOOKING");
        br.setBounds(0, 220, 200, 35);
        br.setBackground(Color.DARK_GRAY);
        br.setForeground(Color.CYAN);
        br.addActionListener(this);
        add(br);

        // Cheak room
        si = new JButton("STUFF INFO");
        si.setBounds(0, 255, 200, 35);
        si.setBackground(Color.DARK_GRAY);
        si.setForeground(Color.CYAN);
        si.addActionListener(this);
        add(si);

        // Cheak room
        ex = new JButton("LOG OUT");
        ex.setBounds(0, 290, 200, 35);
        ex.setBackground(Color.DARK_GRAY);
        ex.setForeground(Color.RED);
        ex.addActionListener(this);
        add(ex);

        // Room column name
        l1 = new JLabel();
        l1.setBounds(355, 125, 100, 30);
        l1.setForeground(Color.CYAN);
        add(l1);

        l2 = new JLabel();
        l2.setBounds(580, 125, 100, 30);
        l2.setForeground(Color.CYAN);
        add(l2);

        l3 = new JLabel();
        l3.setBounds(820, 125, 160, 30);
        l3.setForeground(Color.CYAN);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(1050, 125, 100, 30);
        l4.setForeground(Color.CYAN);
        add(l4);

        l5 = new JLabel();
        l5.setBounds(1275, 125, 100, 30);
        l5.setForeground(Color.CYAN);
        add(l5);

        // Employee coulum name
        l6 = new JLabel();
        l6.setBounds(355, 125, 100, 30);
        l6.setForeground(Color.CYAN);
        add(l6);

        l7 = new JLabel();
        l7.setBounds(465, 125, 100, 30);
        l7.setForeground(Color.CYAN);
        add(l7);

        l8 = new JLabel();
        l8.setBounds(580, 125, 100, 30);
        l8.setForeground(Color.CYAN);
        add(l8);

        l9 = new JLabel();
        l9.setBounds(700, 125, 100, 30);
        l9.setForeground(Color.CYAN);
        add(l9);

        l10 = new JLabel();
        l10.setBounds(815, 125, 100, 30);
        l10.setForeground(Color.CYAN);
        add(l10);

        l11 = new JLabel();
        l11.setBounds(930, 125, 100, 30);
        l11.setForeground(Color.CYAN);
        add(l11);

        l12 = new JLabel();
        l12.setBounds(1050, 125, 100, 30);
        l12.setForeground(Color.CYAN);
        add(l12);

        l13 = new JLabel();
        l13.setBounds(1165, 125, 100, 30);
        l13.setForeground(Color.CYAN);
        add(l13);

        l14 = new JLabel();
        l14.setBounds(1285, 125, 100, 30);
        l14.setForeground(Color.CYAN);
        add(l14);

        l15 = new JLabel();
        l15.setBounds(1400, 125, 100, 30);
        l15.setForeground(Color.CYAN);
        add(l15);

        // Table details
        table = new JTable();
        table.setBounds(350, 155, 1160, 615);
        table.setBackground(Color.WHITE);
        add(table);

        //Uper layout
        table2 = new JTable();
        table2.setBounds(0, 0, 1600, 130);
        table2.setBackground(Color.DARK_GRAY);
        add(table2);

        //side layout
        table1 = new JTable();
        table1.setBounds(0, 130, 350, 640);
        table1.setBackground(Color.lightGray);
        add(table1);

        getContentPane().setBackground(Color.black);
        setLayout(null);
        setSize(19290, 1090);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gp) {
            setVisible(false);
            new GuestProfile();
        }

        if (e.getSource() == cr) {
            
            
            
            l6.setText("");
            l7.setText("");
            l8.setText("");
            l9.setText("");
            l10.setText("");
            l11.setText("");
            l12.setText("");
            l13.setText("");
            l14.setText("");
            l15.setText("");
            
            
            

            l1.setText("Room no");
            l2.setText("AVAILABLE");
            l3.setText("CLEANING STATUS");
            l4.setText("PRICE");
            l5.setText("BED TYPE");

            try {
                dbmsCon c = new dbmsCon();
                ResultSet rs = c.s.executeQuery("select* from addroom");

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

        if (e.getSource() == br) {
            setVisible(false);
            
            new bookingRoom();
        }

        if (e.getSource() == si) {
            
            l1.setText("");
            l2.setText("");
            l3.setText("");
            l4.setText("");
            l5.setText("");
            
            
            
            l6.setText("NAME");
            l7.setText("AGE");
            l8.setText("SALARY");
            l9.setText("NATIONALITY");
            l10.setText("NID");
            l11.setText("PHONE NO.");
            l12.setText("EMAIL");
            l13.setText("GENDER");
            l14.setText("POSITION");
            l15.setText("EMP ID");

            try {
                dbmsCon c = new dbmsCon();
                ResultSet rs = c.s.executeQuery("select* from addemployee");

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception ee) {
                ee.printStackTrace();
            }

        }

        if (e.getSource() == ex) {
            setVisible(false);
            new customerlogin();
        }

    }

    public static void main(String[] args) {

        new OnlineReception();

    }

}
