package hotelmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class updateEmployee extends JFrame implements ActionListener {

    JButton se, up;
    JTextField s;
    JTable table;

    JTextField name, age, salary, nid, phone, email, nation, gender;
    JButton sub, cancle;
    JRadioButton male, female;
    JComboBox post;
    ButtonGroup bg;

    updateEmployee() {

        // Title Update Employee
        JLabel lab1 = new JLabel("UPDATE EMPLOYEE INFO");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lab1.setBounds(470, -180, 800, 500);
        lab1.setForeground(Color.DARK_GRAY);
        add(lab1);

        // Searche employee
        se = new JButton("SEARCHE");
        se.setBounds(1050, 130, 100, 35);
        se.setBackground(Color.CYAN);
        se.setForeground(Color.DARK_GRAY);
        se.addActionListener(this);
        add(se);

        /// Search text field
        s = new JTextField();
        s.setBounds(350, 130, 700, 35);
        s.setBackground(Color.WHITE);
        add(s);

        JLabel l1 = new JLabel("NAME");
        l1.setBounds(355, 210, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("AGE");
        l2.setBounds(435, 210, 100, 30);
        add(l2);

        JLabel l3 = new JLabel("SALARY");
        l3.setBounds(515, 210, 100, 30);
        add(l3);

        JLabel l4 = new JLabel("NATIONALITY");
        l4.setBounds(590, 210, 100, 30);
        add(l4);

        JLabel l5 = new JLabel("NID");
        l5.setBounds(685, 210, 100, 30);
        add(l5);

        JLabel l6 = new JLabel("PHONE NO.");
        l6.setBounds(750, 210, 100, 30);
        add(l6);

        JLabel l7 = new JLabel("EMAIL");
        l7.setBounds(850, 210, 100, 30);
        add(l7);

        JLabel l8 = new JLabel("GENDER");
        l8.setBounds(910, 210, 100, 30);
        add(l8);

        JLabel l9 = new JLabel("POSITION");
        l9.setBounds(990, 210, 100, 30);
        add(l9);

        JLabel l10 = new JLabel("EMP ID");
        l10.setBounds(1090, 210, 100, 30);
        add(l10);

        // Name
        JLabel nam = new JLabel("NEW NAME");
        nam.setFont(new Font("Tohoma", Font.BOLD, 20));
        nam.setBounds(100, 250, 200, 100);
        nam.setForeground(Color.black);
        add(nam);

        name = new JTextField();
        name.setBounds(300, 290, 250, 35);
        name.setBackground(Color.WHITE);
        add(name);

        // Email
        JLabel e = new JLabel("NEW EMAIL");
        e.setFont(new Font("Tohoma", Font.BOLD, 20));
        e.setBounds(800, 250, 200, 100);
        e.setForeground(Color.black);
        add(e);

        email = new JTextField();
        email.setBounds(1000, 290, 250, 35);
        email.setBackground(Color.WHITE);
        add(email);

        // Age
        JLabel agee = new JLabel("NEW AGE");
        agee.setFont(new Font("Tohoma", Font.BOLD, 20));
        agee.setBounds(100, 325, 200, 100);
        agee.setForeground(Color.black);
        add(agee);

        age = new JTextField();
        age.setBounds(300, 355, 250, 35);
        age.setBackground(Color.WHITE);
        add(age);

        //Gender
        JLabel gen = new JLabel("NEW GENDER");
        gen.setFont(new Font("Tohoma", Font.BOLD, 20));
        gen.setBounds(800, 325, 200, 100);
        gen.setForeground(Color.BLACK);
        add(gen);

        male = new JRadioButton("male");
        male.setBounds(1000, 355, 100, 30);
        male.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(male);

        female = new JRadioButton("female");
        female.setBounds(1080, 355, 100, 30);
        female.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(female);

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        // Salary
        JLabel sal = new JLabel("NEW SALARY");
        sal.setFont(new Font("Tohoma", Font.BOLD, 20));
        sal.setBounds(100, 380, 200, 100);
        sal.setForeground(Color.black);
        add(sal);

        salary = new JTextField();
        salary.setBounds(300, 415, 250, 35);
        salary.setBackground(Color.WHITE);
        add(salary);

        //Job Post
        JLabel job = new JLabel("NEW JOB POST");
        job.setFont(new Font("Tohoma", Font.BOLD, 20));
        job.setBounds(800, 380, 200, 100);
        job.setForeground(Color.black);
        add(job);

        String[] str = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter", "Manager", "Accountant"};
        post = new JComboBox(str);
        post.setBounds(1000, 415, 200, 30);
        post.setBackground(Color.WHITE);
        add(post);

        // nationality
        JLabel nal = new JLabel("NEW NATIONALITY");
        nal.setFont(new Font("Tohoma", Font.BOLD, 20));
        nal.setBounds(100, 450, 200, 100);
        nal.setForeground(Color.black);
        add(nal);

        nation = new JTextField();
        nation.setBounds(300, 480, 250, 35);
        nation.setBackground(Color.WHITE);
        add(nation);

        // Nid
        JLabel ni = new JLabel("NEW NID");
        ni.setFont(new Font("Tohoma", Font.BOLD, 20));
        ni.setBounds(100, 510, 200, 100);
        ni.setForeground(Color.black);
        add(ni);

        nid = new JTextField();
        nid.setBounds(300, 540, 250, 35);
        nid.setBackground(Color.WHITE);
        add(nid);

        // Phone
        JLabel p = new JLabel("NEW PHONE NO.");
        p.setFont(new Font("Tohoma", Font.BOLD, 20));
        p.setBounds(100, 570, 200, 100);
        p.setForeground(Color.black);
        add(p);

        phone = new JTextField();
        phone.setBounds(300, 600, 250, 35);
        phone.setBackground(Color.WHITE);
        add(phone);

        // Submitte in Button
        up = new JButton("UPDATE");
        up.setBounds(1200, 700, 120, 30);
        up.setBackground(Color.cyan);
        up.addActionListener(this);
        add(up);

        // cancle in Button
        cancle = new JButton("CANCEL");
        cancle.setBounds(1350, 700, 120, 30);
        cancle.setBackground(Color.cyan);
        cancle.addActionListener(this);
        add(cancle);

        /// Table Layout size
        table = new JTable();
        table.setBounds(350, 240, 800, 30);
        table.setBackground(Color.LIGHT_GRAY);
        add(table);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String id = s.getText();
        String nam = s.getText();
        String gen = null;

        if (e.getSource() == se) {

            try {
                dbmsCon c = new dbmsCon();
                String q2 = "select* from addemployee where id='" + id + "'or Name='" + nam + "'";
                ResultSet rs = c.s.executeQuery(q2);

                table.setModel(DbUtils.resultSetToTableModel(rs));

                String q4 = "select* from addemployee where id = '" + id + "'";
                ResultSet res = c.s.executeQuery(q4);

                while (res.next()) {

                    name.setText(res.getString("Name"));
                    age.setText(res.getString("Age"));
                    salary.setText(res.getString("salary"));
                    nation.setText(res.getString("Nationality"));
                    nid.setText(res.getString("Nid"));
                    phone.setText(res.getString("Phone"));
                    email.setText(res.getString("Email"));
                    // bg.setSelectedItem(res.getString("Gender"));
                    post.setSelectedItem(res.getString("Post"));

                }

            } catch (Exception a) {
                a.printStackTrace();
            }

        }

        if (e.getSource() == up) {

            String Sname = name.getText();
            String Sage = age.getText();
            String Ssalary = salary.getText();
            String Snation = nation.getText();
            String Snid = nid.getText();
            String Sphone = phone.getText();
            String Semail = email.getText();

            String Spost = (String) post.getSelectedItem();

            if (male.isSelected()) {
                gen = "male";
            } else if (female.isSelected()) {
                gen = "female";
            }

            try {

                dbmsCon con = new dbmsCon();

                String query = "Update AddEmployee set name = '" + Sname + "',age = '" + Sage + "',salary='" + Ssalary + "',Nationality='" + Snation + "',Nid = '" + Snid + "',Phone = '" + Sphone + "',Email = '" + Semail + "',Gender ='" + gen + "',Post = '" + Spost + "' where id = '" + id + "'";

                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Update Successfully!!");
                setVisible(false);
                new viewEmployee();

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        }

        if (e.getSource() == cancle) {
            setVisible(false);
            new viewEmployee();

        }

    }

    public static void main(String[] args) {

        new updateEmployee();

    }

}
