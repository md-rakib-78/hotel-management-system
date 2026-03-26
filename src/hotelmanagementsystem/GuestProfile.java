package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;

public class GuestProfile extends JFrame implements ActionListener {
  
 JPasswordField pass = customerlogin.password;

 String p = pass.getText();
    
    
    JTable table2;
    JButton cp,ex;

    GuestProfile() {

 
       // Title admin manager
        JLabel lab0 = new JLabel(" MY PROFILE ");
        lab0.setFont(new Font("Tahoma", Font.BOLD, 50));
        lab0.setBounds(120, -50, 500, 200);
        lab0.setForeground(Color.CYAN);
        add(lab0);
        
               
   
        JLabel lab1 = new JLabel();
        lab1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lab1.setBounds(80, 120, 500, 100);
        lab1.setForeground(Color.DARK_GRAY);
        add(lab1);
        
        
        JLabel lab2 = new JLabel();
        lab2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lab2.setBounds(80, 165, 500, 100);
        lab2.setForeground(Color.BLACK);
        add(lab2);
        
        
        JLabel lab3 = new JLabel();
        lab3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lab3.setBounds(80, 200, 500, 100);
        lab3.setForeground(Color.BLACK);
        add(lab3);
        
        JLabel lab4 = new JLabel();
        lab4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lab4.setBounds(80, 235, 500, 100);
        lab4.setForeground(Color.BLACK);
        add(lab4);
        
        
        JLabel lab5 = new JLabel();
        lab5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lab5.setBounds(80, 270, 500, 100);
        lab5.setForeground(Color.BLACK);
        add(lab5);
        
        
       // Change pass Button
        cp = new JButton("CHANGE USERNAME OR PASSWORD");
        cp.setBounds(155, 370, 250, 30);
        cp.setBackground(Color.DARK_GRAY);
        cp.setForeground(Color.CYAN);
        cp.addActionListener(this);
        add(cp);

         
        // Exit Button
        ex = new JButton("EXIT");
        ex.setBounds(225, 410, 100, 30);
        ex.setBackground(Color.DARK_GRAY);
        ex.setForeground(Color.RED);
        ex.addActionListener(this);
        add(ex);
         
        
       
try {
    dbmsCon c = new dbmsCon();

    String q1 = "select* from customerinfo where password = '" +p+ "'";

    ResultSet e = c.s.executeQuery(q1);

 
    if (e.next()) {
        String fname = e.getString("Fname");
        lab1.setText(fname);
        
        String nid = e.getString("nid");
        lab2.setText("Nid    : "+nid);
        
        String email = e.getString("email");
        lab3.setText("Email  : "+email);
        
        String phone = e.getString("phone");
        lab4.setText("Phone  : "+phone);
        
        String nation = e.getString("Age");
        lab5.setText("Age    : "+nation);
        
    } 
} catch (SQLException ex) {
    ex.printStackTrace();
   
}



        //Uper layout
        table2 = new JTable();
        table2.setBounds(0, 0, 1600, 130);
        table2.setBackground(Color.DARK_GRAY);
        add(table2);
   
                
         // Pop up Layout
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500, 70, 600, 700);
        //setBackground(Color.WHITE);
        setVisible(true);
      
    }

    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==cp)
        {
            
            setVisible(false);
            new GuestPassChange();
            
            
        }
        
        
        if(e.getSource()==ex)
        {
            
            setVisible(false);
            new OnlineReception();
            
        }
    
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {

        new GuestProfile();

    }

}
