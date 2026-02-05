import javax.swing.*; //Importamos el JPOptions

public class ArraysII {
    public static void main(String[] args) {
        String [] paises= new String [9];
        for(int i=0; i<9; i++){
            paises[i]= JOptionPane.showInputDialog("Ingrese pais: "); //Para que salga los paises declarados en otra clase
        }
        for(String elemento:paises) System.out.println(elemento);
    }
}
