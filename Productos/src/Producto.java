public class Producto {
    private int codProducto;
    private String nombre;
    private double precio;
    private int unidadesDisponibles;
    private String categoria;

    public Producto(int codProducto, String nombre, double precio, int unidadesDisponibles, String categoria){
        this.codProducto= codProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.unidadesDisponibles = unidadesDisponibles;
        this.categoria = categoria;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //métedo
    public String mostrarInfoProducto(){
       return "Código: " + codProducto + " - Nombre: " + nombre + " - Precio: " + precio
        + " - Unidades disponibles: " + unidadesDisponibles + " - Categoría: " + categoria;
    }
}
