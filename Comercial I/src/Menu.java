//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import javax.swing.*;
import javax.xml.transform.stream.StreamSource;
import java.util.Scanner;

public class Menu {
    private static Concesionario concesionario;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        concesionario = new Concesionario("Ávila", "Calle", "José Rodríguez");

        //Método que muestre el menú
        int opcion;
        do {
            opcion=mostrarMenu();
            switch (opcion) {
                case 1:
                    crearVehiculo();
                    break;
                case 2:
                    agregarComercial();
                    break;
                case 3:
                    crearCliente();
                    break;
                case 4:
                    verCliente();
                    break;
                case 5:
                    verVehiculo();
                    break;
                case 6:
                    ventasVehiculo();
                    break;
                    case 7:
                        registrarVenta();
                        break;
                case 8:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while(opcion!=8);
    }

//Métodos

    private static void crearVehiculo() {
        System.out.println("Introduce la matricula");
        String matricula = sc.nextLine();
        System.out.println("Introduce la marca");
        String marca = sc.nextLine();
        System.out.println("Introduce el modelo ");
        String modelo=sc.nextLine();
        System.out.println("Introduce el nº de ruedas");
        int ruedas=sc.nextInt();
        sc.nextLine(); //Limpiando el buffer del enter
        Vehiculo vehiculo = new Vehiculo(matricula, marca, ruedas, modelo);
        //Comprobar el método
        if(concesionario.anadirVehiculo(vehiculo)){
            System.out.println("Vehiculo agregado correctamente");
        } else{
            System.out.println("Vehiculo existente");
        }
    }
    private static void agregarComercial() {
    }
    private static void crearCliente() {
    }
    private static void verCliente() {
    }
    private static void verVehiculo() {
    }
    private static void ventasVehiculo() {
    }
    private static void registrarVenta() {
        System.out.println("Introduce matricula");
        String matricula=sc.nextLine();
    }


    private static int mostrarMenu(){
        System.out.println("Menú");
        System.out.println("1. Crear vehículo");
        System.out.println("2. Agregar comercial");
        System.out.println("3. Cliente");
        System.out.println("4. Ver cliente");
        System.out.println("5. Datos del vehículo");
        System.out.println("6. Ventas del vehículo");
        System.out.println("7. Registrar venta");

        System.out.println("8. Salir");
        //Opciones: 1. Crear vehiculo, 2. Agregar comercial, 3. Cliente 4.Ver cliente, datos de vehiculo..., ver ventas de un vehiculo
        System.out.println("Elige una opción");
        int opcion=sc.nextInt();
        return opcion;

        //A partir de un fichero rellenar las estructuras de datos de una clase...

    }

}

