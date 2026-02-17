import java.time.LocalDate;

public class Pajaro extends Animal {
    private String especie;
    private double pesoIdeal;

    public Pajaro(String nombre, LocalDate fechaNacimiento, double peso, String especie, double pesoIdeal){
        super(nombre, fechaNacimiento, peso);
        this.especie = especie;
        this.pesoIdeal = pesoIdeal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }
    //Peso ideal
    public boolean revisarPesoIdeal(){
        return getPeso()< pesoIdeal;

    }
    //Mostrar animal
    public void mostrarAnimal(){
        System.out.println("Pájaro: "+this.getNombre() + " Especie: " + this.especie + " Peso: "+this.getPeso() + " Fecha de nacimiento "+
                this.getFechaNacimiento() + " Peso ideal: " + this.pesoIdeal
            );

    }
}
