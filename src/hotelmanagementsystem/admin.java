
package hotelmanagementsystem;

import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import javax.swing.*;


public class admin extends JFrame implements ActionListener{
    
    JButton addEmployee,viewemployee,addRoom,logout,profile,vg;
    
    
         public admin()
         {
             
        // Title admin manager
        JLabel lab1 = new JLabel("ADMIN MANAGER ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lab1.setBounds(120, 0, 500, 100);
        lab1.setForeground(Color.lightGray);
        add(lab1);  
             
             
        // Admin Profile  Button
        profile = new JButton("ADMIN PROFILE");
        profile.setBounds(210, 180, 150, 30);
        profile.setBackground(Color.DARK_GRAY);
        profile.setForeground(Color.WHITE);
        profile.addActionListener(this);
        add(profile);      
        
        
             
        // Add Employee  Button
        addEmployee = new JButton("EMPLOYEE");
        addEmployee.setBounds(210, 230, 150, 30);
        addEmployee.setBackground(Color.DARK_GRAY);
        addEmployee.setForeground(Color.WHITE);
        addEmployee.addActionListener(this);
        add(addEmployee);   
        
        
        
        // Room  Button
        addRoom = new JButton("ROOM");
        addRoom.setBounds(210, 280, 150, 30);
        addRoom.setBackground(Color.DARK_GRAY);
        addRoom.setForeground(Color.WHITE);
        addRoom.addActionListener(this);
        add(addRoom); 
        
        
        // View Guest  Button
        vg = new JButton("VIEW GUEST");
        vg.setBounds(210, 330, 150, 30);
        vg.setBackground(Color.DARK_GRAY);
        vg.setForeground(Color.WHITE);
        vg.addActionListener(this);
        add(vg); 
        
        
        
        // Log out  Button
        logout = new JButton("LOGOUT");
        logout.setBounds(210, 380, 150, 30);
        logout.setBackground(Color.cyan);
        logout.setForeground(Color.DARK_GRAY);
        logout.addActionListener(this);
        add(logout); 
        
        
             
             
        
        // Backgraound image     
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("image/hotel1.png"));
        Image in = im.getImage().getScaledInstance(600, 600, SCALE_DEFAULT);
        ImageIcon a = new ImageIcon(in);
        JLabel lab = new JLabel(a);
        lab.setBounds(0, 0, 600, 600);
        add(lab);  
            
             
             
        // Pop up Layout   
        setLayout(null);
        setBounds(500, 150, 600, 600);
        setVisible(true);
         }
         
         
         public void actionPerformed(ActionEvent e)
         {
             
             if(e.getSource()==profile)
             {
                 setVisible(false);
                 new AdminProfile();
             }
             
             if(e.getSource()== addEmployee)
             {
                 setVisible(false);
                 new employee();
             }
      
             if(e.getSource()== addRoom)
             {
                 setVisible(false);
                 new room();
             }
             
             
             if(e.getSource()==vg)
             {
                 setVisible(false);
                 new viewGuest();
                 
             }
             
             
             
            if(e.getSource()==logout)
             {
                 setVisible(false);
                 new adminLogIn();
             }         
         }
         
         
   
         
         public static void main(String[] args) {
        
             new admin();
             
    }
    
    
}
