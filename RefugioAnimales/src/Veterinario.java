public class Veterinario {
    private static int idVeterinario=0;
    int id;
    private String nombre;
    private String direccion;
    private String nombreClinica;
    private Especialidad especialidad;

    public Veterinario(String nombre, String direccion, String nombreClinica, Especialidad especialidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreClinica = nombreClinica;
        this.especialidad = especialidad;
        idVeterinario++;
        this.id=idVeterinario;
    }

    public static int getIdVeterinario() {
        return idVeterinario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

}
