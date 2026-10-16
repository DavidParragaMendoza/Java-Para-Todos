import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader= new BufferedReader(new FileReader("src/example.txt"));

            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");

        }catch (IOException e) {
            System.out.println("Error en la lectura del archivo.");;

        }finally {
            try {
                if (reader != null){
                    reader.close();
                    System.out.println("El archivo fue cerrado crrectamente");
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo");;
            }
        }
    }
}
