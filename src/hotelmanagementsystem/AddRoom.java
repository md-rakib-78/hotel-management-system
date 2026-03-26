
package hotelmanagementsystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class AddRoom extends JFrame implements ActionListener {
    
    JTextField rn,p;
    JComboBox av,cs,bt;
    JButton addRoom,c;
    
    
    AddRoom()
    {
        
      // Title add room
        JLabel lab1 = new JLabel("ADD ROOM ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lab1.setBounds(205, 0, 500, 100);
        lab1.setForeground(Color.DARK_GRAY);
        add(lab1); 
        
      
      // Room no
        JLabel roomNo = new JLabel("Room no.");
        roomNo.setBounds(80, 130, 100, 35);
        roomNo.setFont(new Font("tahoma",Font.BOLD,15));
        roomNo.setForeground(Color.DARK_GRAY);
        add(roomNo);

        rn = new JTextField();
        rn.setBounds(180, 130, 250, 30);
        add(rn);
        
        
        // Available room   
        JLabel ava = new JLabel("Available");
        ava.setBounds(80, 180, 100, 35);
        ava.setFont(new Font("tahoma",Font.BOLD,15));
        ava.setForeground(Color.DARK_GRAY);
        add(ava);
        
        
        String [] str = {"Available","Occupied"};
        av = new JComboBox(str);
        av.setBounds(180,180,250,30);
        av.setBackground(Color.WHITE);
        add(av);
        
        
         // Cleaning Status room   
        JLabel cl = new JLabel("Cleaning Status");
        cl.setBounds(80, 230, 100, 35);
        cl.setFont(new Font("tahoma",Font.BOLD,15));
        cl.setForeground(Color.DARK_GRAY);
        add(cl);
        
        
        String [] str1 = {"Cleaned","Dirty"};
        cs = new JComboBox(str1);
        cs.setBounds(180,230,250,30);
        cs.setBackground(Color.WHITE);
        add(cs);
        
        
        // price  
        JLabel pr = new JLabel("Price");
        pr.setBounds(80, 280, 100, 35);
        pr.setFont(new Font("tahoma",Font.BOLD,15));
        pr.setForeground(Color.DARK_GRAY);
        add(pr);
        
        p = new JTextField();
        p.setBounds(180, 280, 250, 30);
        add(p);
        
        
        // Bed type  
        JLabel b = new JLabel("Bed Type");
        b.setBounds(80, 330, 100, 35);
        b.setFont(new Font("tahoma",Font.BOLD,15));
        b.setForeground(Color.DARK_GRAY);
        add(b);
        
        
        String [] str2 = {"Single","Double"};
        bt = new JComboBox(str2);
        bt.setBounds(180,330,250,30);
        bt.setBackground(Color.WHITE);
        add(bt);
        
        
       // Add Room  Button
        addRoom = new JButton("ADD ROOM");
        addRoom.setBounds(280, 500, 120, 30);
        addRoom.setBackground(Color.DARK_GRAY);
        addRoom.setForeground(Color.CYAN);
        addRoom.addActionListener(this);
        add(addRoom); 
        
        
        
       // cancel  Button
        c = new JButton("CANCEL");
        c.setBounds(410, 500, 120, 30);
        c.setBackground(Color.DARK_GRAY);
        c.setForeground(Color.CYAN);
        c.addActionListener(this);
        add(c); 

        
       // Pop up Layout   
        setLayout(null);
        setBounds(500, 150, 600, 600);
        setVisible(true);
    }
    
    
    @Override
     public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==addRoom)
        {
            setVisible(false);
        
        String r = rn.getText();
       String al = (String)av.getSelectedItem();
       String cl = (String)cs.getSelectedItem();
       String pr = p.getText();
        String b = (String)bt.getSelectedItem();
        
        
         if(r.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Room number Should not be empty");
            return;
        }
         
         
     try{
            
            dbmsCon con = new dbmsCon();
            
             String q1 ="insert into addroom values('"+r+"','"+al+"','"+cl+"','"+pr+"','"+b+"')";
            
            con.s.executeUpdate(q1);
            
            JOptionPane.showMessageDialog(null, "Room Added Successfully!!");
            setVisible(false);
            new room();
            
            
        }catch(Exception ae)
        {
            ae.printStackTrace();
        }

        }
        
        
        if(e.getSource() == c)
        {
            setVisible(false);
            
            new room();
  
        }
  
    }
    
    
    
    public static void main(String[] args) {
        
        new AddRoom();
        
    }
    
}
