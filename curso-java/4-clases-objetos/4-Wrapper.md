## 📌 Clases Wrapper (Envolventes)

Las **clases wrapper** (o clases envolventes) son clases especiales provistas por Java que **envuelven a los tipos de datos primitivos para transformarlos en objetos**. Esto permite que datos simples (como un entero o un booleano) adquieran el comportamiento de una clase, dándonos acceso a múltiples propiedades y métodos de utilidad.

---

### **1. ¿Por qué son necesarias las Clases Wrapper?**

Aunque trabajar con tipos primitivos (como `int` o `double`) es rápido y eficiente en memoria, estos carecen de métodos de procesamiento. Además, Java cuenta con estructuras de datos avanzadas como las **Colecciones** (por ejemplo, `ArrayList`) que trabajan con genéricos.

- **La Limitación de los Primitivos:** Las colecciones de Java **no aceptan tipos de datos primitivos**; requieren obligatoriamente objetos.
- **La Solución Wrapper:** Al envolver el tipo primitivo en un objeto wrapper (como transformar un `int` en un `Integer`), podemos utilizar estos datos básicos en cualquier contexto orientado a objetos o colecciones.

---

### **2. Tabla de Equivalencias Primitivo vs. Wrapper**

Por cada tipo de dato primitivo existe una clase wrapper equivalente en la biblioteca estándar de Java. Como regla general, se escriben de forma idéntica pero iniciando con **mayúscula** (PascalCase), a excepción de `int` y `char`:

| Tipo Primitivo | Clase Wrapper Equivalente | Tipo de Dato que Representa |
| --- | --- | --- |
| `byte` | `Byte` | Entero de 8 bits |
| `short` | `Short` | Entero de 16 bits |
| `int` | `Integer` | Entero de 32 bits |
| `long` | `Long` | Entero de 64 bits |
| `float` | `Float` | Decimal de precisión simple |
| `double` | `Double` | Decimal de precisión doble (estándar) |
| `char` | `Character` | Carácter Unicode individual |
| `boolean` | `Boolean` | Valor lógico (`true` / `false`) |

---

### **3. Conversiones Automáticas: Autoboxing y Unboxing**

Java realiza de forma implícita la transición entre primitivos y objetos wrapper para facilitarnos la escritura de código:

- **Autoboxing:** Es la conversión automática que realiza el compilador para transformar un tipo primitivo en su objeto wrapper correspondiente.
    
    ```java
    Integer number = 30; // Autoboxing directo
    // Internamente equivale a realizar:
    Integer numberEquivalent = Integer.valueOf(30); //
    ```
    
- **Unboxing:** Es el proceso inverso, donde Java extrae automáticamente el valor primitivo desde un objeto wrapper cuando se requiere para una operación básica.

---

### **4. Métodos de Utilidad por Familias (Repositorio de Clase)**

Cada clase wrapper ofrece una suite de métodos estáticos indispensables para el procesamiento de datos:

#### **A. Métodos de la Familia Numérica (`Integer`, `Long`, `Double`, etc.)**

- **`parseInt(String s)` / `parseDouble(String s)`:** Convierte (parsea) una cadena de texto a su tipo numérico primitivo equivalente.
    
    ```java
    int primitiveInt = Integer.parseInt("123"); // Devuelve el primitivo 123
    ```
    
- **`valueOf(String s)`:** Analiza la cadena de texto pero **retorna un objeto de la clase Wrapper** en lugar de un primitivo.
- **`toString(int i)`:** Realiza el proceso inverso; toma un número y lo convierte a una cadena de texto (`String`), muy útil para concatenaciones avanzadas.
- **`compare(num1, num2)`:** Compara dos valores numéricos.
    - Retorna **`0`** si son idénticos.
    - Retorna un **número negativo** si el primer valor es menor al segundo.
    - Retorna un **número positivo** si el primer valor es mayor al segundo.
- **`max(num1, num2)` / `min(num1, num2)`:** Retornan directamente el valor máximo o mínimo entre los dos argumentos ingresados.

#### **B. Métodos de la Clase `Character`**

La clase wrapper para caracteres cuenta con métodos específicos de validación de símbolos:

- **`isLetter(char ch)`:** Retorna `true` si el carácter es una letra del abecedario.
- **`isDigit(char ch)`:** Retorna `true` si el carácter es un dígito numérico (del `'0'` al `'9'`).
- **`isWhitespace(char ch)`:** Evalúa si el carácter representa un espacio vacío o en blanco.
- **`toLowerCase(char ch)` / `toUpperCase(char ch)`:** Transforma de forma segura el carácter a minúscula o mayúscula respectivamente.

#### **C. Métodos de la Clase `Boolean`**

- **`logicalAnd(bool1, num2)` / `logicalOr(bool1, bool2)`:** Métodos que evalúan operaciones lógicas de conjunción (AND) y disyunción (OR) utilizando métodos en lugar de los operadores tradicionales `&&` y `||`.
    
    ```java
    boolean resultAnd = Boolean.logicalAnd(true, false); // Retorna false
    boolean resultOr = Boolean.logicalOr(true, false);   // Retorna true
    ```
    

---

## 💻 EJEMPLO PRÁCTICO INTEGRADO (`WrapperDemo`)

Este código reúne la aplicación de los métodos más representativos explicados en el repositorio de tu curso:

```java
package wrapperExample;

public class WrapperDemo {
    public static void main(String[] args) {
        // 1. Uso de parse para convertir String a primitivo
        String textNumber = "500";
        int parsedInt = Integer.parseInt(textNumber);
        System.out.println("Primitivo parseado: " + parsedInt);

        // 2. Comparación de enteros mediante Wrapper
        int comparison = Integer.compare(15, 20); 
        System.out.println("Resultado comparación (15 vs 20): " + comparison); 
        // Retorna negativo

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
```

---