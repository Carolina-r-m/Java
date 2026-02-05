public class ArrayIII {
    public static void main(String[] args) {
        //Almacenar en una array 200 números aleatorios y mostralo por consola
 int [] arraysAleatorios = new int [200];
 for(int i =0; i<arraysAleatorios.length; i++){

     //Hacer casting y que salga número aleatorio entre 0 y 200
     arraysAleatorios[i]=(int)(Math.random()*100);
 }
 for(int elementos:arraysAleatorios) System.out.print(elementos+ " "); //En vez de líneas, saldrá en filas
    }
}
