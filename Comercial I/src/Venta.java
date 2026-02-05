import java.time.LocalDate;

public class Venta {
   private int  id;
   private Comercial comercial;
   private Cliente cliente;
   private Vehiculo vehiculo;
   private LocalDate fechaVenta;
   private float precioVenta;

    public Venta(int id, Comercial comercial, Cliente cliente, Vehiculo vehiculo, LocalDate fechaVenta, float precioVenta) {
        this.id = id;
        this.comercial = comercial;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaVenta = fechaVenta;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comercial getComercial() {
        return comercial;
    }

    public void setComercial(Comercial comercial) {
        this.comercial = comercial;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
}
