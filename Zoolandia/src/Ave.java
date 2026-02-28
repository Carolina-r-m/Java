public class Ave extends Animal{
    private String colorPlumaje;
    private double longitudPico;

    public Ave(int id, String nombre, String sexo, int estado, int nCrias, String colorPlumaje, double longitudPico) {
        super(id, nombre, sexo, estado, nCrias);
        this.colorPlumaje = colorPlumaje;
        this.longitudPico = longitudPico;
    }
    //nuevo constructor
    public Ave(int id, String nombre, String sexo, int estado, int nCrias){
        super(id, nombre, sexo, estado, nCrias);
    }
    public String getColorPlumaje() {
        return colorPlumaje;
    }

    public void setColorPlumaje(String colorPlumaje) {
        this.colorPlumaje = colorPlumaje;
    }

    public double getLongitudPico() {
        return longitudPico;
    }

    public void setLongitudPico(double longitudPico) {
        this.longitudPico = longitudPico;
    }
}
