public class ejemploArrayBide {
    public  static void main(String[] args) {
        double acumulado; //Capitasl que se acumula año a año
        double interes= 0.10; //Incrementa 1% el interés
        //columnas y filas
        double [][] saldo = new double[6][5];
        //Todo comienza por 10.000 euros, es decir, valores fijes, el resto hay que calcularlos
        for(int i=0;i<6;i++){
           saldo[i][0]=10000;
           acumulado=10000;
            for(int j= 1;j<5;j++){
                acumulado=acumulado+acumulado*interes;
                saldo[i][j]=acumulado;
            }
            interes=interes+0.01;
        }
        for(int z=0;z<6;z++){
            System.out.println();
            for(int h=0;h<5;h++){
                System.out.printf("%1.2f", saldo[z][h]);
                System.out.println(" ");
            }
        }
    }
}
