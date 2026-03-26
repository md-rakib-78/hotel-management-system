package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import java.sql.*;

public class adminLogIn extends JFrame implements ActionListener {

    JTextField  userName;
    JButton login, cancle;
    JPasswordField password;

    public adminLogIn() {
        
         JLabel lab1 = new JLabel("ADMIN LOG IN ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lab1.setBounds(80, 0, 500, 100);
        lab1.setForeground(Color.white);
        add(lab1);
        
        
        
        // User name 
        JLabel user = new JLabel("USERNAME");
        user.setBounds(90, 150, 100, 30);
        user.setForeground(Color.lightGray);
        add(user);

        userName = new JTextField();
        userName.setBounds(90, 180, 220, 30);
        add(userName);

        // Password
        JLabel pass = new JLabel("PASSWORD");
        pass.setBounds(90, 220, 100, 30);
        pass.setForeground(Color.lightGray);
        add(pass);

        password = new JPasswordField();
        password.setBounds(90, 250, 220, 30);
        add(password);
       

        // Log in Button
        login = new JButton("LOGIN");
        login.setBounds(90, 350, 100, 30);
        login.setBackground(Color.cyan);
        login.setForeground(Color.DARK_GRAY);
        login.addActionListener(this);
        add(login);

        // Cancle Button
        cancle = new JButton("CANCLE");
        cancle.setBounds(210, 350, 100, 30);
        cancle.setBackground(Color.cyan);
        cancle.setForeground(Color.DARK_GRAY);
        cancle.addActionListener(this);
        add(cancle);

        
        // Admin Image 
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("image/hotel1.png"));
        Image in = im.getImage().getScaledInstance(400, 600, SCALE_DEFAULT);
        ImageIcon a = new ImageIcon(in);
        JLabel lab = new JLabel(a);
        lab.setBounds(0, 0, 400, 600);
        add(lab);

        // popup layout
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(550,130,400, 600);
        setVisible(true);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String user = userName.getText();
            String pass = password.getText();

            try {
                dbmsCon c = new dbmsCon();

                String query = "select* from adminLogin where username = '" + user + "' and password ='" + pass + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);

                    new admin();
                }              
                else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password !!!");
                    setVisible(false);
                    new adminLogIn();
                }

            } catch (Exception a) {
                a.printStackTrace();
            }

        }
        

        
        else if (e.getSource() == cancle)
        {
              setVisible(false);
              new dashboard();
              
        }
    }
    
    
    public static void main(String[] args) {
        
        new adminLogIn();
    }
    

}
