public class Camion {
    //Constantes RECUERDA EL FINAL,  estácticas, y nombre SIEMPRE en mayúscula
    public static final double PESO_UN_EJE = 4.5;
    public static final double PESO_DOS_EJES = 18;
    public static final double PESO_TRES_EJES = 25;
    public static final double PESO_CINCO_EJES = 40;


    private static int ultimoID = 0;
    public static double kmsRecorridosTotales = 0; //Kms recorridos totales
    private int id;
    private String matricula;
    private Marca marca;
    private double peso;
    private double kmsActuales;
    private double consumo;
    private double capacidadMax;
    private double combustibleActual;

    //Constructores PRIMERO
    //Al ser nuevo los kmsActuales 0
    public Camion(String matricula) {
        this.matricula = matricula;
        this.marca = Marca.NISSAN;
        this.kmsActuales = 0; //ES NUEVO
        //peso=eje
        this.peso = PESO_DOS_EJES;
        this.consumo = 20;
        this.capacidadMax = 200; //Combustible
        this.combustibleActual = 200;
        asignarID();
    }

    //Indicando la matrícula, la capacidad máxima del depósito y el
//combustible actual.
    public Camion(String matricula, double capacidadMax, double combustibleActual) {
        this.matricula = matricula;
        this.marca = Marca.NISSAN;
        this.kmsActuales = 0;
        this.peso = PESO_DOS_EJES;
        this.consumo = 20;
        this.capacidadMax = capacidadMax;
        this.combustibleActual = combustibleActual;

        if (combustibleActual > capacidadMax) {
            this.combustibleActual = capacidadMax;
        }
        asignarID();
    }

    //Indicando la matrícula, la capacidad máxima del depósito, el
//combustible actual y el peso
    public Camion(String matricula, double capacidadMax, double combustibleActual, double peso) {
        this.matricula = matricula;
        this.marca = Marca.NISSAN;
        this.kmsActuales = 0;
        this.peso = peso;
        this.consumo = 20;
        this.capacidadMax = capacidadMax;
        this.combustibleActual = combustibleActual;

        if (combustibleActual > capacidadMax) {
            this.combustibleActual = capacidadMax;
        }
        asignarID();
    }

    //Método ID único, no recibe parámetros porque es una asignasción automática
    private void asignarID() {
        ultimoID++;
        this.id = ultimoID;
    }

    //Repostar combustible
    public double repostarCombustible(double cantidad, double precioLitroGasolina) {
        //Verificar se no se excede capacidadMax
        if (combustibleActual + cantidad > capacidadMax) {
            System.out.println("La cantidad indicada supera la capacidad del depósito");
            double precio= (capacidadMax - combustibleActual) * precioLitroGasolina;
            combustibleActual = capacidadMax;
            //Solo cobrar por la diferencia que ha repostado
            return precio;
        }
        combustibleActual += cantidad;
        return cantidad * precioLitroGasolina;
    }

    //Calcular kilómetros disponibles
    public double calcularKmDisponible() {
        //Kms según consumo
        double kms = (combustibleActual / consumo) * 100;
        //Penalización por peso
        //Si es de dos ejes podrá recorrer 50 kms menos
        if (peso == PESO_DOS_EJES) {
            kms -= 50;
        } else
            //Si es de tres ejes podrá recorrer 75 kms menos
            if (peso == PESO_TRES_EJES) {
                kms -= 75;
            }
            //Si es de cinco ejes podrá recorrer 100 kms menos
            else if (peso == PESO_CINCO_EJES) {
                kms -= 100;
            }
        //En ningún caso los kms pueden quedarse con valor negativo
        if (kms < 0) {
            kms = 0;
        }

        return kms;
    }

    // Realizar viajes, es decir, kilómetros que quiere recorrer
    public void realizarViaje(double kmsRecorrer) {

        double kmsDisponibles = calcularKmDisponible();

        // Comprobamos si hay combustible suficiente
        if (kmsRecorrer > kmsDisponibles) {
            System.out.println("ERROR. No tienes gasolina suficiente");
            return;
        }

        // Combustible consumido (consumo es cada 100 km)
        double combustibleGastado = (kmsRecorrer / 100) * consumo;

        // Actualizamos datos del camión
        combustibleActual -= combustibleGastado;
        kmsActuales += kmsRecorrer;

        // Actualizamos el total de la empresa
        kmsRecorridosTotales += kmsRecorrer;

        System.out.println("Viaje realizado con éxito");

        // Aviso de reserva
        if (calcularKmDisponible() < 100) {
            System.out.println("DEPÓSITO EN RESERVA. Por favor, reposte lo antes posible");
        }
    }

    //Getter y setters
    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getKmsActuales() {
        return kmsActuales;
    }

    public void setKmsActuales(double kmsActuales) {
        this.kmsActuales = kmsActuales;
    }

    //Camión más antiguo y más nuevo
    public static Camion masAntiguo(Camion c1, Camion c2) {
        if (c1.kmsActuales >= c2.kmsActuales) {
            return c1;
        } else {
            return c2;
        }
    }
     @Override
    public String toString() {
        return "Camion "+ id + " --> Peso: " + peso + ", Kms actuales: " + kmsActuales + ", Consumo: " + consumo + ", Capacidad máxima: " + capacidadMax
        + ", Combustible actual: " + combustibleActual + ", Kms disponibles: " + calcularKmDisponible();
     }
}
