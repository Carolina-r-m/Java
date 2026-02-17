import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GestionProtectora {
private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Protectora> protectoras;
    private static ArrayList<Veterinario> veterinarios;

    public static void main(String[] args) {

        //Inicializar los arrayList
        protectoras = new ArrayList<>();
        veterinarios = new ArrayList<>();
        creacionVeterinario(); //Llamamos al método creacionVeterinario
        creacionProtectora(); //Llamamos al método creacionProtectora

        //Hacemos el menú para que el usuario elija la opción
        int opcion;
        do{
            opcion=menuProtectora();
            switch (opcion){
                case 1:
                    gestionProtectora();
                    break;
                case 2:
                    System.out.println("Hasta otra");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }while(opcion!=2);

    }
    //Menú protectora

    //Menú gestión protectora
    private static int menuProtectora(){
        int opcion;
        System.out.println("Menu protectora:");
        System.out.println("1. Gestión de protectora");
        System.out.println("2. Salir");
        System.out.println("opcion: ");

        opcion=sc.nextInt();
        sc.nextLine();
        return opcion;
    }



    //Métodos
    //Método para crear los veterinarios
    private static void creacionVeterinario(){
        veterinarios.add(new Veterinario("Carolina", "Calle Santiago", "Clínica San Francisco", Especialidad.PEQUENOS_ANIMALES));
        veterinarios.add(new Veterinario("José", "Calle Santiago", "Clínica San Francisco", Especialidad.MAMIFEROS));
        veterinarios.add(new Veterinario("Carlos", "Calle Santiago", "Clínica San Francisco", Especialidad.GENERICO));

    }

    //Ubicación de las protectoras
    private static void creacionProtectora(){
        protectoras.add(new Protectora("Cáceres"));
        protectoras.add(new Protectora("Badajoz"));
        protectoras.add(new Protectora("Burgos"));
        protectoras.add(new Protectora("Sevilla"));
    }

    //Gestión protectora
    private static void gestionProtectora(){
      //  Protectora protectora=seleccionProtectora();
        Protectora protectora= new Protectora("Wena");
        char opcion;
        do{
            System.out.println("Menú");
            System.out.println("A. Nuevo animal");
            System.out.println("B. Revisión veterinaria");
            System.out.println("C. Mostrar animales");
            System.out.println("D. Salir");
            opcion=sc.next().charAt(0);
            sc.nextLine();
                switch (opcion){
                    case 'A', 'a':
                        agregarAnimal(protectora);
                        break;
                        case 'B', 'b':
                            revisionVeterinaria(protectora);
                            break;
                            case 'C', 'c':
                                mostrarAnimales(protectora);
                                break;
                                case 'D', 'd':
                                    break;
                                    default:
                                        System.out.println("Opción inválida");
                }
        }while(opcion!='D' && opcion!='d');
    }

    //Métodos
    //Método agregar animal
    private static void agregarAnimal(Protectora protectora) {
        Animal animal= null;
       //Nombre del animal
        System.out.println("Introduzca el nombre de su animal ");
        String nombre = sc.nextLine();
        System.out.println("Peso: ");
        int peso = sc.nextInt();
        sc.nextLine();
    LocalDate fechaNacimiento = fecha("nacimiento");
        System.out.println("Introduzca que tipo de animal es: ");
        System.out.println("1. Perro, 2. Gato, 3. Pájaro, 4.Pez, 5.Otros ");
        int opcion=sc.nextInt();
        sc.nextLine();
        switch (opcion){
            case 1:
                animal=datosPerroGato(nombre, peso, fechaNacimiento, true);
    break;
    case 2:
        animal=datosPerroGato(nombre, peso, fechaNacimiento, false);
        break;
        case 3:
           animal= datosPajaro(nombre, peso, fechaNacimiento);
           break;
           case 4:
               animal= datosPez(nombre, peso, fechaNacimiento);
               break;
               case 5:
                   animal=new Animal(nombre, fechaNacimiento, peso);
                   break;
                   default:
                       System.out.println("Opción inválida");
        }
        protectora.agregarAnimal(animal);
        System.out.println("Animal acogido");
    }
    //Revisar veterinaria
    private static void revisionVeterinaria(Protectora protectora) {

        //Lo primero escogemos el veterinario de nuestro menú
        Veterinario v = veterinarios.get(0);

        System.out.println("Revisión realizada por: " + v.getNombre());
        protectora.revisionVeterinaria(v);

        //El veterinario pasa al final de la lista
        veterinarios.remove(0);
        veterinarios.add(v);

        for(Veterinario v2 : veterinarios){
            System.out.println(v2.getNombre());
        }
    }

    //Mostrar animal
    private static void mostrarAnimales(Protectora protectora) {
        mostrarCombinado(protectora);
    }

    private static Protectora seleccionProtectora() {
        int opcion;
        do {
            System.out.println("Protectoras registradas:");
            for (int i = 0; i < protectoras.size(); i++) {
                System.out.println("Protectora id: " + protectoras.get(i).getIdProtectora());
            }
            System.out.println("Selecciones el ID de la protectora ");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion < 1 || opcion > protectoras.size()) {
                System.out.println("Opción inválida");
            }
        }while (opcion < 1 || opcion > protectoras.size());

            //Bucle que permita volver a seleccionar
            return protectoras.get(opcion - 1);

    }

    //Método que pida la fecha de nacimiento
    private static LocalDate fecha(String mensaje){

        boolean fechaErronea = false;
        LocalDate fechaNacimiento = null;
        do {
            fechaErronea = false;
            try {
                System.out.println("Introduce día de " +  mensaje);
                int dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce mes de " +  mensaje);
                int mes = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduce año de " + mensaje);
                int ano = sc.nextInt();
                sc.nextLine();
                fechaNacimiento = LocalDate.of(ano, mes, dia);
            }catch (Exception e){
                System.out.println("Fecha inválida");
                fechaErronea = true;
            }
        }while(fechaErronea);
            return fechaNacimiento;
    }
    //Método perro y gato
    private static Animal datosPerroGato(String nombre, double peso, LocalDate fechaNacimiento, boolean esPerro){
        System.out.println("Introduzca la raza del animal ");
        String raza = sc.nextLine();
        sc.nextLine();
        LocalDate fechaVac = fecha("vacunación");
        return new PerroOGato(nombre, fechaNacimiento, peso, esPerro, raza, fechaVac);
    }
    //Método pájaro
    private static Animal datosPajaro(String nombre, double peso, LocalDate fechaNacimiento){
        System.out.println("Introduzca la especie: ");
        String especie = sc.nextLine();
        System.out.println("Introduzca la peso ideal: ");
        double pesoIdeal = sc.nextDouble();
        sc.nextLine();
        return new Pajaro(nombre, fechaNacimiento, peso, especie, pesoIdeal);
    }
    //Método pez
    private static Animal datosPez(String nombre, double peso, LocalDate fechaNacimiento){
        System.out.println("Introduzca el color: ");
        String color = sc.nextLine();
        System.out.println("Introduzca la ph actual: ");
        double phActual=sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduzca la ph Apropiado: ");
        double phApropiado=sc.nextDouble();
        sc.nextLine();
        return new Pez(nombre,fechaNacimiento, peso, color, phActual, phApropiado);
    }

    //Método de mostrar animal ordenar por edad y nombre
    public static void mostrarCombinado(Protectora protectora){
        //Pasamos el arraylist que queremos ordenar
        Collections.sort(protectora.getAnimales());
        //Mostramos al animal
        for(Animal animal : protectora.getAnimales()){
            animal.mostrarAnimal();
        }
        }

    //Mostrar animal por edad
    public static void mostrarEdad(Protectora protectora){
        protectora.getAnimales().sort(new AnimalComparatorEdad());
        for(Animal animal : protectora.getAnimales()){
            animal.mostrarAnimal();
        }
    }

    //Mostrar animal por nombre
    public static void mostrarNombre(Protectora protectora){
        protectora.getAnimales().sort(new AnimalComparatorNombre());
        for(Animal animal : protectora.getAnimales()){
            animal.mostrarAnimal();
        }
    }
    }

