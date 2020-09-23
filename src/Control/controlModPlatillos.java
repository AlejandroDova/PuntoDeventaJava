
package Control;

import Entorno.ModPlatillos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class controlModPlatillos {
    
    public Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;

    private Connection con;
    
    DefaultTableModel tabla1 = new DefaultTableModel();
    DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    ArrayList<String> nombreArreglo = new ArrayList();
    ArrayList<Integer> idArreglo = new ArrayList();
    
    public controlModPlatillos() {
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
    
    
    public void llenar_combo(JComboBox cb) {
        try {          
            rs = st.executeQuery("SELECT id,tipo FROM banquetes.tipoplatillo");
            modeloCombo.addElement("tipo de comida");
            cb.setModel(modeloCombo);
            
             while (rs.next()) {
                   nombreArreglo.add(rs.getString("tipo"));
                    idArreglo.add(rs.getInt("id"));
                modeloCombo.addElement(rs.getObject("tipo"));
                cb.setModel(modeloCombo);
            }   
             
            
           
        }
         catch (Exception e) {
                System.out.println("Error 5: " + e.getMessage());
            }
    }
    
    public void hacerTabla(JTable tabla){
          try {      
            tabla.setModel(tabla1);

            ResultSet rs = st.executeQuery("SELECT * FROM platillo");
            if (rs != null) {
                tabla1.addColumn("id platillo");
                tabla1.addColumn("Platillo fuerte");
                tabla1.addColumn("Botanas");
                tabla1.addColumn("Postres");
                 

                while (rs.next()) {
                    Object Nuevo[] = {
                        rs.getInt("id_platillo"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("precio")
                    };
                    tabla1.addRow(Nuevo);
                }
            }

        } catch (Exception ex) {
            System.out.println("Error 2: " + ex.getMessage());
        }
     
    }
    
    
    
    
    
       public void actualizarTabla(JTable tabla) {
        tabla1.removeTableModelListener(tabla);

        DefaultTableModel tabla1 = new DefaultTableModel();
        int x = 1;
        try {

            ResultSet rs = st.executeQuery("SELECT * FROM platillo");
            if (rs != null) {
                while (rs.next()) {

                    if (rs.getInt("id_platillo") != x) {
                        System.out.println(rs.getInt("id_platillo"));
                        System.out.println(x);

                        st.executeUpdate("UPDATE `banquetes`.`platillo` SET `id_platillo`='" + x + "' WHERE `id_platillo`='" + rs.getInt("id_platillo") + "'");
                    }

                    x++;
                }
            }

        } catch (Exception ex) {
            System.out.println("Error 6: " + ex.getMessage());
            actualizarTabla(tabla);
        }
        try {
            tabla.setModel(tabla1);

            ResultSet rs = st.executeQuery("SELECT * FROM platillo");
            if (rs != null) {
                tabla1.addColumn("id platillo");
                tabla1.addColumn("Platillo fuerte");
                tabla1.addColumn("Botanas");
                tabla1.addColumn("Postres");
                while (rs.next()) {
                    Object Nuevo[] = {
                        rs.getInt("id_platillo"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("precio")
                    };
                    tabla1.addRow(Nuevo);
                }
            }

        } catch (Exception ex) {
            System.out.println("Error 2: " + ex.getMessage());
        }
    }

       
       
       
       
       
       
    public void Agregar(JTable tabla,String nom,String tipo,String precio){
        int Numtipo = 0;
        if(tipo != null){
            for (int i = 0; i < nombreArreglo.size(); i++) {
                if(nombreArreglo.get(i).equals(tipo)){
                    Numtipo = idArreglo.get(i);
                    break;
                }
            }
        }
        try {
            st.executeUpdate(" INSERT INTO `banquetes`.`platillo` (`id_platillo`, `nombre`, `tipo`, `precio`) VALUES ( '0', '"+nom+"', '"+Numtipo+"', '"+precio+"')" );      
        } catch (Exception ex) {
            System.out.println("Error 3: " + ex.getMessage());
        }
        
          actualizarTabla(tabla);
         
    }
    
    public void Eliminar(JTable tabla) {
        String dato;
        dato = String.valueOf(tabla1.getValueAt(tabla.getSelectedRow(), 0));
        try {
            st.executeUpdate("DELETE FROM platillo WHERE id_platillo =" + dato);
        } catch (Exception ex) {
            System.out.println("Error 3: " + ex.getMessage());
        }
        actualizarTabla(tabla);

    }

    public void Editar(JTable tabla,String nom,String tipo,String precio) {
        String dato;
        dato = String.valueOf(tabla1.getValueAt(tabla.getSelectedRow(), 0));
         int Numtipo = 0;
        if(tipo != null){
            for (int i = 0; i < nombreArreglo.size(); i++) {
                if(nombreArreglo.get(i).equals(tipo)){
                    Numtipo = idArreglo.get(i);
                    break;
                }
            }
        }
        
        try {
            st.executeUpdate("UPDATE `banquetes`.`platillo` SET `nombre`='"+nom+"', `tipo`='"+Numtipo+"', `precio`='"+precio+"' WHERE `id_platillo`='"+dato+"';");
        } catch (Exception ex) {
            System.out.println("Error 3: " + ex.getMessage());
        }
        actualizarTabla(tabla);

    }
    
    public void cambiarVentana(){
    ModPlatillos v1 = new ModPlatillos();
    v1.dispose();
    }
}
