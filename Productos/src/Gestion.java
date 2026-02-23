import java.util.*;
//Programa principal de gestión de productos
public class Gestion {
    static Scanner sc= new Scanner(System.in);
    public static void main (String [] args){

        GestorProducto gestor =new GestorProducto();

        //Atrapamos la excepcion con un trycatch
        try{
            gestor.setMapaProductos(ManejoFicheros.leerFicheros("productos.txt")); //Genera la excepción
            //Métodos
            System.out.println("Bienvenido al gestor de productos");
            System.out.println("Se mostrará información sobre los productos, por favor siga las instrucciones");
            mostrarProductosPorPatron(gestor);
            System.out.println("Se mostrará el valor medio de una categoría seleccionada ");
            valorMedioPorCategoria(gestor);
            System.out.println("Se mostrarán los productos de una categoría seleccionada ");
            productosDeCategoria(gestor);
            System.out.println("Se escribirá un archivo con los productos de una categoría seleccionada");
            escribirArchivoProductosCategoria(gestor);
            System.out.println("Se mostrarán los productos agrupados por categoría ");
            mostrarProductosAgrupados(gestor);

            //Pedimos al usuario que introduzca el texto del nombre
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Métodos
    private static void mostrarProductosPorPatron(GestorProducto gestor) {
        ArrayList<Producto> productosPatron;
        System.out.println("Intruduce el patrón de búsqueda para el nombre del producto:");
        String patron = sc.nextLine();
        productosPatron= gestor.mostrarProductosPorPatron(patron);
        //Resultado
        if(productosPatron.isEmpty()){
            System.out.println("No se han encontrado productos con el patrón: " + patron);
        }else{
            for(Producto p: productosPatron){
                System.out.println(p.mostrarInfoProducto());
            }
        }

    }
    private static void valorMedioPorCategoria(GestorProducto gestor) {
        String categoria = mostrarCategoriasUsuario(gestor);
        double valorMedio;

        valorMedio=gestor.valorMedioPorCategoria(categoria);
        System.out.println("El valor medio de la categoría " + categoria + " es: " + valorMedio);

    }

    private static void productosDeCategoria(GestorProducto gestor) {
        ArrayList<Producto> productosCategoria;
        //Retornar los productos de una categoria
        String categoria = mostrarCategoriasUsuario(gestor);
        productosCategoria=gestor.productosDeCategoria(categoria);
        //Resultado
        if(productosCategoria.isEmpty()){
            System.out.println("No se han encontrado productos con esa categoría:  " + categoria);
        }else{
            for(Producto p: productosCategoria){
                System.out.println(p.mostrarInfoProducto());
            }
        }

    }
    //Método para escribir un archivo con los productos de una categoría
    private static void escribirArchivoProductosCategoria(GestorProducto gestor) {
        String categoria = mostrarCategoriasUsuario(gestor);
        gestor.escribirArchivoProductosCategoria(categoria);
    }
    //Método para mostrar los productos agrupados por categoría
    private static void mostrarProductosAgrupados(GestorProducto gestor) {
        // Recorremos todas las categorías y mostramos cada una con su método
        gestor.mostrarProductosPorCategoria();

    }

//Método para mostrar las categorias y que el usuario seleccione la que quiere
    private static String mostrarCategoriasUsuario(GestorProducto gestor){
        int contador = 1;
        ArrayList<String> categorias;
        double valorMedio;
        do {
            System.out.println("Categorías existentes: ");
            contador = 1;
            //Conjunto de categorías del mapa, recorremos el mapa para mostrar las categorías
            categorias = gestor.obtenerCategorias();
            for (String categoria : categorias) {
                System.out.println(contador + " " + categoria);
                contador++;
            }
            System.out.println("Seleccione una categoría para mostrar: ");
           try {
               contador = sc.nextInt();

           }catch (Exception e){
               contador=0;

               //Limpiar el buffer del scanner
           }
            sc.nextLine();
            //Verificar que la categoría seleccionada es válida
            if (contador < 1 || contador > categorias.size()) {
                System.out.println("Categoría no válida");
            }
        } while (contador < 1 || contador > categorias.size());
        return categorias.get (contador-1);

    }
}
