import java.util.ArrayList;

public class Comercial extends Persona {
    private String rol;
    private int ventas;
    private ArrayList<Cliente> clientes;
    public Comercial(int id,String nombre, String apellido, String direccion, String telefono, String email, String rol) {
        super(id,nombre, apellido, direccion, telefono, email);
        this.rol = rol;
        this.ventas = 0; //Todavía no tengo ventas
        clientes=  new ArrayList<>();
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
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
    //Método que nos permita eliminar un cliente
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
}

