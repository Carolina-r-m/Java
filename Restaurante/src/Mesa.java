import java.util.ArrayList;

public class Mesa {
    private String idMesa;
    //ArrayList de clientes
    private ArrayList<Cliente> clientes;
    private double totalGastado;
    // Constructor
    public Mesa (String idMesa) {
        this.idMesa = idMesa;
        totalGastado = 0;
        clientes = new ArrayList<>();
    }


    public String getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(String idMesa) {
        this.idMesa = idMesa;
    }

    public double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(double totalGastado) {
        this.totalGastado = totalGastado;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void agregaCliente (Cliente cliente){
        clientes.add(cliente);
}

//Método para mostrar los datos de la mesa, incluyendo el ID, el total gastado y la lista de clientes con su información
    public String mostraDatos(){
        StringBuilder sb = new StringBuilder(); // Usamos StringBuilder para construir la cadena de salida
        sb.append("Mesa: " + idMesa + "\tConsumido:" + totalGastado + "\tClientes:" + clientes.size() + "\n\n");

        for(int i= 0; i<clientes.size(); i++){
            sb.append("Cliente " + (i+1) + ": " + clientes.get(i).mostrarInfo() + "\n");
        }
        sb.append("\n");
        return sb.toString(); // Retorna la cadena con la información de la mesa
    }
   //Método
   public String mostrarFinMesa(){
       StringBuilder sb = new StringBuilder(); // Usamos StringBuilder para construir la cadena de salida
       sb.append("Mesa: " + idMesa +  "\tClientes:" + clientes.size() + "\n" + "\tConsumido:" + totalGastado + "\tPrecio final: " + calcularPrecioFinal() + "\n\n");

       for(int i= 0; i<clientes.size(); i++){
           sb.append("Cliente " + (i+1) + ": " + clientes.get(i).mostrarInfo() + "\n");
       }
       sb.append("\n");
       return sb.toString(); // Retorna la cadena con la información de la mesa
   }
   //Método calcular el precio final de la mesa, aplicando descuentos a los clientes VIP
    public double calcularPrecioFinal() {
        double precioFinal = totalGastado;
        double descuentoMayor = 0;
        Cliente cliente=null;
        for(cliente: clientes){
            if(cliente instanceof ClienteVip){
               if(((ClienteVip) cliente).getDescuento()< descuentoMayor){
                   descuentoMayor = ((ClienteVip)cliente).getDescuento();
               }

            }
        }
        precioFinal = totalGastado * (1 - descuentoMayor);
        return precioFinal;
    }
    //Método agregarGasto
    public void agregarGasto(double gasto){
        totalGastado += gasto; // Suma el gasto al total gastado en la mesa
    }
}
