
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
   
    public String server = "198.71.227.42";
    public String db ="DB_IndustrialBite";
    public String user = "DB_IB_Admin";
    public String pass="C19101293";
    
    public Connection conn;
    /*   private String url = "jdbc:mysql://localhost/alumno";
    private String usuario = "root";
    private String contrasena = "root";*/
        
       public Connection getConnection (){
        if (conn != null) {
            return conn;
        }
        try{
        Class.forName("com.mysql.jdbc.Driver");
        return conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+db, user, pass);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
