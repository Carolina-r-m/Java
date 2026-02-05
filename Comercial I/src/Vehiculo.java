public class Vehiculo {
    private String matricula;
    private String marca;
    private int ruedas;
    private String modelo;
    private String color;
    private int puertas;
    private String combustion;

    //Constructor
    public Vehiculo(String matricula,String marca, int ruedas, String modelo) {
       this.matricula = matricula;
        this.marca=marca;
        this.ruedas=ruedas;
        this.modelo=modelo;
    } //ES OBLIGATORIO Cuando hay un conflicto entre el parámetro y el nombre del atibuto, es decir que son iguales
    //Get y Set
    public String getMarca() { //Da información
        return marca;
    }
    public void setMarca(String marca) { //No devuelve, si necesita la información de que valor ponemos al atributo
        this.marca = marca;
    }
    public String getMatricula() { //Da información
        return matricula;
    }
    public void setMatricula(String matricula) { //No devuelve, si necesita la información de que valor ponemos al atributo
        this.matricula = matricula;
    }
    public int getRuedas() {
        return ruedas;
    }
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    //To String
    @Override//Sobreescritura el método de tu padre
    public String toString() {
        return "Vehiculo " + marca + "modelo " + modelo + "color " + color;
    } //Nombre único
}
