import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1 {

    // Filas: 0 = Calorías, 1 = Grasas, 2 = Colesterol, 3 = Azúcares
    // Columnas: una por alimento
    static final String[] ALIMENTOS = {"FRUTA", "ZUMO", "PIZZA", "CEREALES"};
    static final int[][] DATOS = {
            {50, 24, 200, 304},
            {1, 0, 10, 36},
            {0, 0, 59, 8},
            {15, 18, 7, 12}
    };

    static final int CALORIAS = 0;
    static final int GRASAS = 1;
    static final int COLESTEROL = 2;
    static final int AZUCARES = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    alimentoMasSano();
                    break;
                case 2:
                    clasificacionNutriscore();
                    break;
                case 3:
                    mayorYMenorEnergia();
                    break;
                case 4:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 4);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("----- MENÚ DE OPCIONES -----");
        System.out.println("1. ALIMENTO MÁS SANO");
        System.out.println("2. CLASIFICACIÓN NUTRISCORE");
        System.out.println("3. ALIMENTOS CON MAYOR Y MENOR ENERGÍA");
        System.out.println("4. SALIR");
        System.out.println("Seleccione una opción...");
    }

    // Opción 1: menor media de (grasa + colesterol + azúcares) / 3
    static void alimentoMasSano() {
        int indiceMejor = 0;
        double mejorMedia = Double.MAX_VALUE;

        for (int i = 0; i < ALIMENTOS.length; i++) {
            double media = (DATOS[GRASAS][i] + DATOS[COLESTEROL][i] + DATOS[AZUCARES][i]) / 3.0;
            if (media < mejorMedia) {
                mejorMedia = media;
                indiceMejor = i;
            }
        }

        System.out.println(String.format(new Locale("es", "ES"),
                "El alimento más sano es: %s con un valor medio nutricional de %.2f",
                ALIMENTOS[indiceMejor], mejorMedia));
    }

    // Opción 2: NS = Calorías - (Azúcares + Grasas * Colesterol)
    static void clasificacionNutriscore() {
        for (int i = 0; i < ALIMENTOS.length; i++) {
            int ns = DATOS[CALORIAS][i] - (DATOS[AZUCARES][i] + DATOS[GRASAS][i] * DATOS[COLESTEROL][i]);
            System.out.println("Alimento-> " + ALIMENTOS[i] + "  Clasificación -> " + letraNutriscore(ns));
        }
    }

    static char letraNutriscore(int ns) {
        if (ns >= 10) {
            return 'A';
        } else if (ns >= 5) {
            return 'B';
        } else if (ns >= 2) {
            return 'C';
        } else if (ns >= 0) {
            return 'D';
        } else {
            return 'E';
        }
    }

    // Opción 3: Energía = Calorías - Azúcares
    static void mayorYMenorEnergia() {
        int indiceMayor = 0;
        int indiceMenor = 0;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        for (int i = 0; i < ALIMENTOS.length; i++) {
            int energia = DATOS[CALORIAS][i] - DATOS[AZUCARES][i];
            if (energia > mayor) {
                mayor = energia;
                indiceMayor = i;
            }
            if (energia < menor) {
                menor = energia;
                indiceMenor = i;
            }
        }

        System.out.println("Alimentos con MAYOR y MENOR aporte energético:");
        System.out.println("- MAYOR aporte energético-> " + ALIMENTOS[indiceMayor] + " - " + mayor + " Kj.");
        System.out.println("- MENOR aporte energético-> " + ALIMENTOS[indiceMenor] + " - " + menor + " Kj.");
    }
}
