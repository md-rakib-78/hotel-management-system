
package hotelmanagementsystem;

import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class adminChangePass extends JFrame implements ActionListener {
    
    JTextField password, userName,op;
    JButton login, cancle;
    
    adminChangePass()
    {
        
        
        JLabel lab1 = new JLabel("ADMIN PASSWORD CHANGE ");
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
        
        
        
         // Log in Button
        login = new JButton("UPDATE");
        login.setBounds(150, 380, 120, 30);
        login.setBackground(Color.cyan);
        login.addActionListener(this);
        add(login);

        //// Cancle Button
        cancle = new JButton("CANCLE");
        cancle.setBounds(300, 380, 120, 30);
        cancle.setBackground(Color.cyan);
        cancle.addActionListener(this);
        add(cancle);


        
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
    public void actionPerformed(ActionEvent e){
        
        String u = userName.getText();
        String p = password.getText();
        String o = op.getText();
        
        
        if(e.getSource()==login)
        {
            
                    try{
            
            dbmsCon con = new dbmsCon();
            
            String query = "Update adminlogin set username = '"+u+"',password = '"+p+"' where password = '"+o+"'";
            
            con.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Update Successfully!!");
            setVisible(false);
            new AdminProfile();
            
            
        }catch(Exception ae)
        {
            ae.printStackTrace();
        }
            
            
        }
        
        
        if(e.getSource()==cancle)
        {
            setVisible(false);
            new AdminProfile();
            
            
            
        }
        
        
        
    }
    
    
    
    public static void main(String[] args) {
        
        
        new adminChangePass();
        
    }
}
