
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import static java.awt.Image.SCALE_DEFAULT;
import javax.swing.*;
import java.awt.event.*;

public class room extends JFrame implements ActionListener{
 
    JButton addRoom,droom,cancle;
    
    room()
    {
       
        // Title admin manager
        JLabel lab1 = new JLabel("ROOM MANAGING ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lab1.setBounds(120, 0, 500, 100);
        lab1.setForeground(Color.DARK_GRAY);
        add(lab1);  
       
       
        // Add Room  Button
        addRoom = new JButton("ADD ROOM");
        addRoom.setBounds(220, 230, 150, 30);
        addRoom.setBackground(Color.DARK_GRAY);
        addRoom.setForeground(Color.WHITE);
        addRoom.addActionListener(this);
        add(addRoom); 
        
        // Add View  Button
        droom = new JButton("VIEW ROOM");
        droom.setBounds(220, 290, 150, 30);
        droom.setBackground(Color.DARK_GRAY);
        droom.setForeground(Color.WHITE);
        droom.addActionListener(this);
        add(droom); 
        
        // Cancle Button
        cancle = new JButton("CANCEL");
        cancle.setBounds(220, 350, 150, 30);
        cancle.setBackground(Color.cyan);
        cancle.addActionListener(this);
        add(cancle);
        
  
        
        // Backgraound image     
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("image/room.png"));
        Image in = im.getImage().getScaledInstance(600, 600, SCALE_DEFAULT);
        ImageIcon a = new ImageIcon(in);
        JLabel lab = new JLabel(a);
        lab.setBounds(-10, 0, 600, 600);
        add(lab);  
        
        
        // Pop up Layout   
        setLayout(null);
        setBounds(500, 150, 600, 600);
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)        
    {
        
        if(e.getSource() == addRoom)
        {
            setVisible(false);
            new AddRoom();
        }
        if(e.getSource()==droom)
        {
            setVisible(false);
            new ViewRoom();
        }
       if(e.getSource() == cancle)
        {
            setVisible(false);
            new admin();
        }
        
    }
    
          
    
    public static void main(String[] args) {
        
        new room();
        
    }
    
    
}
