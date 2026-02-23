import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManejoFicheros {

        public static HashMap<String, List<Producto>> leerFicheros(String fileName) throws Exception {
            HashMap<String, List<Producto>> mapaProductos = new HashMap<>();
            FileReader fr = null;
            BufferedReader br = null;

            try {
                fr = new FileReader(fileName);
                br = new BufferedReader(fr);
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] lineaSplit = linea.split(";");
                    Producto p = new Producto(
                            Integer.valueOf(lineaSplit[0]),
                            lineaSplit[1],
                            Double.valueOf(lineaSplit[2]),
                            Integer.valueOf(lineaSplit[3]),
                            lineaSplit[4]
                    );

                    mapaProductos.computeIfAbsent(p.getCategoria(), k -> new ArrayList<>()).add(p);
                }
                br.close();
                fr.close();

            } catch (FileNotFoundException e) {
                if (br != null) br.close();
                if (fr != null) fr.close();
                throw new Exception("Fichero no encontrado");
            } catch (IOException e) {
                if (br != null) br.close();
                if (fr != null) fr.close();
                throw new Exception("Error durante la lectura del fichero");
            }

            return mapaProductos;
        }

        public static void escribirFichero(ArrayList<String> datos, String fileName) throws Exception {
            FileWriter fw = null;
            BufferedWriter bw = null;

            try {
                fw = new FileWriter(fileName);
                bw = new BufferedWriter(fw);

                for (String linea : datos) {
                    bw.write(linea);
                    bw.newLine();
                }
                bw.close();
                fw.close();

            } catch (IOException e) {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
                throw new Exception("Error durante la escritura del fichero");
            }
        }
    }