
package hotelmanagementsystem;

import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AdminProfile extends JFrame implements ActionListener{
    
    JButton cancle,pass;
    
    AdminProfile()
    {
        
        JLabel lab1 = new JLabel("ADMIN PROFILE ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lab1.setBounds(160, 0, 500, 100);
        lab1.setForeground(Color.white);
        add(lab1);
        
        
        JLabel lab2 = new JLabel("Md. Rakibul Islam ");
        lab2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lab2.setBounds(190, 200, 500, 100);
        lab2.setForeground(Color.lightGray);
        add(lab2);
        
         JLabel lab3 = new JLabel("ID: 223902078");
        lab3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lab3.setBounds(215, 230, 500, 100);
        lab3.setForeground(Color.lightGray);
        add(lab3);
        
        
         // Cancle Button
        pass = new JButton("CHANGE USERNAME OR PASSWORD");
        pass.setBounds(155, 300, 250, 30);
        pass.setBackground(Color.DARK_GRAY);
        pass.setForeground(Color.CYAN);
        pass.addActionListener(this);
         add(pass);
       
         
        // change password Button
        cancle = new JButton("EXIT");
        cancle.setBounds(430, 410, 120, 30);
        cancle.setBackground(Color.CYAN);
        cancle.setForeground(Color.DARK_GRAY);
        cancle.addActionListener(this);
         add(cancle);
    
        
        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("image/myphoto.jpg"));
        Image ie = ii.getImage().getScaledInstance(280, 160, SCALE_DEFAULT);
        ImageIcon b = new ImageIcon(ie);
        JLabel labb = new JLabel(b);
        labb.setBounds(205, 110, 150, 120);
        add(labb);
        

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
    
    
    
     public void actionPerformed(ActionEvent e)
     {
         
         if(e.getSource()==pass)           
         {
             setVisible(false);
             new adminChangePass();
                 
         }
         
         
        if(e.getSource()==cancle)            
         {
             setVisible(false);
             
             new admin();    
         }
         
         
         
         
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        new AdminProfile();
        
    }
    
}
