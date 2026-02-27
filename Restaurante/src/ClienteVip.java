import java.util.ArrayList;

public class ClienteVip extends Cliente {
    private double descuento;
    public  ClienteVip (String nombre, int edad, String tarjetaCredito, double descuento) {
        super(nombre, edad, tarjetaCredito);
        this.descuento = descuento;
        ArrayList <Cliente> clientes = new ArrayList<>(); // Lista de clientes para aplicar el descuento
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
   // Método para aplicar el descuento al total gastado por el cliente VIP
    public double aplicarDescuento(double totalGastado) {
        return totalGastado * (1 - descuento); // Aplica el descuento al total gastado
    }
    // Sobrescribe el método esVip para indicar que este cliente es VIP
    @Override
    public boolean esVip() {
        return true;
    }

    @Override
    public String mostrarInfo() {
        return "Nombre: " + getNombre() + " Edad: " + getEdad() + " Vip: Si";
    }
}
