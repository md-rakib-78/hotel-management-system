package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField i,name, age, salary, nid, phone, email, nation,gender;
    JButton sub, cancle;
    JRadioButton male,female;
    JComboBox post;

    public AddEmployee() {
        // Section Name
        JLabel ad = new JLabel("ADD EMPLOYEE SECTION");
        ad.setFont(new Font("Tohoma", Font.BOLD, 50));
        ad.setBounds(425, -100, 800, 300);
        ad.setForeground(Color.DARK_GRAY);
        add(ad);

        // Name
        JLabel nam = new JLabel("NAME");
        nam.setFont(new Font("Tohoma", Font.BOLD, 20));
        nam.setBounds(100, 220, 200, 100);
        nam.setForeground(Color.black);
        add(nam);

        name = new JTextField();
        name.setBounds(300, 255, 250, 35);
        name.setBackground(Color.WHITE);
        add(name);
        
        // Name
        JLabel id = new JLabel("EMP ID");
        id.setFont(new Font("Tohoma", Font.BOLD, 20));
        id.setBounds(100, 140, 200, 100);
        id.setForeground(Color.black);
        add(id);

        i = new JTextField();
        i.setBounds(300, 175, 250, 35);
        i.setBackground(Color.WHITE);
        add(i);
        
        

        // Email
        JLabel e = new JLabel("EMAIL");
        e.setFont(new Font("Tohoma", Font.BOLD, 20));
        e.setBounds(800, 140, 200, 100);
        e.setForeground(Color.black);
        add(e);

        email = new JTextField();
        email.setBounds(950, 175, 250, 35);
        email.setBackground(Color.WHITE);
        add(email);

        // Age
        JLabel agee = new JLabel("AGE");
        agee.setFont(new Font("Tohoma", Font.BOLD, 20));
        agee.setBounds(100, 295, 200, 100);
        agee.setForeground(Color.black);
        add(agee);

        age = new JTextField();
        age.setBounds(300, 325, 250, 35);
        age.setBackground(Color.WHITE);
        add(age);
        
        
        //Gender
        JLabel gen = new JLabel("GENDER");
        gen.setFont(new Font("Tohoma",Font.BOLD,20));
        gen.setBounds(800, 215, 200, 100);
        gen.setForeground(Color.BLACK);
        add(gen);
        
        
        male = new JRadioButton("male");
        male.setBounds(950,250,100,30);
        male.setFont(new Font("Tohoma",Font.PLAIN,20));      
        add(male);
        
        
        female = new JRadioButton("female");
        female.setBounds(1080,250,100,30);
        female.setFont(new Font("Tohoma",Font.PLAIN,20));
        add(female);
        

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        

        // Salary
        JLabel sal = new JLabel("SALARY");
        sal.setFont(new Font("Tohoma", Font.BOLD, 20));
        sal.setBounds(100, 370, 200, 100);
        sal.setForeground(Color.black);
        add(sal);

        salary = new JTextField();
        salary.setBounds(300, 405, 250, 35);
        salary.setBackground(Color.WHITE);
        add(salary);
        
        
        //Job Post
        
        JLabel job = new JLabel("JOB POST");
        job.setFont(new Font("Tohoma", Font.BOLD, 20));
        job.setBounds(800, 295, 200, 100);
        job.setForeground(Color.black);
        add(job);
        
        
        String [] str = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter","Manager","Accountant"};
        post = new JComboBox(str);
        post.setBounds(950,325,200,30);
        post.setBackground(Color.WHITE);
        add(post);
        
        

        // nationality
        JLabel nal = new JLabel("NATIONALITY");
        nal.setFont(new Font("Tohoma", Font.BOLD, 20));
        nal.setBounds(100, 450, 200, 100);
        nal.setForeground(Color.black);
        add(nal);

        nation = new JTextField();
        nation.setBounds(300, 480, 250, 35);
        nation.setBackground(Color.WHITE);
        add(nation);

        // Nid
        JLabel ni = new JLabel("NID");
        ni.setFont(new Font("Tohoma", Font.BOLD, 20));
        ni.setBounds(100, 530, 200, 100);
        ni.setForeground(Color.black);
        add(ni);

        nid = new JTextField();
        nid.setBounds(300, 560, 250, 35);
        nid.setBackground(Color.WHITE);
        add(nid);

        // Phone
        JLabel p = new JLabel("PHONE NO.");
        p.setFont(new Font("Tohoma", Font.BOLD, 20));
        p.setBounds(100, 610, 200, 100);
        p.setForeground(Color.black);
        add(p);

        phone = new JTextField();
        phone.setBounds(300, 640, 250, 35);
        phone.setBackground(Color.WHITE);
        add(phone);

        // Submitte in Button
        sub = new JButton("SUBMIT");
        sub.setBounds(1200, 700, 120, 30);
        sub.setBackground(Color.cyan);
        sub.addActionListener(this);
        add(sub);

        // cancle in Button
        cancle = new JButton("CANCEL");
        cancle.setBounds(1350, 700, 120, 30);
        cancle.setBackground(Color.cyan);
        cancle.addActionListener(this);
        add(cancle);
        
        
        ImageIcon ima = new ImageIcon(ClassLoader.getSystemResource("image/addemployee.png"));
        Image ina = ima.getImage().getScaledInstance(1550, 880, SCALE_DEFAULT);
        ImageIcon aa = new ImageIcon(ina);
        JLabel laba = new JLabel(aa);
        laba.setBounds(0, -50, 1550, 980);
        add(laba);  
        
        
        

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

     
        if(e.getSource()==sub)
        {
        String id = i.getText();
        String Sname = name.getText();
        String Sage = age.getText();
        String Ssalary = salary.getText();
        String Snation= nation.getText();
        String Snid = nid.getText();
        String Sphone = phone.getText();
        String Semail = email.getText();
        
        String Spost = (String)post.getSelectedItem();
        
        String gen = null;
        
        if(male.isSelected())
        {
            gen="male";
        }
        else if(female.isSelected())
        {
            gen="female";
        }
        
        if(id.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Employee id Should not be empty");
            return;
        }
        
        if(Sname.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Name Should not be empty");
            return;
        }
        else if(Snid.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Nid Should not be empty!");
            return;
        }
        else if(Spost.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Job post Should not be empty!");
            return;
        }
         else if(Sage.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Age Should not be empty!");
            return;
        }
        else if(Semail.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Email Should not be empty!");
            return;
        }
         else if(Sphone.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Phone number Should not be empty!");
            return;
        }
        
        try{
            
            dbmsCon con = new dbmsCon();
            
            String query = "insert into AddEmployee values('"+Sname+"','"+Sage+"','"+Ssalary+"','"+Snation+"','"+Snid+"','"+Sphone+"','"+Semail+"','"+gen+"','"+Spost+"','"+id+"')";
            
            con.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee Added Successfully!!");
            setVisible(false);
            new employee();
            
            
        }catch(Exception ae)
        {
            ae.printStackTrace();
        }
        
        
        }
        else if(e.getSource()==cancle)
        {
            setVisible(false);
            new employee();
        } 
    }
    
    
    public static void main(String[] args) {
        
        
        new employee();
        
    }


}
