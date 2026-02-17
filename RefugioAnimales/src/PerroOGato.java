import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PerroOGato extends Animal {
    private boolean esPerro;
    private String raza;
    private LocalDate fechaVacunacion;

    public PerroOGato(String nombre, LocalDate fechaNacimiento, double peso, boolean esPerro, String raza, LocalDate fechaVacunacion) {
        super(nombre, fechaNacimiento, peso);
        this.esPerro = esPerro;
        this.raza = raza;
        this.fechaVacunacion = fechaVacunacion;
    }
//Getters y setters
    public boolean isEsPerro() {
        return esPerro;
    }

    public void setEsPerro(boolean esPerro) {

        this.esPerro = esPerro;
    }

    public String getRaza() {

        return raza;
    }

    public void setRaza(String raza) {

        this.raza = raza;
    }

    public LocalDate getFechaVacunacion() {

        return fechaVacunacion;
    }

    public void setFechaVacunacion(LocalDate fechaVacunacion) {

        this.fechaVacunacion = fechaVacunacion;
    }
    //Método para se vacunó hace más de un
    //mes, deberá volver a vacunarse, actualizando la fecha
    //correspondiente.

   /*   public void revisar() {

      // Comprobamos si ha pasado más de un mes desde la última vacuna
        if (fechaVacunacion.plusMonths(1).isBefore(LocalDate.now())) {

            if (esPerro) {
                System.out.println("El perro necesita volver a vacunarse.");
            } else {
                System.out.println("El perro necesita volver a vacunarse.");
            }

            // Actualizamos la fecha de vacunación
            fechaVacunacion = LocalDate.now();

        } else {

            if (esPerro) {
                System.out.println("El gato está correctamente vacunado.");
            } else {
                System.out.println("El gato necesita volver a vacunarse.");
            }
        }*/
public void actualizarFechaVacunacion() {
    if (ChronoUnit.MONTHS.between(fechaVacunacion, LocalDate.now()) >= 1) {
            fechaVacunacion = LocalDate.now();
        }
}
    //Mostrar animal
    public void mostrarAnimal(){
    if(esPerro){
        System.out.print("Perro: ");
    }else {
        System.out.print("Gato: ");
    }
        System.out.println("Nombre: "+this.getNombre() + " Raza " + this.raza + " Peso: "+this.getPeso() + " Fecha de nacimiento "+ this.getFechaNacimiento() +
                " Fecha ult vacunación: " +  this.fechaVacunacion);

    }
    }


