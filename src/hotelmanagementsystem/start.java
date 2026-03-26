
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import static java.awt.Image.SCALE_DEFAULT;


public class start extends JFrame {
    
    
    start()
    {
        JLabel f1 = new JLabel("Loading...");
        f1.setFont(new Font("Tahoma",Font.BOLD,30));
        f1.setBounds(260,-50,500,500);
        f1.setBackground(Color.red);
        f1.setForeground(Color.gray);
        add(f1);
        
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Loading/Blocks.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(100, 100, SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(283, 210, 100, 100);
        add(label);
                   
         
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450, 200, 700, 500);
        setVisible(true);
    
   
        try{
            
        Thread.sleep(1000);
        setVisible(false);
        new dashboard();
      
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        
    }
    

    
    public static void main(String[] args) {
        
        new start();

    }
  
}
