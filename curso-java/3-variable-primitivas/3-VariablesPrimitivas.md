## 📌 Variables Primitivas (Práctica en el IDE)

En esta clase se pasa de la teoría a la práctica dentro de **IntelliJ IDEA**, creando un nuevo proyecto para aprender a declarar, inicializar, modificar y mostrar variables primitivas por consola.

### **1. Configuración del Proyecto Práctico**

- Se crea un nuevo proyecto de tipo IntelliJ llamado **`variables-primitivas`** (dentro de una carpeta organizativa de tu curso).
- Se limpia la plantilla inicial borrando el código de ejemplo de "Hello World" dentro del método `main` para escribir desde cero.

---

### **2. Tipos de Datos Enteros y Eficacia**

- **El tipo `byte`:** Es el tipo de entero más corto en Java, con un rango que va de -**128 a 127**.
- **Criterio de Eficacia:** Un caso de uso ideal para el `byte` es almacenar la edad de una persona. Como nadie vive más de 127 años, elegir `byte` en lugar de `int` optimiza el uso de la memoria de nuestro programa, un aspecto crítico a evaluar cuando el sistema escala.
    
    ```java
    byte age = 23; 
    // Declaración, inicialización y fin de sentencia con ';'
    ```
    

---

### **3. Literales Decimales y Precisión (`float` vs `double`)**

- En Java, **todos los números con punto decimal son interpretados por defecto como tipo `double`** (precisión de 64 bits).
- Si declaras una variable de tipo `float` (precisión de 32 bits) y le asignas un número decimal directamente, el compilador arrojará un error de compilación porque estás intentando meter un valor de mayor precisión en una variable de menor capacidad.
- **Solución:** Debes agregar de forma obligatoria el sufijo **`f`** o **`F`** al final del número decimal para indicarle explícitamente a Java que lo trate como un `float`.
    
    ```java
    float price = 19.99f; 
    // El sufijo 'f' evita el error de compilación
    ```
    

---

### **4. Declaración Múltiple e Inicialización Diferida**

Java permite declarar más de una variable del mismo tipo en una sola línea separándolas por comas, e inicializarlas con un valor en líneas posteriores antes de ser utilizadas:

```java
int xAxis, yAxis; // Declaración múltiple en una misma línea

xAxis = 10;       // Inicialización diferida
yAxis = 20;
```

- Para imprimir el valor de estas variables en consola de forma rápida en IntelliJ, puedes utilizar el atajo **`soutv`**, que genera automáticamente una instrucción `System.out.println` formateada con el nombre y valor de la variable.

---

### **5. Mutabilidad de las Variables**

Las variables representan direcciones de memoria cuyos valores **pueden variar a lo largo del tiempo**.

- Si se imprime una variable, se modifica su valor y se vuelve a imprimir, la consola reflejará el cambio secuencialmente:
    
    ```java
    byte age = 23;
    System.out.println(age); // Imprime 23
    
    age = 30; // Se modifica el valor en la misma posición de memoria
    System.out.println(age); // Imprime 30
    ```
    

---

### **6. Particularidades de los tipos `boolean` y `char`**

- **El tipo `boolean`:** Aunque nosotros le asignamos las palabras reservadas `true` o `false` por comodidad en el código, a nivel físico e interno la máquina virtual de Java almacena un **1 para `true`** y un **0 para `false`**.
- **El tipo `char`:** Almacena un único carácter (como `'G'` o un símbolo como de pesos `'$'`) delimitado obligatoriamente por **comillas simples**.
    - Si almacenas un número como carácter (ej. `char numero = '1';`), se guarda únicamente su representación visual y **no podrás realizar operaciones matemáticas** con él.
    - Intentar guardar una palabra o cadena de texto (como `"Gabriel"`) en un `char` provocará un error de compilación, ya que las cadenas requieren comillas dobles y pertenecen al tipo de datos de referencia (objetos) que se estudian más adelante.

> 💡 **Idea Clave para recordar:** Los tipos de datos primitivos en Java son la estructura más básica porque **solo pueden almacenar un único dato o valor a la vez** en su espacio de memoria asignado.
> 

---

## 📌 Constantes y Buenas Prácticas (Clean Code)

Esta clase se enfoca en cómo asegurar que ciertos valores permanezcan inalterables y cómo escribir código limpio, profesional y comprensible para cualquier desarrollador.

### **1. Creación de la Estructura en IntelliJ**

- Se recomienda crear un paquete separado llamado **`constantes`** dentro de tu proyecto de práctica para organizar el código.
- Dentro de este paquete, se crea una nueva clase pública llamada **`PracticaConstante`** con su respectivo método `main` como punto de entrada de ejecución.

---

### **2. ¿Qué es una Constante en la Práctica?**

Es una dirección de memoria asociada a un tipo de dato cuyo valor **no puede ser reasignado o modificado** una vez establecido.

- **La palabra clave `final`:** Para declarar una constante en Java, se antepone el modificador **`final`** al tipo de dato.
- **Error de compilación:** Si intentas cambiar el valor de una constante declarada con `final`, el compilador detendrá el proceso y mostrará un mensaje indicando que no se puede reasignar un valor a una variable final.
    
    ```java
    final double ANNUAL_INTEREST_RATE = 0.05; // Constante declarada
    
    ANNUAL_INTEREST_RATE = 0.10; 
    // ❌ ERROR DE COMPILACIÓN: No se puede reasignar
    ```
    

---

### **3. Buenas Prácticas de Escritura (Clean Code)**

Escribir código legible es vital para que otros desarrolladores (o tú mismo en el futuro) entiendan el flujo del programa sin necesidad de comentarios excesivos.

- **Nombres Significativos:** Evita por completo usar letras únicas (como `x`, `y`, `z`) para nombrar tus variables cotidianas. Es preferible usar nombres descriptivos que revelen inmediatamente qué se está guardando (por ejemplo, usar `workDays` en lugar de `wd` o `x`).
- **Uso de CamelCase (para Variables):** Si el nombre de una variable está compuesto por más de una palabra, la primera palabra se escribe completamente en minúsculas y las palabras subsecuentes inician con letra **Mayúscula**.
    - *Ejemplos:* `grossSalary`, `netSalary`, `workDays`.
- **Uso de UPPER_CASE (para Constantes):** Las constantes se escriben completamente en **mayúsculas**. Si el nombre contiene palabras compuestas, estas se deben separar obligatoriamente con un **guion bajo (`_`)**.
    - *Ejemplos:* `TAX_RATE`, `ANNUAL_INTEREST_RATE`.

---

### **4. Caso de Estudio Práctico: Cálculo de Salario**

Un ejemplo de código limpio que aplica todos estos conceptos para calcular el salario neto de un empleado tras aplicarle un descuento de impuestos:

```java
package constantes;

public class PracticaConstante {
    public static void main(String[] args) {
        // Constante en UPPER_CASE con modificador final
        final double TAX_RATE = 0.10; // Descuento del 10% de impuestos

        // Variables escritas con camelCase y nombres significativos
        double grossSalary = 3000.0; // Salario bruto inicial

        // Operación matemática combinando variable y constante
        double netSalary = grossSalary - (grossSalary * TAX_RATE);

        // Mostrar resultado final
        System.out.println("Salario Neto: " + netSalary); // Imprime 2700.0
    }
}
```

- **La Ventaja de este Enfoque:** Al leer este bloque de código, cualquier persona que comprenda las bases de la administración o las finanzas sabrá exactamente qué hace el programa sin necesidad de explicaciones adicionales, gracias a la claridad y el significado de los identificadores elegidos.

---