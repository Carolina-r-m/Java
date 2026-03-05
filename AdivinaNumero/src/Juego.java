import java.util.Random;

public class Juego {
 private int numero;
 private int numeroMax;
 private int turno;
 private int ganador;
 private int numeroJugadores;

    public Juego(int numeroMax, int numeroJugadores){
        this.numeroMax = numeroMax;
        this.numeroJugadores = numeroJugadores;

        //Número aleatorio entre 1 y numeroMax
        Random rd = new Random();
        numero= rd.nextInt(1, numeroMax); // Genera un número aleatorio entre 1 y numeroMax (inclusive)
        ganador =-1; // Inicializamos el ganador con un valor que no corresponde a ningún jugador (por ejemplo, -1)

        //Se elige el turno del jugador de manera aleatoria

        turno=rd.nextInt(0, numeroJugadores); // Genera un número aleatorio entre 0 y numeroJugadores-1 para determinar el turno del jugador (asumiendo que los jugadores están numerados desde 0)

    }
    public Juego(){

    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumeroMax(int numeroMax) {
        this.numeroMax = numeroMax;
    }

    public void setTurno(int turno) {
        turno = turno;
    }

    public int getTurno() {
        return turno;
    }

    public void setGanador(int ganador) {
        ganador = ganador;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    //Método para realizar una jugada
    public String jugada(int numeroElegido){
        if(numeroElegido==numero){ // Si el número elegido es igual al número a adivinar, se devuelve "Igual"
            ganador=turno;
            return "Igual";
        }
        if(numeroElegido>numero){ // Si el número elegido es mayor que el número a adivinar, se devuelve "Mayor"
            turno=(turno+1)%numeroJugadores; // Se pasa el turno al siguiente jugador (asumiendo que los jugadores están numerados desde 0)
            return "Mayor";

    }
        turno=(turno+1)%numeroJugadores;
        return "Menor";
    }
}