
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.*;
import java.awt.event.*;

public class GuestPassChange extends JFrame implements ActionListener {
    
   JTextField userName,op,password;
   JButton change,can; 
    GuestPassChange()
    {
        
        
        
        JLabel lab1 = new JLabel("GUEST PASSWORD CHANGE ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lab1.setBounds(110, 0, 500, 100);
        lab1.setForeground(Color.WHITE);
        add(lab1);
        
        
        // User name 
        JLabel user = new JLabel("NEW USERNAME");
        user.setBounds(150, 145, 100, 30);
        user.setForeground(Color.lightGray);
        add(user);

        userName = new JTextField();
        userName.setBounds(150, 180, 270, 30);
        add(userName);

        // Password
        JLabel pass = new JLabel("OLD PASSWORD");
        pass.setBounds(150, 220, 100, 30);
        pass.setForeground(Color.lightGray);
        add(pass);

        op = new JTextField();
        op.setBounds(150, 250, 270, 30);
        add(op);
        
        
        // Password
        JLabel passs = new JLabel("NEW PASSWORD");
        passs.setBounds(150, 295, 100, 30);
        passs.setForeground(Color.lightGray);
        add(passs);

        password = new JTextField();
        password.setBounds(150, 320, 270, 30);
        add(password);
        
        
        
         // Change Button
        change = new JButton("CHANGE");
        change.setBounds(150, 380, 120, 30);
        change.setBackground(Color.cyan);
        change.addActionListener(this);
        add(change);

        //// Cancle Button
        can = new JButton("CANCLE");
        can.setBounds(300, 380, 120, 30);
        can.setBackground(Color.cyan);
        can.addActionListener(this);
        add(can);

        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("image/hotel1.png"));
        Image in = im.getImage().getScaledInstance(600, 500, SCALE_DEFAULT);
        ImageIcon a = new ImageIcon(in);
        JLabel lab = new JLabel(a);
        lab.setBounds(0, 0, 600, 500);
        add(lab);
        
        
        
        // Pop up Layout
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        setBounds(500, 200, 600, 500);
        setVisible(true);
        
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String u = userName.getText();
        String p = password.getText();
        String o = op.getText();
        
        
        
        if(e.getSource()==change)
        {
            
                    try{
            
            dbmsCon con = new dbmsCon();
            
            String query = "Update customerinfo set username = '"+u+"',password = '"+p+"' where password = '"+o+"'";
            String query2 = "Update customerlogin set username = '"+u+"',password = '"+p+"' where password = '"+o+"'";
            
            con.s.executeUpdate(query);
            con.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null, "Update Successfully!!");
            setVisible(false);
            new customerlogin();
            
            
        }catch(Exception ae)
        {
            ae.printStackTrace();
        }
            
            
        }
        
        
        if(e.getSource()==can)
        {
            setVisible(false);
            new GuestProfile();
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    public static void main(String[] args) {
        
        
        new GuestPassChange();
        
        
    }
    
    
    
}
