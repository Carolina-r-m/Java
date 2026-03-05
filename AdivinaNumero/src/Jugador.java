public class Jugador {
    private int id;
    private boolean inteligente;
    private int ultimoJugado;
    private int inferior;
    private int superior;

    public Jugador(int id ) {
        this.id = id;
        this.inteligente = false; // Por defecto, el jugador no es inteligente

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInteligente() {
        return inteligente;
    }

    public void setInteligente(boolean inteligente) {
        this.inteligente = inteligente;
    }


    public int getUltimoJugado() {
        return ultimoJugado;
    }

    public void setUltimoJugado(int ultimoJugado) {
        this.ultimoJugado = ultimoJugado;
    }

    public int getInferior() {
        return inferior;
    }

    public void setInferior(int inferior) {
        this.inferior = inferior;
    }

    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    //Método
    public static void intento(int numIntento, boolean auto){

    }
}
