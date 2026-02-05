import java.util.Scanner;

public class GestionInventario {
    static Scanner sc = new Scanner(System.in);
    static String[][] inventario;
    static int cantProductos;

    public static void main(String[] args) {
        //Antes debemos preguntar cuantos productos quiere el usuario
        //Menú agregar producto, actualizar información y mostrar estado
        //Array bidimensional de String [][]
        //Definir una constante de tam max de filas, variable cuantos productos hay en la matriz
        //Estructura del programa principal
        //Declarar variable
        int opcion;
        inventario=null;
        cantProductos=0;
        //Mostrar el menú
        do {
            //Método
            opcion = muestraMenu();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    inicializarInventario();
                    break;
                case 2:
                    if(inventario!=null){
                        agregarProducto();
                    }else{
                        System.out.println("No está inicializado el inventario, elija previamente la opción 1 ");
                    }
                    break;
                case 3:
                    if(inventario!=null){
                        actualizarProd();
                    }else{
                        System.out.println("No está inicializado el inventario, elija previamente la opción 1. Presiones cualquier letra para continuar ");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    if(inventario!=null){
                        mostrarInv();
                    }else{
                        System.out.println("No está inicializado el inventario, elija previamente la opción 1 ");
                    }

                    break;
                case 5:
                    if(inventario!=null){
                        buscarProd();
                    }else{
                        System.out.println("No está inicializado el inventario, elija previamente la opción 1 ");
                    }

                    break;
                case 6:
                    if(inventario!=null){
                        eliminarProd();
                    }else{
                        System.out.println("No está inicializado el inventario, elija previamente la opción 1 ");
                    }

                    break;
                case 7:
                    System.out.println("Hasta otra");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 7);
    }
        //Elegir opción
        // Procesar la opción


//Muestra el menú
    private static int muestraMenu() {
        System.out.println("Menú inventario ");
        System.out.println("1. Inicializar inventario");
        System.out.println("2. Agregar producto");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Mostrar inventario");
        System.out.println("5. Buscar producto");
        System.out.println("6. Eliminar producto");
        System.out.println("7. Salir");
        System.out.print("Opción: ");

        return sc.nextInt();
    }

    private static void inicializarInventario() {
        if(inventario!=null){
            System.out.println("¿Estás seguro de inicializar el inventario? (S/N)  Está acción eliminará todos los productos guardados " );
            if(!sc.nextLine().equalsIgnoreCase("S")){
                System.out.println("Operación cancelada ");
                return;

            }
        }
        System.out.println("¿Cuántos productos tendrá el inventario?");
        int tam = sc.nextInt();
        //Creamos una nueva matriz bidimensional
        inventario = new String[tam][3];
        //Inicializo el nombre de los productos en null, porque es la forma de saber si está vacío ese índice de la fila
        for(int i=0; i<tam; i++){
            inventario[i][0]=null;
        }
        cantProductos = 0;
        System.out.println("Inventario inicializado correctamente.");
    }
    //Decido que el nombre de los productos es único.
    private static void agregarProducto() {
        String nombre;
        int cantidad;
        double precio;

        //Primero, buscar que no exista un producto con ese nombre
        if(inventario.length==cantProductos){
            System.out.println("Inventario lleno");
        }else{
            System.out.println("Nombre producto: ");
            nombre = sc.nextLine();
            if(existeProducto(nombre)==-1){
                System.out.println("Cantidad");
                cantidad = sc.nextInt();
                sc.nextLine();
                System.out.println("Precio");
                precio= sc.nextDouble();
                sc.nextLine();
                for(int i=0; i<inventario.length; i++){
                    if(inventario[i][0]==null){
                        inventario[i][0]=nombre;
                        inventario [i][1]= String.valueOf(cantidad);
                        inventario [i][2]= String.valueOf(precio);
                        cantProductos++;
                        System.out.println("Registrado con éxito");
                        return;
                    }
                }
            }else{
                System.out.println("Ya existe ese nombre, presione cualquier tecla para continuar");
                sc.nextLine();
            }
        }
    }
    private static void actualizarProd() {
 //Pedimos al usuario el nombre del producto que quiere actualizar
        if(exiInventario()) {


            System.out.println("Nombre del producto a actualizar: ");
            String nombre = sc.nextLine();
//Buscamos la posición del producto en el array
            int pos = existeProducto(nombre);
            // Si el producto no existe, avisamos y salimos del método
            if (pos == -1) {
                System.out.println("El producto no existe.");
                return;
            }
//Si existe el producto pedimos la nueva cantidad y el precio
            System.out.println("Cantidad nueva:");
            int cantidad = sc.nextInt();
            sc.nextLine();
            System.out.println("Precio nuevo:");
            double precio = sc.nextDouble();
            sc.nextLine();
//Guardamos los valores en el array
            inventario[pos][1] = String.valueOf(cantidad);
            inventario[pos][2] = String.valueOf(precio);

            System.out.println("Producto actualizado correctamente.");
        }
    }

    private static void mostrarInv() {
        if(exiInventario()) {
            System.out.println("Estado del inventario");
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i] != null) {
                    System.out.println(inventario[i]);

                }
            }
        }
    }
    //Buscar producto
    private static void buscarProd() {
        if(exiInventario()) {
            System.out.println("Nombre producto: ");
            String nombre = sc.nextLine();
            int pos = existeProducto(nombre);
            // Si el producto no existe, avisamos y salimos del método
            if (pos == -1) {
                System.out.println("El producto no existe.");
                return;
            }
                    System.out.println(inventario[pos]);
        }
    }

    //Al eliminar un producto, se va a marcar en vacío, es decir, la primera columna va a ser null, que corresponde al nombre del producto
    private static void eliminarProd() {
        System.out.println("Eliminando producto a eliminar: ");
        String nombre = sc.nextLine();
        //Buscamos la posición del producto a eliminar
        int pos = existeProducto(nombre);
        if(existeProducto(nombre)==-1){
            System.out.println("El producto no existe.");

        } else{
            inventario[pos][0] = null;
            cantProductos--;
        }
    }

    //Métodos auxiliares
    private static int existeProducto(String nombre) {
        for(int i=0; i<inventario.length; i++){
            if(inventario[i][0]!=null && inventario[i][0].equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }
    //método para determinar si existen productos en el inventario

    private static boolean exiInventario(){
        if(cantProductos==0){
            System.out.println("Inventario vacío");
            return false;
        }
        return true;
    }
}

