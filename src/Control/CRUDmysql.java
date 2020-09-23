package Control;

import Entorno.avisoCantidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDmysql {

   
    

    public Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    
    private Connection con;
    
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    ArrayList<PlatillosCotizacion> listaCoti = new ArrayList<PlatillosCotizacion>();
    
    
    
    private  int cantidad;
    
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CRUDmysql() {
        cn conexion = new cn("localhost", "Banquetes", "root", "root");
        con = conexion.getConnection();
        if (con != null) {
            try {
                st = con.createStatement();
            } catch (Exception e) {
                System.out.println("Error 1: " + e.getMessage());
            }
        }
    }
    
    

    public void llenarTablaPlatillos(JTable tabla) throws Exception {
        try {      
            tabla.setModel(modelo);

            ResultSet rs = st.executeQuery("SELECT * FROM platillo");
            if (rs != null) {
                modelo.addColumn("id platillo");
                modelo.addColumn("Platillo fuerte");
                modelo.addColumn("Botanas");
                modelo.addColumn("Postres");

                while (rs.next()) {
                    Object Nuevo[] = {
                        rs.getInt("id_platillo"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("precio")
                    };
                    modelo.addRow(Nuevo);
                }
            }

        } catch (Exception ex) {
            System.out.println("Error 2: " + ex.getMessage());
        }
    }

    public void llenarCotizacion(JTable tabla2) {  
            tabla2.setModel(modelo2);
             modelo2.addColumn("nombre");
             modelo2.addColumn("precio");       
             modelo2.addColumn("Cantidad de P.");
    }
    
    
    
    public void agregarPlatilloCotizacion(JTable tabla){
        
        String dato;
     dato=String.valueOf(modelo.getValueAt(tabla.getSelectedRow(),0));
     
      try {      
            tabla.setModel(modelo);

            ResultSet rs = st.executeQuery("SELECT nombre,precio FROM platillo WHERE id_platillo="+dato);
            if (rs != null) {   
                while (rs.next()) {
                    Object Nuevo[] = {
                    
                        rs.getString("nombre"),
                        rs.getString("precio")
                            
                    };
                    modelo2.addRow(Nuevo);
                }
            }

        } catch (Exception ex) {
            System.out.println("Error 2: " + ex.getMessage());
        }     
    }
    
    public void quitar(JTable tabla){
     String dato;
     dato=String.valueOf(modelo2.getValueAt(tabla.getSelectedRow(),0));
     System.out.println(dato);
   
        for (int i = 0; i <= modelo2.getRowCount(); i++) {
              if(modelo2.getValueAt(0,0).equals(dato)){
                    modelo2.removeRow(i);
                    break;
               }
        }
    }
}
