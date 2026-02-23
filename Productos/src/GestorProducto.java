import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Programa principal
public class GestorProducto implements InterfazProductos{
    //HashMap
    HashMap<String, List<Producto>> mapaProductos;
    public GestorProducto(){
        mapaProductos = new HashMap<>();
    }
    public void setMapaProductos(HashMap<String, List<Producto>> mapaProductos){
        this.mapaProductos = mapaProductos;
    }
    //Método que devuelva una array con las categorías
    public ArrayList<String> obtenerCategorias(){
        return new ArrayList<>(mapaProductos.keySet());
    }

    @Override
    public ArrayList<Producto> mostrarProductosPorPatron(String patron) {

        //Recorrer el mapa de productos
        ArrayList<Producto> resultado = new ArrayList<>();
        for(String categoria : mapaProductos.keySet()){
            //Para cada categoria extraemos los productos de cada categoría
            ArrayList<Producto> productos= (ArrayList<Producto>) mapaProductos.get(categoria);
            //Recorremos el arrayList de productos para cada categoría
            for(Producto p : productos){

                if(p.getNombre().toLowerCase().contains(patron.toLowerCase())){
                    resultado.add(p);
                }
            }
    }
        return resultado;
    }

    @Override
    public double valorMedioPorCategoria(String categoria) {
        ArrayList<Producto> productos = (ArrayList<Producto>) mapaProductos.get(categoria);
        if(productos.isEmpty()){
            //Verificación de que la categoría existe
            return 0;
        }
        double suma = 0;
        for(Producto p: productos){
            suma += p.getPrecio();
        }
        return suma/productos.size();
    }

    @Override
    public ArrayList<Producto> productosDeCategoria(String categoria) {
        return (ArrayList<Producto>) mapaProductos.get(categoria);
    }

    @Override
    public void  escribirArchivoProductosCategoria(String categoria) {
     ArrayList<Producto> productos = (ArrayList<Producto>) mapaProductos.get(categoria);
     ArrayList<String> datos = new ArrayList<>();
     for(Producto p: productos){
         datos.add(p.mostrarInfoProducto()); //Añadimos cada producto al arrayList de datos
     }
     try{
         ManejoFicheros.escribirFichero(datos, "productos_categoria_" + categoria + ".txt");
     }catch (Exception e){
         System.out.println("Error al escribir el archivo: " + e.getMessage());
     }

    }
//Método para mostrar los productos de una categoría
    @Override
    public void mostrarProductosPorCategoria() {
        //Retornar los productos de una categoria

       for(String categoria: mapaProductos.keySet()) {
           ArrayList<Producto> productos = (ArrayList<Producto>) mapaProductos.get(categoria);
           if (productos.isEmpty()) { //Verificación de que la categoría existe
               //Si no existe, se muestra un mensaje de error
               System.out.println("No se han encontrado productos con esa categoría:  " + categoria);
           } else {
               //Si existe, se muestran los productos de esa categoría
               System.out.println("Categoría: " + categoria);
               System.out.println("-------------------------");
               for (Producto p : productos) {
                   System.out.println(p.mostrarInfoProducto());
               }
               System.out.println("Número de productos en la categoría " + categoria + ": " + productos.size());
               System.out.println("***************************************************************************");
           }
       }
    }
}
