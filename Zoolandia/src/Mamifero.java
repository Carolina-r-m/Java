public class Mamifero extends Animal {
    private double peso;
    private double altura;
    private boolean carnivoro;

    public Mamifero(int id, String nombre, String sexo, int estado, int nCrias, double peso, double altura, boolean carnivoro) {
        super(id, nombre, sexo, estado, nCrias);
        this.peso = peso;
        this.altura = altura;
        this.carnivoro = carnivoro;
    }
    //nuevo constructor
    public Mamifero(int id, String nombre, String sexo, int estado, int nCrias){
        super(id, nombre, sexo, estado, nCrias);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean isCarnivoro() {
        return carnivoro;
    }

    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }
}
