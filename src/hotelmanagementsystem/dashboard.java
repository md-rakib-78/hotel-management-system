package hotelmanagementsystem;

import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.*;
import javax.swing.*;


public class dashboard extends JFrame implements ActionListener{

    JButton admin, reception;
  
    
    dashboard() {
        super("Rakib Hotel management System");

       
        // Title admin manager
        JLabel lab1 = new JLabel("WELCOME TO OUR HOTEL ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 60));
        lab1.setBounds(360, -100, 800, 500);
        lab1.setForeground(Color.LIGHT_GRAY);
        add(lab1);
        

/// Reception Button
        reception = new JButton("RECEPTION");
        reception.setBounds(640, 350, 240, 50);
        reception.setFont(new Font("Tahoma", Font.BOLD, 25));
        reception.setBackground(Color.DARK_GRAY);
        reception.setForeground(Color.LIGHT_GRAY);
        reception.addActionListener(this);
        add(reception);

        /// Admin Button
        admin = new JButton("ADMIN");
        admin.setBounds(640, 460, 240, 50);
        admin.setFont(new Font("Tahoma", Font.BOLD, 25));
        admin.setBackground(Color.DARK_GRAY);
        admin.setForeground(Color.LIGHT_GRAY);
        admin.addActionListener(this);
        add(admin);

        
        // Hotel Image
        
        ImageIcon ima = new ImageIcon(ClassLoader.getSystemResource("image/hotell.png"));
        Image ina = ima.getImage().getScaledInstance(1920, 1080, SCALE_DEFAULT);
        ImageIcon aa = new ImageIcon(ina);
        JLabel laba = new JLabel(aa);
        laba.setBounds(0, 0, 1920, 1080);
        add(laba);  
        
        

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1950, 1090);
        setVisible(true);
    }

    //Button Action 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reception) {
            
            setVisible(false);
            new customerlogin();
            //

        } else {

            setVisible(false);
            new adminLogIn();
        }

    }
}
