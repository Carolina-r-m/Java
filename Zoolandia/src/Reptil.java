public class Reptil extends Animal {
    private boolean esAcuatico;

    public Reptil(int id, String nombre, String sexo, int estado, int nCrias, boolean esAcuatico) {
        super(id,nombre, sexo, estado, nCrias);
        this.esAcuatico = esAcuatico;
    }
    //nuevo constructor
    public Reptil(int id, String nombre, String sexo, int estado, int nCrias){
        super(id, nombre, sexo, estado, nCrias);
    }

    public boolean isEsAcuatico() {
        return esAcuatico;
    }

    public void setEsAcuatico(boolean esAcuatico) {
        this.esAcuatico = esAcuatico;
    }
}
