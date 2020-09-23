
package Control;

import java.sql.Connection;
import java.sql.Statement;


public class ControlVentanaCotizacion {
    public Connection conn;
    public Statement st;
    
    public ControlVentanaCotizacion(Connection c)
    {
        try
        {
            conn = c;
            if (conn != null) 
            {
                System.out.println("si jala");
                st = conn.createStatement();
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    } 
    
}
