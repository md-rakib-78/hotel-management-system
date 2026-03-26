package hotelmanagementsystem;

import hotelmanagementsystem.dbmsCon;
import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

import javax.swing.JTextField;
//import net.proteanit.sql.DbUtils;

public class SignUp extends JFrame implements ActionListener {

    JTextField Fname, Lname,age,nid,phon, email, password, userName;
    JButton confirm, cancle;

    public SignUp() {


        // Title admin manager
        JLabel lab1 = new JLabel("USER INFORMATION FORM ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lab1.setBounds(90, 0, 500, 100);
        lab1.setForeground(Color.white);
        add(lab1);

        // First name 
        JLabel fname = new JLabel("FIRST NAME");
        fname.setBounds(30, 130, 100, 30);
        fname.setForeground(Color.white);
        add(fname);

        Fname = new JTextField();
        Fname.setBounds(130, 130, 150, 30);
        add(Fname);
        
        
         // Age
        JLabel agee = new JLabel("AGE");
        agee.setBounds(310, 130, 100, 30);
        agee.setForeground(Color.white);
        add(agee);

        age = new JTextField();
        age.setBounds(390, 130, 150, 30);
        add(age);
        
        

        // Last name
        JLabel lname = new JLabel("LAST NAME");
        lname.setBounds(30, 180, 100, 30);
        lname.setForeground(Color.white);
        add(lname);

        Lname = new JTextField();
        Lname.setBounds(130, 180, 150, 30);
        add(Lname);
        
        
       // Nid
        JLabel nidi = new JLabel("NID");
        nidi.setBounds(310, 180, 100, 30);
        nidi.setForeground(Color.white);
        add(nidi);

        nid = new JTextField();
        nid.setBounds(390, 180, 150, 30);
        add(nid);
        

        // Email
        JLabel Email = new JLabel("EMAIL");
        Email.setBounds(30, 230, 100, 30);
        Email.setForeground(Color.white);
        add(Email);

        email = new JTextField();
        email.setBounds(130, 230, 150, 30);
        add(email);
        
        
        // Phone no
        JLabel phone = new JLabel("PHONE NO.");
        phone.setBounds(310, 230, 100, 30);
        phone.setForeground(Color.white);
        add(phone);

        phon = new JTextField();
        phon.setBounds(390, 230, 150, 30);
        add(phon);
        
        
          
        

        // User name 
        JLabel user = new JLabel("USERNAME");
        user.setBounds(30, 280, 100, 30);
        user.setForeground(Color.white);
        add(user);

        userName = new JTextField();
        userName.setBounds(130, 280, 150, 30);
        add(userName);

        // Password
        JLabel pass = new JLabel("PASSWORD");
        pass.setBounds(30, 330, 100, 30);
        pass.setForeground(Color.white);
        add(pass);

        password = new JTextField();
        password.setBounds(130, 330, 150, 30);
        add(password);

        // confirm in Button
        confirm = new JButton("CONFIRM");
        confirm.setBounds(40, 410, 120, 30);
        confirm.setBackground(Color.DARK_GRAY);
        confirm.setForeground(Color.CYAN);
        confirm.addActionListener(this);
        add(confirm);

        // Cancle Button
        cancle = new JButton("CANCLE");
        cancle.setBounds(430, 410, 120, 30);
        cancle.setBackground(Color.DARK_GRAY);
        cancle.setForeground(Color.CYAN);
        cancle.addActionListener(this);
         add(cancle);
         
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("image/hotel1.png"));
        Image in = im.getImage().getScaledInstance(600, 500, SCALE_DEFAULT);
        ImageIcon a = new ImageIcon(in);
        JLabel lab = new JLabel(a);
        lab.setBounds(0, 0, 600, 500);
        add(lab);

        // Pop up Layout
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        setBounds(500, 200, 600, 500);
        setVisible(true);

    }
    
    
    
    

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == confirm) {
            
            String fn = Fname.getText();
            String ln = Lname.getText();
            String ag = age.getText();
            String ph = phon.getText();
            String ni = nid.getText();
            String em = email.getText();
            String u =userName.getText();
            String p = password.getText();
            

            
            
            if(fn.equals(""))
            {
                JOptionPane.showMessageDialog(null, "First name should not empty!");
                return;
            }
            
            if(em.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Email Address should not empty!");
                return;
            }
            
            if(u.equals(""))
            {
                JOptionPane.showMessageDialog(null, "User name should not empty!");
                return;
            }
            if(p.equals(""))
            {
                JOptionPane.showMessageDialog(null, "First name should not empty!");
                return;
            }
            
            int agnum = Integer.parseInt(ag);
            
             if(18<=agnum)
            {
            } else {
                 JOptionPane.showMessageDialog(null, "You should must be 18 years old!");
                 return;
            }
            
            
            try
            {
                dbmsCon conne = new dbmsCon();
                
                String q1 ="insert into customerinfo values('"+fn+"','"+ln+"','"+ag+"','"+ni+"','"+ph+"','"+em+"','"+p+"','"+u+"')";
                String q2 ="insert into customerlogin values('"+u+"','"+p+"')";
                
                conne.s.executeUpdate(q1);
                conne.s.executeUpdate(q2);
                
                JOptionPane.showMessageDialog(null, "Account succesfully create! ");
                
                setVisible(false);
                new customerlogin();
            }
            catch(Exception x)
            {
                x.printStackTrace();
            }
    
            
        } else if (e.getSource() == cancle) {
            setVisible(false);
            new customerlogin();

        }

    }
    
    
    public static void main(String[] args) {
        
        new SignUp();
        
    }

}
