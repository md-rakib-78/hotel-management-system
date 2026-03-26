package hotelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class bookingRoom extends JFrame implements ActionListener {

    JButton s, can, cheack;
    JTextField Fname, Lname, nid, phone, room, price, age;
    JComboBox av, cs, be;
    String p;
    String pp;
    String avl, avll;
    String cl, cll;
    String bt, btt;

    JLabel lab1;

    bookingRoom() {

        JLabel lab1 = new JLabel("ROOM BOOKING SITE ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 35));
        lab1.setBounds(139, -200, 800, 500);
        lab1.setForeground(Color.WHITE);
        add(lab1);

        // First name 
        JLabel fname = new JLabel("FIRST NAME");
        fname.setBounds(130, 160, 100, 30);
        fname.setForeground(Color.DARK_GRAY);
        add(fname);

        Fname = new JTextField();
        Fname.setBounds(130, 190, 400, 25);
        add(Fname);

        // Last name 
        JLabel lname = new JLabel("LAST NAME");
        lname.setBounds(130, 220, 100, 30);
        lname.setForeground(Color.DARK_GRAY);
        add(lname);

        Lname = new JTextField();
        Lname.setBounds(130, 250, 200, 25);
        add(Lname);

        // Age
        JLabel ag = new JLabel("AGE");
        ag.setBounds(350, 220, 100, 30);
        ag.setForeground(Color.DARK_GRAY);
        add(ag);

        age = new JTextField();
        age.setBounds(350, 250, 180, 25);
        add(age);

        // Nid 
        JLabel ni = new JLabel("NID NO.");
        ni.setBounds(130, 280, 100, 30);
        ni.setForeground(Color.DARK_GRAY);
        add(ni);

        nid = new JTextField();
        nid.setBounds(130, 310, 400, 25);
        add(nid);

        // Phone no
        JLabel p = new JLabel("PHONE NO.");
        p.setBounds(130, 340, 100, 30);
        p.setForeground(Color.DARK_GRAY);
        add(p);

        phone = new JTextField();
        phone.setBounds(130, 370, 400, 25);
        add(phone);

        // Available room   
        JLabel ava = new JLabel("AVAILABILITY");
        ava.setBounds(130, 400, 100, 30);
        ava.setForeground(Color.DARK_GRAY);
        add(ava);

        String[] str = {"Available", "Occupied"};
        av = new JComboBox(str);
        av.setBounds(130, 430, 400, 25);
        av.setBackground(Color.WHITE);
        add(av);

        // Cleaning Status room   
        JLabel cl = new JLabel("CLEANING STATUS");
        cl.setBounds(130, 460, 150, 30);
        cl.setForeground(Color.DARK_GRAY);
        add(cl);

        String[] str1 = {"Cleaned", "Dirty"};
        cs = new JComboBox(str1);
        cs.setBounds(130, 490, 150, 25);
        cs.setBackground(Color.WHITE);
        add(cs);

        // Price
        JLabel pr = new JLabel("PRICE PER DAY");
        pr.setBounds(300, 460, 100, 30);
        pr.setForeground(Color.DARK_GRAY);
        add(pr);

        price = new JTextField();
        price.setBounds(300, 490, 230, 25);
        add(price);

        // Bed type  
        JLabel b = new JLabel("Bed Type");
        b.setBounds(130, 520, 100, 30);
        b.setForeground(Color.DARK_GRAY);
        add(b);

        String[] str2 = {"Single", "Double"};
        be = new JComboBox(str2);
        be.setBounds(130, 550, 100, 25);
        be.setBackground(Color.WHITE);
        add(be);

        // Room no
        JLabel r = new JLabel("ROOM NO.");
        r.setBounds(130, 580, 100, 30);
        r.setForeground(Color.DARK_GRAY);
        add(r);

        room = new JTextField();
        room.setBounds(130, 610, 100, 25);
        add(room);

        //Room no cheak button
        cheack = new JButton("CHEACK");
        cheack.setBounds(230, 610, 90, 25);
        cheack.setBackground(Color.DARK_GRAY);
        cheack.setForeground(Color.WHITE);
        cheack.addActionListener(this);
        add(cheack);

        /// Submit button
        s = new JButton("SUBMIT");
        s.setBounds(130, 700, 400, 25);
        s.setBackground(Color.DARK_GRAY);
        s.addActionListener(this);
        s.setForeground(Color.CYAN);
        add(s);

        /// CANCEL button
        can = new JButton("CANCEL");
        can.setBounds(130, 730, 400, 25);
        can.setBackground(Color.DARK_GRAY);
        can.addActionListener(this);
        can.setForeground(Color.RED);
        add(can);

        //Uper layout
        JTable table2 = new JTable();
        table2.setBounds(0, 0, 1600, 130);
        table2.setBackground(Color.DARK_GRAY);
        add(table2);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(400, 0, 700, 1090);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String room_no = room.getText();

        String pho = phone.getText();

        String ni = nid.getText();

        String agnum = age.getText();

        String nam = Fname.getText();

        if (e.getSource() == cheack) {
            try {
                dbmsCon c = new dbmsCon();

                String q4 = "select* from addroom where Room_No = '" + room_no + "'";
                ResultSet res = c.s.executeQuery(q4);

                while (res.next()) {

                    price.setText(res.getString("Price"));
                    av.setSelectedItem(res.getString("Available"));
                    cs.setSelectedItem(res.getString("Cleaning_Status"));
                    be.setSelectedItem(res.getString("Bed_Type"));

                }

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        }

        if (e.getSource() == s) {

            boolean b = false;
            boolean bo = false;
            boolean boo = false;
            boolean booo = false;

            try {
                dbmsCon c = new dbmsCon();

                String q5 = "select* from addroom where Room_No = '" + room_no + "'";

                ResultSet res = c.s.executeQuery(q5);

                if (res.next()) {
                    this.pp = res.getString("Price");
                    this.avll = res.getString("Available");
                    this.cll = res.getString("Cleaning_Status");
                    this.btt = res.getString("Bed_Type");

                }

            } catch (Exception eu) {
                eu.printStackTrace();
            }

            this.p = price.getText();
            this.avl = (String) av.getSelectedItem();
            this.cl = (String) cs.getSelectedItem();
            this.bt = (String) be.getSelectedItem();

            b = pp.equals(p);
            bo = avll.equals(avl);
            boo = cll.equals(cl);
            booo = btt.equals(bt);

            System.out.println(avll);

            if (b == false) {
                JOptionPane.showMessageDialog(null, "Invalid Price Sorry we can not booked your room!");
                return;
            }

            if (avll.equals("Occupied")) {
                JOptionPane.showMessageDialog(null, "Room all ready Occupied ! Choose anothor room!");
                return;
            }

            if (bo == false) {
                JOptionPane.showMessageDialog(null, "Invalid Room Available Sorry we can not booked your room!");
                return;
            }

            if (cll.equals("Dirty")) {
                JOptionPane.showMessageDialog(null, "Invalid cleaning status Sorry we can not booked your room!");
                return;
            }

            if (boo == false) {
                JOptionPane.showMessageDialog(null, "Invalid Cleaning Status Sorry we can not booked your room yet now!");
                return;
            }

            if (booo == false) {
                JOptionPane.showMessageDialog(null, "Invalid  Bed Type Sorry we can not booked your room!");
                return;
            }

            if (ni.equals("")) {
                JOptionPane.showMessageDialog(null, "Guest NID no. must be fill up!");
                return;
            }

            if (pho.equals("")) {
                JOptionPane.showMessageDialog(null, "Guest phone no. must be fill up!");
                return;
            }

            int ag = Integer.parseInt(agnum);

            if (18 > ag) {
                JOptionPane.showMessageDialog(null, "You should must be 18 years old!");
                return;
            }

            try {

                dbmsCon cc = new dbmsCon();

                this.avl = "Occupied";
                this.cl = "Dirty";

                String qu = "insert into bookedroom values('" + room_no + "','" + ni + "','" + nam + "','" + agnum + "','" + pho + "')";
                String que = "Update addroom set Available = '" + avl + "',Cleaning_Status ='"+cl+"' where Room_No = '" + room_no + "'";

                cc.s.executeUpdate(qu);
                cc.s.executeUpdate(que);

                setVisible(false);
                JOptionPane.showMessageDialog(null, room_no + " room sucessfully booked !");

                new OnlineReception();

            } catch (Exception elu) {
                elu.printStackTrace();
            }

        }

        if (e.getSource() == can) {
            setVisible(false);
            new OnlineReception();
        }

    }

    public static void main(String[] args) {

        new bookingRoom();

    }

}
