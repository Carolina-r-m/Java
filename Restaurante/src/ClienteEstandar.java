public class ClienteEstandar extends Cliente {
    private int nFrecuentado;
    public ClienteEstandar(String nombre, int edad, String tarjetaCredito, int nFrecuentado) {
    super(nombre, edad, tarjetaCredito);
    this.nFrecuentado = nFrecuentado;

    }

    public int getnFrecuentado() {
        return nFrecuentado;
    }

    public void setnFrecuentado(int nFrecuentado) {
        this.nFrecuentado = nFrecuentado;
    }


    @Override
    public String mostrarInfo() {
        return "Nombre: " + getNombre() + " Edad: " + getEdad() + " Vip: No";
    }
}
