package Strings;

public class StringMethodsDemo {
    public static void main(String[] args) {
        // Variable base para la demostración
        String text = "Hola mundo, ";

        // 1. Longitud de la cadena
        int length = text.length(); // Devuelve la cantidad de caracteres
        System.out.println("Longitud del texto: " + length); // Imprime 12

        // 2. Carácter en una posición específica
        char character = text.charAt(2); // Posición 2 (0: H, 1: o, 2: l)
        System.out.println("Carácter en la posición 2: " + character); // Imprime 'l'

        // 3. Obtener una subcadena (Recortar)
        String subText = text.substring(0, 4); // Corta de 0 (inclusivo) a 4 (exclusivo)
        System.out.println("Subcadena recortada (0 a 4): " + subText); // Imprime "Hola"

        // 4. Transformar a mayúsculas y minúsculas
        System.out.println("Mayúsculas: " + text.toUpperCase());
        System.out.println("Minúsculas: " + text.toLowerCase());

        // 5. Comparación estricta y comparación relajada
        String text1 = "Hola";
        String text2 = "hola";

        System.out.println("¿Son iguales con equals()? " + text1.equals(text2)); // false
        System.out.println("¿Son iguales con equalsIgnoreCase()? " + text1.equalsIgnoreCase(text2)); // true

        // 6. Verificar contenido
        boolean containsWord = text.contains("mundo"); // Busca el término "mundo"
        System.out.println("¿Contiene la palabra 'mundo'?: " + containsWord); // true

        // 7. Reemplazar caracteres
        String replacedText = text.replace('o', 'a'); // Reemplaza 'o' por 'a'
        System.out.println("Texto modificado con replace: " + replacedText); // "Hala munda, "

        // 8. Quitar espacios iniciales y finales
        String textWithSpace = "    Hola con espacios    ";
        System.out.println("Texto limpio con trim(): '" + textWithSpace.trim() + "'"); // "Hola con espacios"

        // 9. Segmentación de cadena (split) y recorrido (for-each)
        String namesSeparatedByComma = "Gabriel,Matias,Juan";
        String[] parts = namesSeparatedByComma.split(","); // Corta donde encuentre una coma

        System.out.println("\n--- Recorriendo el arreglo resultante con un for-each ---");
        // El bucle lee cada elemento de 'parts' y lo almacena temporalmente en la variable 'part'
        for (String part : parts) {
            System.out.println("Elemento: " + part); // Muestra cada nombre de forma independiente
        }
    }
}
