
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import static java.awt.Image.SCALE_DEFAULT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class employee extends JFrame implements ActionListener {
    
    JButton addEmployee,view,logout;
    
    employee()
    {
        
         JLabel lab1 = new JLabel("Employee Managing ");
        lab1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lab1.setBounds(105, 0, 500, 100);
        lab1.setForeground(Color.DARK_GRAY);
        add(lab1); 
        
        
        // Add Employee  Button
        addEmployee = new JButton("ADD EMPLOYEE");
        addEmployee.setBounds(210, 180, 170, 35);
        addEmployee.setBackground(Color.DARK_GRAY);
        addEmployee.setForeground(Color.WHITE);
        addEmployee.addActionListener(this);
        add(addEmployee); 
        
       
        
        
         // View Employee  Button
        view = new JButton("VIEW EMPLOYEE");
        view.setBounds(210, 230, 170, 35);
        view.setBackground(Color.DARK_GRAY);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        add(view); 
        
        
        // EXIT  Button
        logout = new JButton("EXIT");
        logout.setBounds(210, 330, 170, 30);
        logout.setBackground(Color.cyan);
        logout.setForeground(Color.DARK_GRAY);
        logout.addActionListener(this);
        add(logout);
        
        
        
        // Backgraound image     
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("image/employee.jpg"));
        Image in = im.getImage().getScaledInstance(700, 600, SCALE_DEFAULT);
        ImageIcon a = new ImageIcon(in);
        JLabel lab = new JLabel(a);
        lab.setBounds(0, 0, 700, 600);
        add(lab);  
        
        
        
        
       // Pop up Layout   
        setLayout(null);
        setBounds(500, 150, 600, 600);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addEmployee)
        {
            setVisible(false);
            new AddEmployee();
        }
        
        if(e.getSource()==view)
        {
            setVisible(false);
            new viewEmployee();
        }
        if(e.getSource()==logout)
        {
            setVisible(false);
            new admin();
        }
        
        
    }
    
    
    
    public static void main(String[] args) {
        
        new employee();
    }
    
    
    
}
