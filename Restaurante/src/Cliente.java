public abstract class  Cliente {
    private String nombre;
    private int edad;
    private String  tarjetaCredito;
// Constructor
    public Cliente(String nombre, int edad, String tarjetaCredito) {
        this.nombre = nombre;
        this.edad = edad;
        this.tarjetaCredito = tarjetaCredito;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
    // Método para determinar si el cliente es VIP o no
    public boolean esVip(){
        return false;
    }
    // Método abstracto para mostrar la información del cliente, que será implementado por las clases hijas
    public abstract String mostrarInfo();
}
