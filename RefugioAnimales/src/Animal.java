import java.time.LocalDate;

public class Animal implements  Comparable<Animal>{


    private static int idAnimal = 0; //Para generar id

    private  int id;
    private  String nombre;
    private LocalDate fechaNacimiento;
    private double peso;

    public Animal(String nombre, LocalDate fechaNacimiento, double peso) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        //Incrementamos
        idAnimal++;
        this.id=idAnimal;
    }

    public static int getIdAnimal() {
        return idAnimal;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }
//Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
        //Implementar dentro de la clase, implementamos comparable
        @Override
        public int compareTo(Animal a) {
        //Si no tengo con quien comprar
            if(a==null){
                return 0;
            }
        //Es menor
           if(this.fechaNacimiento.compareTo(a.fechaNacimiento)<0){
               return -1;
           }
           //Es mayor
           if(this.fechaNacimiento.compareTo(a.fechaNacimiento)>0){
               return 1;
           }else {
               //Si tienen la misma edad, se ordena por nombre
               return this.nombre.compareTo(a.nombre);
           }
        }
        //Mostrar animal
    public void mostrarAnimal(){
        System.out.println("Animal: "+this.nombre + " Peso: "+this.peso + " Fecha de nacimiento "+ this.fechaNacimiento);

    }
}
