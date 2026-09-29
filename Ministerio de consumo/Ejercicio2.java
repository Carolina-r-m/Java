import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {

    static final int MAX_INTENTOS = 5;
    static final int LONGITUD = 5;

    static final String[] PALABRAS = {
            "perro", "plato", "trono", "pilar", "mundo", "cable", "silla", "cardo", "trato", "balsa", "cielo",
            "papel", "trino", "palco", "nieve", "campo", "barco", "fruta", "fiera", "lucha", "pieza", "nariz",
            "chuzo", "perla", "tarta", "truco", "miedo", "tabla", "radio", "sonar"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secreta = palabraSecreta();
        int intentosRestantes = MAX_INTENTOS;
        boolean acertada = false;

        while (intentosRestantes > 0 && !acertada) {
            System.out.println("Te quedan " + intentosRestantes + " intentos.");
            System.out.println("Introduce una palabra de 5 letras:");
            String intento = sc.nextLine().trim().toLowerCase();

            if (intento.length() != LONGITUD) {
                System.out.println();
                System.out.println("!!! Debes introducir una palabra de 5 letras ¡¡¡");
                System.out.println();
                continue; // no cuenta el intento
            }

            if (intento.equals(secreta)) {
                acertada = true;
                System.out.println("!!! Fantástico, has ganado ¡¡¡");
            } else {
                intentosRestantes--;
                System.out.println("Lo siento, esa no es la palabra secreta.");
                // Después del último intento no se muestra pista
                if (intentosRestantes > 0) {
                    System.out.println("Te daré una pista... " + generarPista(secreta, intento));
                    System.out.println();
                }
            }
        }

        if (!acertada) {
            System.out.println("Lo siento, ya no te quedan intentos");
            System.out.println("La palabra secreta era... " + secreta.toUpperCase());
        }

        sc.close();
    }

    // Devuelve una palabra al azar de la lista
    static String palabraSecreta() {
        Random random = new Random();
        return PALABRAS[random.nextInt(PALABRAS.length)];
    }

    // X = letra correcta en su posición, O = está pero en otra posición, - = no está
    static String generarPista(String secreta, String intento) {
        String pista = "";
        for (int i = 0; i < LONGITUD; i++) {
            char letra = intento.charAt(i);
            if (letra == secreta.charAt(i)) {
                pista += "X";
            } else if (secreta.indexOf(letra) != -1) {
                pista += "O";
            } else {
                pista += "-";
            }
        }
        return pista;
    }
}
