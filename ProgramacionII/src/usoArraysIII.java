import org.w3c.dom.ls.LSOutput;

public class usoArraysIII {
   public static void main(String[] args) {
       /* int[][] matrix= new int[4][5];
        matrix[0][0]=15;
        matrix[0][1]=25;
        matrix[0][2]=20;
        matrix[0][3]=90;
        matrix[0][4]=30;

        matrix[1][0]=25;
        matrix[1][1]=23;
        matrix[1][2]=60;
        matrix[1][3]=30;
        matrix[1][4]=99;

        matrix[2][0]=15;
        matrix[2][1]=65;
        matrix[2][2]=29;
        matrix[2][3]=40;
        matrix[2][4]=33;

        matrix[3][0]=65;
        matrix[3][1]=22;
        matrix[3][2]=23;
        matrix[3][3]=24;
        matrix[3][4]=25;

        //Para recorrer todos los contenidos
        //Bucle padre
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }*/
       //Otra manera de hacer array bidi
       int [][] matriz ={
               {10,15,18,19,21},
               {20,15,18,19,21},
               {10,25,18,19,21},
               {10,15,8,9,21}

       };
       //for each
       for (int [] fila:matriz) {
           System.out.println();
           //for each anidado

           for(int z: fila){
               System.out.print(z + " ");
           }
       }
    }

}
