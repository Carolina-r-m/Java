import java.time.LocalDate;

public class Pez extends Animal {
    private  String color;
    private  double phActual;
    private double phApropiado;


    public Pez(String nombre, LocalDate fechaNacimiento, double peso, String color, double phActual, double phApropiado) {
        super(nombre, fechaNacimiento, peso);
        this.color = color;
        this.phActual = phActual;
        this.phApropiado = phApropiado;


    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPhActual() {
        return phActual;
    }

    public void setPhActual(double phActual) {
        this.phActual = phActual;
    }

    public double getPhApropiado() {
        return phApropiado;
    }

    public void setPhApropiado(double phApropiado) {
        this.phApropiado = phApropiado;
    }

    //Comprobar PH del agua
    public void revisarPh(){
        if(phApropiado != phActual){
           phActual = phApropiado;
        }
    }
    //Mostrar animal
    public void mostrarAnimal(){
        System.out.println("Pez: "+ this.getNombre() + " Color: "+ this.color + " Peso: "+this.getPeso() + " Fecha de nacimiento "+ this.getFechaNacimiento()
        + " PH Actual " + this.phActual + " PH ideal: " +  this.phApropiado);

    }
}
