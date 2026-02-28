import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Animal> animales = new ArrayList<>();
    public static void main (String[] args) {
    int opcion;
    do{
       opcion=menuAnimal();
       switch(opcion){
           case 1:
               anadirAnimal();
               break;
           case 2:
               cambiarEstadoAnimal();
                break;
           case 3:
               mostrarAnimalesPorEstado();
               break;
           case 4:
                mostrarAnimalesPorEspecie();
                break;
              case 5:
                  volcadoFichero();
                    break;
           case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                        default:
                            System.out.println("Opción inválida");
       }
    }while(opcion!=6);

    }



    //Método menú para mostrar las opciones al usuario
    public static int menuAnimal(){
        System.out.println("1.Añadir animal al zoo");
        System.out.println("2. Cambiar el estado de una animal ");
        System.out.println("3. Mostrar animales por estado ");
        System.out.println("4. Mostrar animales por especie ");
        System.out.println("5. Volcado a fichero ");
        System.out.println("6. Salir ");

        System.out.println("Elija la opción deseada: ");
        int opcion = sc.nextInt();
        return opcion;

    }

    //Método para añadir un animal al zoo

    public static void anadirAnimal() {
        String sexo;
        System.out.println("Ingrese el id del animal: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el nombre del animal: ");
        String nombre = sc.nextLine();
        //Sexo del animal
        do {
            System.out.println("Ingrese el sexo del animal, (M/H): ");
            sexo = sc.nextLine();
            //Validar el sexo ingresado
            if (!(sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("H"))) {
                System.out.println("Sexo inválido, ingrese M para macho o H para hembra");
            }
        } while ((!(sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("H"))));
        //Si es hembra saber el número de crias que tiene
        int numCrias = 0;
        if (sexo.equalsIgnoreCase("H")) {
            System.out.println("Ingrese el nº de crias que tiene ");
            numCrias = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
        } else {
            numCrias = 0; // Si es macho, el número de crías se establece en 0
        }

        //Estado para validar el estado del animal
        int estado=pedirEstado();


        //Especie del animal,
        // Mamifero, ave o reptil
        String especie;
        do {
            System.out.println("Ingrese la especie del animal: Mamifero(M), Ave(A) o Reptil(R) ");
            especie = sc.nextLine();
            if (!(especie.equalsIgnoreCase("M") || especie.equalsIgnoreCase("A") || especie.equalsIgnoreCase("R"))) {
                System.out.println("Especie inválida, ingrese M para mamífero, A para ave o R para reptil");
            }
        }while (!(especie.equalsIgnoreCase("M") || especie.equalsIgnoreCase("A") || especie.equalsIgnoreCase("R"))) ;
        switch (especie.toUpperCase()) {
            case "M":
               Mamifero mamifero= new Mamifero(id, nombre, sexo, numCrias, estado);
               datosMamifero(mamifero);// Método para pedir los datos específicos de un mamífero

                break;
            case "A":
                Ave ave= new Ave(id, nombre, sexo, numCrias, estado);
                datosAve(ave);// Método para pedir los datos específicos de un mamífero

                break;
            case "R":
                Reptil reptil= new Reptil(id, nombre, sexo, numCrias, estado);
                datosReptil(reptil);// Método para pedir los datos específicos de un mamífero

                break;
        }

    }
    //Método para datos específicos de un mamífero
    private static void datosMamifero(Mamifero mamifero) {
        System.out.println("Ingrese el peso del mamifero: ");
        double peso = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese la altura del mamifero: ");
        double altura = sc.nextDouble();
        sc.nextLine();
        System.out.println("¿Es un mamífero carnívoro? (S/N): ");
        String carnivoroInput = sc.nextLine(); // Leer la respuesta del usuario
        mamifero.setPeso(peso);
        mamifero.setAltura(altura);
        if (carnivoroInput.equalsIgnoreCase("S")) {
            mamifero.setCarnivoro(true);
        }else{
            mamifero.setCarnivoro(false);
        }
        animales.add(mamifero);
    }

