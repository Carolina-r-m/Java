import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class Restaurante {
    private static HashMap<String, Mesa> mesas;

    public static void main(String[] args) {
        mesas = new HashMap<>();
//File reader
        FileReader fr= null;
        BufferedReader br = null;
        try {
             fr  = new FileReader("sucesos.txt");
             br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                procesarSuceso(linea);
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: ");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: ");

        }
    }

    // Método para procesar cada línea del archivo
    private static void procesarSuceso(String linea) {
        String[] partes = linea.split("#");
        String tipoSuceso = partes[0]; // El primer elemento indica el tipo de suceso

        switch (Suceso.valueOf(tipoSuceso)) { // Dependiendo del tipo de suceso, se llama al método correspondiente
            case Suceso.Cliente:
                agregarCliente(partes, false);
                break;
            case Suceso.ClienteVIP:
                agregarCliente(partes, true);
                break;
            case Suceso.Gasto:
                registrarGastoMesa(partes);
                break;
            case Suceso.MostrarOcupacion:
                mostrarOcupacion();
                break;
            case Suceso.Fin:
                finalizarMesa(partes[1]);
                break;
            default:
                System.out.println("Suceso desconocido: " + tipoSuceso);
        }
    }

    // Método para agregar un cliente a una mesa
    private static void agregarCliente(String[] partes, boolean esVip) {
        String nombre = partes[1];
        int edad = Integer.parseInt(partes[2]);
        String tarjetaCredito = partes[3];
        String idMesa = partes[5];

        // Crear o recuperar la mesa
        if (!mesas.containsKey(idMesa)) {
            mesas.put(idMesa, new Mesa(idMesa));
        }
        Mesa mesa = mesas.get(idMesa);

        // Crear el cliente según su tipo
        Cliente cliente;
        if (esVip) {
            double descuento = Double.parseDouble(partes[4]) / 100.0; // Convertir porcentaje a decimal
            cliente = new ClienteVip(nombre, edad, tarjetaCredito, descuento);
        } else {
            int nFrecuentado = Integer.parseInt(partes[4]);
            cliente = new ClienteEstandar(nombre, edad, tarjetaCredito, nFrecuentado);
        }

        // Agregar cliente a la mesa
        mesa.agregaCliente(cliente);
        System.out.println("Cliente " + nombre + " agregado a la mesa " + idMesa);
    }
//Método para registar un gasto en una mesa
        private static void registrarGastoMesa(String[]partes){
        double gasto= Double.parseDouble(partes[1]);
        String idMesa=partes[2];

        if(mesas.containsKey(idMesa)){
            mesas.get(idMesa).agregarGasto(gasto); //Actualiza el total gastado en la mesa
            System.out.println("Gasto de" + gasto + " registrado en la mesa " + idMesa);
        }else{
            System.out.println("Mesa " + idMesa + " no encontrada para registrar el gasto.");
        }

        }
        //Método para mostrar la ocupación actual del restaurante
    private static void mostrarOcupacion(){
        System.out.println("Número de mesas: " + mesas.keySet().size());
        for(String idMesa: mesas.keySet()){
            Mesa mesa= mesas.get(idMesa); // Obtener la mesa
            System.out.println(mesa.mostraDatos());
            System.out.println("...\n");;
        }
    }
    //Método para finalizar una mesa, mostrando el total gastado y la información de los clientes
    private static void finalizarMesa(String idMesa) {
        double totalGastado=0;
        try {
            FileWriter fw = new FileWriter("ventas.txt", true); // Abrir el archivo en modo de adición
            Mesa mesa= mesas.get(idMesa); // Obtener la mesa a finalizar
            fw.write(mesa.mostrarFinMesa());
            fw.close();
            mesa.getClientes().clear(); // Limpiar la lista de clientes de la mesa
            mesas.remove(idMesa); // Eliminar la mesa del mapa de mesas
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: ");
        }

    }
    }