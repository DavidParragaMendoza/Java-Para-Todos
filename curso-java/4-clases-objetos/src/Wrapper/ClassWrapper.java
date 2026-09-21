package Wrapper;

public class ClassWrapper {
    public static void main(String[] args) {
        // 1. Uso de parse para convertir String a primitivo
        String textNumber = "500";
        int parsedInt = Integer.parseInt(textNumber);
        System.out.println("Primitivo parseado: " + parsedInt);

        // 2. Comparación de enteros mediante Wrapper
        int comparison = Integer.compare(15, 20); //mayor n1:1, n1==n2: 0, mayor n2: -1
        System.out.println("Resultado comparación (15 vs 20): " + comparison);


        // 3. Hallar extremos numéricos
        int highest = Integer.max(10, 25); //
        System.out.println("El número mayor es: " + highest);

        // 4. Validaciones de caracteres con Character
        char myChar = '9';
        boolean isDigit = Character.isDigit(myChar);
        System.out.println("¿El carácter '" + myChar + "' es un dígito?: " + isDigit);
        // true

        char letter = 'a';
        char upperLetter = Character.toUpperCase(letter);
        System.out.println("Carácter transformado: " + upperLetter); // 'A'
    }
}
