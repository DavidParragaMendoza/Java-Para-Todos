## 📌 Entrada por teclado - La clase `Scanner`

En esta clase se introduce una herramienta fundamental para dar dinamismo a las aplicaciones: la clase **`Scanner`**. Hasta el momento, todas las variables habían sido inicializadas manualmente en el código (lo que técnicamente se conoce como **hardcodear** el código). Con `Scanner`, el programa es capaz de recibir y procesar información en tiempo de ejecución directamente introducida por el usuario desde su teclado.

### **1. Teoría: Clases, Objetos y el Operador `new`**

- Java es un lenguaje enfocado en la **Programación Orientada a Objetos (POO)**.
- Así como `int` es un tipo de dato primitivo básico, la clase `Scanner` actúa como un **tipo de dato complejo** provisto por el sistema.
- Para poder usar las funciones de una clase, necesitamos crear una "instancia" o "copia" física de ella en la memoria (un objeto). Esto se logra utilizando de forma mandatoria la palabra reservada **`new`**.
- **Parámetro `System.in`:** Al instanciar el objeto, se le debe pasar `System.in` entre sus paréntesis para indicarle que debe capturar la entrada estándar del sistema (el teclado físico de la computadora).

```java
Scanner sc = new Scanner(System.in); // Instancia de la clase Scanner
```

---

### **2. Métodos de Lectura del Teclado**

Dependiendo del tipo de variable que deseemos capturar, la clase `Scanner` ofrece diferentes métodos especializados:

- **`nextInt()`:** Detiene el flujo del programa para capturar y devolver un número **entero** (`int`).
- **`nextDouble()`:** Captura un número de punto decimal con precisión doble.
- **`nextLine()`:** Captura una línea completa de texto o **cadenas de caracteres** (`String`).

---

### **3. Importancia del Manejo de la Interfaz del Usuario (UX)**

- **El problema de la pantalla vacía:** Si llamas directamente al scanner sin un mensaje previo, la consola de IntelliJ se quedará vacía esperando la entrada sin avisarle nada al usuario, lo que puede parecer un error de congelamiento del sistema.
- **Buena Práctica:** Siempre se debe imprimir un mensaje descriptivo en consola (un "prompt") utilizando `System.out.println` **antes** de invocar cualquier lectura del teclado para guiar al usuario sobre qué dato debe ingresar.

**Ejemplo de código básico visto en clase:**

```java
package scannerExample;

import java.util.Scanner; // Importación de la biblioteca estándar

public class NumberComparer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Instanciación

        // Mensaje de guía para el usuario
        System.out.println("INGRESE EL PRIMER NÚMERO:");
        int a = sc.nextInt(); // Captura de la primera variable

        System.out.println("INGRESE EL SEGUNDO NÚMERO:");
        int b = sc.nextInt(); // Captura de la segunda variable

        // Operaciones aritméticas integradas en la impresión
        System.out.println("La suma de a + b es igual a: " + (a + b));
        System.out.println("La diferencia de a - b es: " + (a - b));

        // Estructura condicional para evaluar los datos ingresados
        if (a > b) {
            System.out.println("El primer número es mayor.");
        } else {
            System.out.println("El segundo número es mayor o igual.");
        }
    }
}
```

---

## 📌 CLASE #31: Refactorizando el Ejemplo de `Scanner`

La **refactorización** es un proceso que consiste en reestructurar y mejorar el código que ya hemos escrito para alinearlo con las buenas prácticas de la industria (**Clean Code**), haciéndolo más limpio, ordenado y mantenible, **sin alterar en absoluto su funcionamiento externo**.

En esta clase se aplican cambios clave al ejercicio anterior para elevar la calidad del diseño de nuestro software:

### **1. Renombrar variables por Identificadores Descriptivos**

- El nombre de objeto **`sc`** y las variables **`a`** y **`b`** son demasiado genéricos y no revelan el propósito real de los datos en el sistema.
- **Refactorización:**
    - Se cambia `sc` por **`scanner`** (es mucho más legible y profesional).
    - Se cambian `a` y `b` por **`firstNumber`** y **`secondNumber`**.

---

### **2. Desacoplamiento de Operaciones y Salidas**

- En el ejercicio de la clase anterior, la suma (`a + b`) y la resta (`a - b`) se calculaban directamente dentro de la sentencia `System.out.println()`. Esto es una mala práctica de acoplamiento porque el cálculo matemático depende directamente del método de impresión.
- **Refactorización (Principio de Responsabilidad Única):** Se deben almacenar las operaciones aritméticas en variables independientes dedicadas (`sum` y `difference`) antes de imprimirlas. Así, el método `print` se dedica única y exclusivamente a mostrar la información procesada.

---

### **3. Liberación de Recursos de Memoria (`close`)**

- Cuando abres un canal de comunicación de entrada y salida con el sistema operativo (como leer el teclado usando `Scanner`), este consume recursos físicos de memoria.
- **Buena Práctica Obligatoria:** Al terminar de utilizar el scanner y justo antes de que finalice la ejecución de la aplicación, es sumamente importante cerrarlo de forma explícita utilizando el método **`close()`** para evitar fugas de memoria (*memory leaks*).

**Código Refactorizado aplicando Clean Code:**

```java
package scannerExample;

import java.util.Scanner;

public class NumberComparer {
    public static void main(String[] args) {
        // Uso de un identificador descriptivo para el objeto
        Scanner scanner = new Scanner(System.in);

        System.out.println("INGRESE EL PRIMER NÚMERO:");
        int firstNumber = scanner.nextInt(); // Variable con significado

        System.out.println("INGRESE EL SEGUNDO NÚMERO:");
        int secondNumber = scanner.nextInt(); // Variable con significado

        // Desacoplamiento: Los cálculos se almacenan en variables dedicadas
        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;

        // Las salidas solo se encargan de imprimir el resultado preprocesado
        System.out.println("La suma es: " + sum);
        System.out.println("La diferencia es: " + difference);

        if (firstNumber > secondNumber) {
            System.out.println("El primer número es mayor.");
        } else {
            System.out.println("El segundo número es mayor o igual.");
        }

        System.out.println("Fin de la aplicación."); // Mensaje de cierre

        // ⚠️ Liberación obligatoria de recursos del sistema en memoria
        scanner.close();
    }
}
```