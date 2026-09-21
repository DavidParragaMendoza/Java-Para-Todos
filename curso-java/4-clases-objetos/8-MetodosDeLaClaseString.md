## 📌 Métodos de la clase String

Al ser **`String`** una clase y no un tipo primitivo básico, nos provee de una inmensa e indispensable "caja de herramientas" llena de métodos y comportamientos prediseñados para realizar consultas, búsquedas, transformaciones y segmentaciones de texto.

A continuación, se agrupan y explican de forma detallada los métodos más importantes y utilizados en Java de acuerdo con su propósito lógico:

---

### **1. Medición y Posicionamiento**

- **`length()` (Longitud):**
    - **Definición:** Devuelve la cantidad total de caracteres por los que está compuesto el `String`.
    - **Detalle:** Al contar, Java toma en consideración las letras, los números, los signos de puntuación, las comas y los espacios vacíos. Por ejemplo, para el texto `"Hola mundo,"`, el método devuelve un valor de **12**.
- **`charAt(int index)` (Carácter en posición):**
    - **Definición:** Devuelve el carácter individual (`char`) ubicado en una posición o índice específico dentro de la cadena.
    - **El concepto de Índice:** Al igual que en los arreglos de datos, las posiciones de memoria en un String inician de forma obligatoria en la **posición `0`**. En el texto `"Hola mundo,"`, la letra `'H'` está en la posición `0`, la `'o'` en la `1`, y la `'l'` en la `2`. Por lo tanto, invocar `.charAt(2)` devolverá el carácter `'l'`.

---

### **2. Transformación y Extracción**

- **`substring(int beginIndex, int endIndex)` (Recortar cadena):**
    - **Definición:** Extrae y devuelve un trozo o segmento específico de la cadena de texto original.
    - **Parámetros:** Recibe dos parámetros de tipo entero: la posición de inicio o corte inicial (**`beginIndex`**, inclusivo) y la posición final de corte (**`endIndex`**, exclusivo). Por ejemplo, en `"Hola mundo,"`, cortar desde la posición `0` hasta la `4` nos devolverá exactamente el texto `"Hola"`.
- **`toUpperCase()` y `toLowerCase()` (Mayúsculas y Minúsculas):**
    - **Definición:** Transforman de forma segura toda la cadena de caracteres a letras mayúsculas o minúsculas respectivamente.
    - **Inmutabilidad:** Recuerda que estos métodos no alteran el String original, sino que retornan una nueva dirección de memoria con el texto resultante.
- **`replace(char oldChar, char newChar)` (Reemplazar caracteres):**
    - **Definición:** Busca todas las ocurrencias de un carácter específico dentro del texto y las sustituye por un carácter nuevo.
    - *Ejemplo:* Si en la cadena `"Hola mundo"` reemplazamos todas las letras `'o'` por letras `'a'`, el resultado será `"hala munda"`.
- **`trim()` (Eliminar espacios vacíos):**
    - **Definición:** Se utiliza para limpiar un texto eliminando de forma automática todos los espacios en blanco innecesarios situados **únicamente al inicio y al final** de la cadena. Es sumamente útil para estandarizar entradas de datos de usuarios antes de guardarlas en el sistema.

---

### **3. Comparación y Búsqueda**

- **`equals(Object anObject)` (Comparar contenido):**
    - **Definición:** Compara de manera estricta el contenido visual de dos cadenas de texto y devuelve un booleano (`true` o `false`).
    - **Sensibilidad:** Es estrictamente sensible a mayúsculas y minúsculas (*case-sensitive*). Comparar `"Hola"` con `"hola"` usando este método devolverá **`false`** porque para Java la `'H'` y la `'h'` son caracteres totalmente distintos.
- **`equalsIgnoreCase(String anotherString)` (Comparar ignorando mayúsculas):**
    - **Definición:** Realiza la misma comparación de contenido que el método anterior, pero con la diferencia de que **ignora por completo si los caracteres están escritos en mayúsculas o minúsculas**. En este caso, comparar `"Hola"` con `"hola"` devolverá **`true`**.
- **`contains(CharSequence s)` (Evaluar si contiene):**
    - **Definición:** Verifica si el String contiene en alguna de sus partes una subcadena de texto específica pasada por parámetro. Por ejemplo, si preguntamos si `"Hola mundo"` contiene la palabra `"mundo"`, el método devolverá **`true`**.

---

### **4. Segmentación y el Bucle `for-each`**

- **`split(String regex)` (Troceado de cadenas):**
    - **Definición:** Permite "cortar" o dividir una cadena de texto en múltiples partes basándose en un patrón o carácter delimitador (como una coma `,`, un punto o un espacio en blanco).
    - **Retorno complejo:** A diferencia de los demás métodos, `split()` no devuelve un String común; **retorna un arreglo de cadenas de caracteres (`String[]`)** con cada uno de los fragmentos resultantes guardados en una posición independiente.
- **El Bucle `for-each`:**
    - Al recibir un arreglo con múltiples fragmentos, se utiliza de manera recomendada el bucle **`for-each`** para recorrerlo de forma limpia y simplificada en lugar del `for` tradicional.
    - **Sintaxis:** No requiere variables de control, condiciones de corte ni incrementos manuales. En cada vuelta del ciclo, Java lee secuencialmente una posición del arreglo y se la asigna automáticamente a una variable local temporal hasta quedarse sin posiciones en el arreglo.

---

## 💻 CÓDIGO FUENTE DE PRÁCTICA (`StringMethodsDemo`)

Crea este archivo ejecutable en tu IDE para ver el comportamiento y salida en consola de toda esta caja de herramientas:

```java
package stringExample;

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
```

---