//Método para datos específicos de un ave
    private static void datosAve(Ave ave) {
        System.out.println("Ingrese color del plumaje del ave: ");
        String colorPlumaje = sc.nextLine();
        System.out.println("Ingrese la longitud del pico del ave: ");
        double longitudPico = sc.nextDouble();
        sc.nextLine();
        animales.add(ave);
    }
    //Método para datos específicos de un reptil
    private static void datosReptil(Reptil reptil) {
        System.out.println("El reptil es acuático? (S/N): ");
        String acuaticoInput = sc.nextLine(); // Leer la respuesta del usuario
        if(acuaticoInput.equalsIgnoreCase("S")){
            reptil.setEsAcuatico(true);
        }else {
            reptil.setEsAcuatico(false);
        }
        animales.add(reptil);
    }
    //Pedir estado
    public static int pedirEstado(){
        int estado;
        do {
            System.out.println("Ingrese el estado del animal: 0 Sano, 1 Enfermo, 1 En tratamiento");
            estado = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            if (estado < 0 || estado > 2) {
                System.out.println("Estado inválido, ingrese 0 Sano, 1 Enfermo, 1 En tratamiento");
            }
        } while (estado < 0 || estado > 2);
        return estado;
    }
    public static void cambiarEstadoAnimal(){
        System.out.println("Ingrese el id del animal para cambiar su estado: ");
        int id = sc.nextInt();
        sc.nextLine();
        //Recorrer el arrayList para encontrar el animal con el id ingresado
        boolean encontrado = false;
        for (Animal animal : animales) {
            if (animal.getId() == id) {
                int estado = pedirEstado();
                animal.setEstado(estado); // Cambiar el estado del animal
                encontrado = true; // Marcar como encontrado
                break;
            }
        }
        if(encontrado==true){
            System.out.println("Se actualizó el estado del animal con id: " + id);
        }else {
            System.out.println("No se puede cambiar su estado");
        }
    }
    //Obtener lista de animales enfermos (No se muestra por pantalla)
    public static List<Animal> animalesEnfermos(){
        List<Animal>enfermos = new ArrayList<>();
        for(Animal animal: animales){
            if(animal.getEstado() == 1){
                enfermos.add(animal);
            }
        }
        return enfermos;
    }
    //Obtener lista de animales por Especie
    public static List <Animal> animalesEspecie(){
        List<Animal> especies = new ArrayList<>();
        System.out.println("Ingrese la especial del animal ");
        String especie;
        do {
            System.out.println("Ingrese la especie del animal: Mamifero(M), Ave(A) o Reptil(R) ");
            especie = sc.nextLine();
            if (!(especie.equalsIgnoreCase("M") || especie.equalsIgnoreCase("A") || especie.equalsIgnoreCase("R"))) {
                System.out.println("Especie inválida, ingrese M para mamífero, A para ave o R para reptil");
            }
        }while (!(especie.equalsIgnoreCase("M") || especie.equalsIgnoreCase("A") || especie.equalsIgnoreCase("R"))) ;
        //Recorrer el arrayList para encontrar los animales de la especie ingresada
        for(Animal animal: animales){
           switch (especie){
               case "M":
                   if(animal instanceof Mamifero){
                       especies.add(animal);

                   }
                   break;
               case "A":
                   if(animal instanceof Ave){
                       especies.add(animal);

                   }
                   break;
               case "R":
                   if(animal instanceof Reptil){
                       especies.add(animal);

                   }
                   break;

           }

        }
        return especies;
    }
    //Mostrar animales por estado
    //Esta funcionalidad permitirá mostrar por pantalla
    //todos los animales del zoo que tengan su estado al estado indicado. El formato será el siguiente:
    private static void mostrarAnimalesPorEstado() {
        ArrayList<Animal> estadoAnimales = new ArrayList<>();
        String [] estados = {"0 Sano", "1 Enfermo", "2 Tratamiento"};
        int estado=pedirEstado();
        for(Animal animal: animales){
            if(animal.getEstado() == estado){
                estadoAnimales.add(animal);
            }
        }
        System.out.println("Estado: " + estados[estado]  + "\t Animales en ese estado: " + estadoAnimales.size());
    for(Animal animal: estadoAnimales){
        System.out.println("Id: " + animal.getId() + "\t Nombre: " + animal.getNombre() + "\t Especie: " + animal.getClass().getName());
    }
    }
    //Mostrar Animales de diferente sexo por Especie: Se mostrará en pantalla un listado del número
    //de animales de diferente sexo según la especie. El formato será el siguiente:
    public static void mostrarAnimalesPorEspecie(){
        int [][] especieAnimal = new int [3][2];
        int columna;
        String [] especie = {"Mamifero", "Ave", "Réptil"};
        for(Animal animal: animales){
            if(animal.getSexo().equals("M")){
                columna=0; //Machos
            }else{
                columna=1; //Hembras
            }
            if(animal instanceof Mamifero){ //Mamíferos
                especieAnimal[0][columna]++;
            }else if(animal instanceof Ave){ //Aves
                especieAnimal[1][columna]++;
            }else{//Reptiles
                especieAnimal[2][columna]++;
            }
        }
      for(int i= 0; i<3; i++){
          System.out.println("Especie: " + especie[i] + "\t Machos: " + especieAnimal[i][0] + "\t Hembras: " + especieAnimal[i][1]);
      }
    }
    //Volcado a fichero: Guardar en un fichero llamado animales.txt todos los animales del zoo.
    //Según el siguiente formato:
    public static void volcadoFichero(){
        HashMap<String, List<Animal>> mapaAnimales = new HashMap<>(); // Mapa para agrupar animales por especie
        for(Animal animal: animales){
            if(animal instanceof Mamifero){
                if(!mapaAnimales.containsKey("Mamifero")){ // Si no existe la clave "Mamifero" en el mapa, crear una nueva lista para esa especie
                    mapaAnimales.put("Mamifero", new ArrayList<>()); // Crear una nueva lista para mamíferos si no existe

                }
                mapaAnimales.get("Mamifero").add(animal);
            }else{
                if(animal instanceof Ave){
                        if(!mapaAnimales.containsKey("Ave")){ // Si no existe la clave "Ave" en el mapa, crear una nueva lista para esa especie
                        mapaAnimales.put("Ave", new ArrayList<>()); // Crear una nueva lista para mamíferos si no existe

                    }
                    mapaAnimales.get("Ave").add(animal);
                }else{
                    if(!mapaAnimales.containsKey("Reptil")){ // Si no existe la clave "Reptil" en el mapa, crear una nueva lista para esa especie
                        mapaAnimales.put("Reptil", new ArrayList<>()); // Crear una nueva lista para mamíferos si no existe

                    }
                    mapaAnimales.get("Reptil").add(animal);
                }
            }
        }
        try {
            FileWriter fichero = new FileWriter("src/animales.txt");
            for(String especie: mapaAnimales.keySet()){
                fichero.write("Especie: " + especie + "\n");
                for(Animal animal: mapaAnimales.get(especie)){
                    fichero.write("Id: " + animal.getId() + " Nombre: " + animal.getNombre() + " Sexo: " + animal.getSexo() + "\n");
                }
            }
            fichero.close();
        } catch (IOException e) {
            System.out.println("Error durante la escritura del fichero: " + e.getMessage());
        }
    }
}
