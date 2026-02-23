import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface InterfazProductos {
    public ArrayList<Producto> mostrarProductosPorPatron(String patron);

    public double valorMedioPorCategoria(String categoria);

    public ArrayList<Producto> productosDeCategoria(String categoria);

    public void escribirArchivoProductosCategoria(String categoria);

    public void mostrarProductosPorCategoria();
}