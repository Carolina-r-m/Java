package rutaturistica;

import java.util.Scanner;

public class rutaTuristica {

    public static void main(String[] args) {

        // Crear objeto Scanner para leer datos desde teclado
        Scanner teclado = new Scanner(System.in);

        // Declaración de variables
        String nombreRuta;
        String tipoRuta;
        String ubicacion;
        int duracionHoras;
        double distanciaKm;

        // Entrada de datos
        System.out.println("Introduce el nombre de la ruta:");
        nombreRuta = teclado.nextLine();

        System.out.println("Introduce el tipo de ruta (senderismo, cultural, etc.):");
        tipoRuta = teclado.nextLine();

        System.out.println("Introduce la ubicación de la ruta:");
        ubicacion = teclado.nextLine();

        System.out.println("Introduce la duración aproximada (en horas):");
        duracionHoras = teclado.nextInt();

        System.out.println("Introduce la distancia aproximada (en km):");
        distanciaKm = teclado.nextDouble();

        // Salida de información
        System.out.println("\n--- INFORMACIÓN DE LA RUTA TURÍSTICA ---");
        System.out.println("Nombre de la ruta: " + nombreRuta);
        System.out.println("Tipo de ruta: " + tipoRuta);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Duración aproximada: " + duracionHoras + " horas");
        System.out.println("Distancia: " + distanciaKm + " km");

        // Cerrar Scanner
        teclado.close();
    }
}