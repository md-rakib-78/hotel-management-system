
package hotelmanagementsystem;
import java.sql.*;

public class dbmsCon {
    
    Connection c;
    Statement s;
    public dbmsCon()
    {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql:///HotelManagementSystem","root","223902078");
        s=c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
