import java.util.ArrayList;

public class Concesionario {
    private String nombre;
    private  String direccion;
    private String nombreDirector;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Comercial>comerciales;
    private ArrayList<Venta>ventas;

    public Concesionario(String nombre, String direccion, String nombreDirector) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreDirector = nombreDirector;
        //Arraylist
        this.vehiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.comerciales = new ArrayList<>();
        this.ventas = new ArrayList<>();

    }

    //Método para buscar si un cliente existe
    public boolean existeCliente(int id){
        for(int i=0; i<clientes.size();i++){
            if(clientes.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }
    public Cliente obtenerCliente(int id){

        for(int i=0; i<clientes.size();i++){
            if(clientes.get(i).getId()==id){
                return clientes.get(i);
            }
        }
        return null;
    }
    //Devolver la posión donde se encuentra el cliente
    public int  obtenerPosCliente(int id){

        for(int i=0; i<clientes.size();i++){
            if(clientes.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    //Métodos adicionales en este caso para trabajar con ArrayList
    public boolean anadirCliente(Cliente cliente){
        if(existeCliente(cliente.getId())){
            //if(obtenerCliente(cliente.getId())!=null) <-- Equivalente al if de la 58, pero usando el método de obtenerCliente
            return false;
        } else{
            clientes.add(cliente);
            return true;
        }
    }
    //Método que nos permita añadir un cliente
    public boolean eliminarCliente(int id){
        int guardarPos=obtenerPosCliente(id);
        if(guardarPos!=-1){
            return false;
        }
        clientes.remove(guardarPos);
        return true;
    }
    //Método para modificar cliente
    public boolean modificarCliente(Cliente cliente){
        //Buscar en que posición el cliente, y si está y agregamos en el arraylist el nuevo
        int guardarPos=obtenerPosCliente(cliente.getId());
        if(guardarPos!=-1){
            return false;
        }
        clientes.remove(guardarPos);
        //nombreArray.add (objeto);
        clientes.add(cliente);
        return true;
    }

    //Vehiculos y Comerciales
    public boolean existeVehiculo(String matricula){
        for(Vehiculo elemento: vehiculos){
            if(elemento.getMatricula().equalsIgnoreCase(matricula)){
                return true;
            }
        }
        return false;
    }

    //Comprueba los datos de la matricula...
    public Vehiculo obtenerVehiculo(String matricula){

        for(int i=0; i<vehiculos.size();i++){
            if(vehiculos.get(i).getMatricula().equalsIgnoreCase(matricula)){
                return vehiculos.get(i);
            }
        }
        return null;
    }
    public boolean anadirVehiculo(Vehiculo vehiculo){
        if(existeVehiculo(vehiculo.getMatricula())){
            //if(obtenerCliente(cliente.getId())!=null) <-- Equivalente al if de la 58, pero usando el método de obtenerVehiculo
            return false;
        } else{
            vehiculos.add(vehiculo);
            return true;
        }
    }
}
