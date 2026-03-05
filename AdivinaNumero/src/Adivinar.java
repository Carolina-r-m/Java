import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Adivinar {
    static Scanner sc = new Scanner(System.in);
    private static int minNumero;
    private static int minJugadores;
    static final String NOMFICHERO = "Adivinar.txt"; // Nombre del fichero donde se guardarán los récords

    public static void main(String[] args) {
        Juego juego = null; // Crear objeto juego para usar en las opciones del menú
        int opcion;
        do {
            menu();
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    interactvo(juego);
                    break;
                case 2:
                    simular(juego);
                    break;
                case 3:
                    mostrarSimulaciones();
                    break;
                case 4:
                    eliminarFichero();
                    break;
                case 5:
                    System.out.println("Salir de la aplicación");

                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 1 y 5.");
            }
        } while (opcion != 5);

    }

    //Menú
    public static void menu() {
        System.out.println("BIENVENIDO AL JUEGO DE ADIVINAR EL NÚMERO");
        System.out.println("\t1.Jugar de modo interactivo");
        System.out.println("\t2.Simular el juego");
        System.out.println("\t3.Mostrar simulaciones");
        System.out.println("\t4.Eliminar el fichero de simulaciones");
        System.out.println("\t5.Salir de la aplicación");
        System.out.println("Introduce la opción deseada: ");
    }
    //Método

    public static void interactvo(Juego juego) {

        System.out.println("¿Cuál es el número máximo? Para generar el número oculto");
        minNumero = sc.nextInt();
        sc.nextLine();
        juego = new Juego(minNumero, 1);// Se crea un nuevo juego con el número máximo y un solo jugador (modo interactivo)
        Jugador jugador = new Jugador(1);
        //Bucle para que el jugador realice jugadas hasta adivinar el número
        String resultado;
        do {
            System.out.println("Introduce un número entre 1 y " + minNumero + ": ");
            int numeroElegido = sc.nextInt();
            sc.nextLine();
            resultado = juego.jugada(numeroElegido); // Se realiza una jugada con el número elegido por el jugador y se obtiene el resultado (Mayor, Menor o Igual)
            //Igual mayor o menor
            if (resultado.equals("Igual")) {
                System.out.println("Felicidades, has adivinador el numero");
            } else {
                System.out.println("El número que has indicado es: " + resultado);
            }
        } while (!resultado.equals("Igual"));
    }

    public static void simular(Juego juego) {
        System.out.println("¿Cuál es el número máximo? Para generar el número oculto");
        minNumero = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Cuántos jugadores quieres que juegen?");
        minJugadores = sc.nextInt();
        sc.nextLine();
        // Lista de jugadores para almacenar los resultados de las simulaciones
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        for (int i = 0; i < minJugadores; i++) {
            jugadores.add(new Jugador(i));
        }
        juego = new Juego(minNumero, minJugadores);
        //Creamos el fichero para guardar los resultados de la simulación
        FileWriter fw = null;

        try {
            fw = new FileWriter("juego.txt");
            fw.write("Juego de simulación con  " + minJugadores + " jugadores, número máximo: " + minNumero + " número adivinar " + juego.getNumero() +
                    "\n");
            // Bucle para simular el juego entre los jugadores hasta que uno de ellos adivine el número
            boolean seguirJugando = true;
            Random rd = new Random();
            int numeroElegido;
            while (seguirJugando) {
                numeroElegido = rd.nextInt(1, minNumero);
                fw.write("El jugador " + juego.getTurno() + " juega el número: " + numeroElegido + "\n");
                String resultado = juego.jugada(numeroElegido);
                if (resultado.equals("Igual")) {
                    //Jugador ganador
                    seguirJugando = false;
                    fw.write("El jugador ha ganado");
                } else {
                    //Escribir el fichero con el resultado de la simulación
                    fw.write("El número elegido es " + resultado + " que el objetivo\n");
                }
            }
            fw.close();

        } catch (Exception e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());

        }
    }

    public static void eliminarFichero() {
        File f = new File("juego.txt");
        if (f.delete()) {
            System.out.println("Fichero eliminado correctamente");
        } else {
            System.out.println("Error al eliminar el fichero");
        }
    }

    public static void mostrarSimulaciones() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("juego.txt");
            br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            fr.close();
            br.close();

        }catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }catch (IOException e){
            System.out.println("Error durante la lectura del archivo: " + e.getMessage());
        }
    }
}