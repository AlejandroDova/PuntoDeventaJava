package Control;

public class PlatillosCotizacion {

    private int id_platillo;
    private String nombre;
    private String tipo;
    private int precio;

    public PlatillosCotizacion(int id_platillo, String nombre, String tipo, int precio) {
        this.id_platillo = new Integer(id_platillo);
        this.nombre = new String(nombre);
        this.tipo = new String(tipo);
        this.precio = new Integer(precio);
    }

    /**
     * @return the id_platillo
     */
    public int getId_platillo() {
        return id_platillo;
    }

    /**
     * @param id_platillo the id_platillo to set
     */
    public void setId_platillo(int id_platillo) {
        this.id_platillo = id_platillo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
