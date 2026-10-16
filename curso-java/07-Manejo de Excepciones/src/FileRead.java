import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    static void main(String[] args) {
        try {
            FileReader file = new FileReader("src/example.txt");
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();
            while (line !=null){
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        }catch (IOException e) {
            System.out.println("Error en la lectura del archivo.");;
        }
    }
}
