package Strings;

public class StringDemo {

    static void main(String[] args) {

        // 1. Demostración de Inmutabilidad
        String name = "Gabriel";
        name.toUpperCase();
        System.out.println("1. Inmutabilidad (original intacto): " + name); // Imprime "Gabriel"

        // 2. Comportamiento del String Pool (Literales iguales)
        String name1 = "Gabriel";
        String name2 = "Gabriel"; // Reutiliza la dirección del Pool
        System.out.println("2. Comparación de literales Pool (==): " + (name1 == name2)); // Imprime true

        // 3. Forzando objeto fuera del Pool con 'new'
        String name3 = new String("Gabriel");
        System.out.println("3. Comparación Pool vs New (==): " + (name1 == name3)); // Imprime false

    }
}
