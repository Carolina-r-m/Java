public abstract class Animal {
    private int id;
    private String nombre;
    private String sexo;
    private int estado;
    private int nCrias;

    public Animal(int id, String nombre, String sexo, int estado, int nCrias) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.estado = estado;
        this.nCrias = nCrias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getnCrias() {
        return nCrias;
    }

    public void setnCrias(int nCrias) {
        this.nCrias = nCrias;
    }
}
