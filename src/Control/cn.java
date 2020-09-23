
package Control;

import java.sql.Connection;
import java.sql.DriverManager;


public class cn {
   public String server;
    public String db;
    public String user;
    public String pass;
    
    public Connection conn;
    
    public cn(String s, String d, String u, String p)
    {
        server = s;
        db = d;
        user = u;
        pass = p;
    }
    
    public Connection getConnection ()
    {
        if (conn != null) {
            return conn;
        }
        try{
        Class.forName("com.mysql.jdbc.Driver");
        return conn = DriverManager.getConnection("jdbc:mysql://localhost/Banquetes", user, pass);
        
        }
        catch(Exception e)
        {
            System.out.println("no jala");
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}

