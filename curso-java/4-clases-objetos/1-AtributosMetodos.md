## 📌 Atributos y Métodos de Clase

En esta clase práctica se pasa del concepto abstracto de "molde" a la implementación de código en Java, detallando **cómo definir y utilizar las propiedades (atributos) y comportamientos (métodos)** dentro de una clase, así como la instanciación de objetos reales.

---

### **1. Definiendo los Atributos**

Los atributos representan los datos o características de una clase. En el ejemplo práctico de la clase **`House`** (nuestro molde), se definen de manera directa tres atributos esenciales:

- **`doors`**: Cantidad de puertas (entero).
- **`windows`**: Cantidad de ventanas (entero).
- **`size`**: Longitud de uno de los lados de la casa (decimal de doble precisión, `double`).

---

### **2. Implementando los Métodos (Comportamientos)**

Un método es un **algoritmo que realiza una tarea específica** para resolver un problema particular en tu sistema. En la clase `House` se diseñan dos tipos de métodos para comprender sus diferencias estructurales:

#### **A. Métodos sin Retorno (`void`)**

- Se declaran obligatoriamente usando la palabra clave **`void`**.
- Se utilizan para ejecutar acciones inmediatas (como imprimir un mensaje en consola) y **no devuelven ningún dato** al bloque de código que los llamó.
- **Ejemplo (`openDoor`)**: Muestra por consola el texto: `"La puerta está abierta"`.

#### **B. Métodos con Retorno (`return`)**

- No utilizan `void`; en su lugar, **deben especificar con precisión el tipo de dato que van a devolver** (por ejemplo, `double`).
- Es obligatorio utilizar la palabra clave **`return`** para devolver el valor calculado.
- La sentencia `return` debe estar ubicada en la raíz del método y ser estrictamente **lo último que se ejecute** en el flujo de dicho comportamiento.
- **Ejemplo (`calculateArea`)**: Multiplica el atributo `size` por sí mismo (`size * size`) y **retorna** un valor de tipo `double` con el cálculo matemático resultante.

---

### **3. Creación de Objetos (La palabra clave `new`)**

Para poner en marcha el código, se crea una clase ejecutora independiente llamada **`HouseMain`** que contiene el método de entrada `main`.

- Para crear una instancia u objeto físico en la memoria a partir del molde, debemos invocar a su **constructor** utilizando el operador reservado **`new`**.
- El constructor por defecto comparte de forma idéntica el nombre de la clase y, si no lo hemos declarado explícitamente en el molde, Java asume uno vacío (sin parámetros).

```java
// Sintaxis de instanciación:
House myHouse = new House(); // Llama al constructor vacío para reservar memoria
```

---

### **4. Asignación de Atributos y Múltiples Instancias**

- **Operador Punto (`.`):** Nos permite acceder directamente a los atributos o métodos del objeto para asignarles un valor específico.
    
    ```java
    myHouse.doors = 2;
    myHouse.windows = 4;
    myHouse.size = 10;
    ```
    
- **Independencia de Estado:** Como una clase es solo una plantilla, podemos crear múltiples casas independientes del mismo molde. Un segundo objeto **`myHouse2`** puede tener valores completamente diferentes sin alterar la primera casa:
    
    ```java
    House myHouse2 = new House();
    myHouse2.doors = 4;
    myHouse2.windows = 6;
    myHouse2.size = 20;
    ```
    

---

### **5. Invocación de Métodos**

La forma de llamar a los métodos varía drásticamente según su tipo de retorno:

1. **Llamar a un método `void`**: Simplemente se invoca con el punto. No requiere asignarse a ninguna variable porque no entrega ningún resultado de salida.
    
    ```java
    myHouse2.openDoor(); // Imprime directamente el mensaje en consola
    ```
    
2. **Llamar a un método con retorno**: Como el método entrega un cálculo, **es indispensable almacenar su resultado en una variable del mismo tipo de dato** utilizando el operador de asignación antes de poder utilizarlo.
    
    ```java
    double area = myHouse2.calculateArea(); // Guarda el resultado del return en la variable 'area'
    System.out.println("El área de la casa es: " + area); // Imprime el valor calculado
    ```
    

---

## 💻 CÓDIGO FUENTE COMPLETO DE LA CLASE

### **Archivo 1: `House.java` (El Molde)**

```java
package HouseExample;

public class House {
    // 1. Atributos de la clase (Molde)
    int doors;
    int windows;
    double size;

    // 2. Método sin retorno (void)
    public void openDoor() {
        System.out.println("La puerta está abierta.");
    }

    // 3. Método con retorno (double)
    public double calculateArea() {
        return size * size; // Retorno obligatorio del cálculo
    }
}
```

### **Archivo 2: `HouseMain.java` (Punto de Ejecución)**

```java
package HouseExample;

public class HouseMain {
    public static void main(String[] args) {
        // Creación e inicialización del primer objeto
        House myHouse = new House();
        myHouse.doors = 2;
        myHouse.windows = 4;
        myHouse.size = 10;

        // Creación de un segundo objeto independiente
        House myHouse2 = new House();
        myHouse2.doors = 4;
        myHouse2.windows = 6;
        myHouse2.size = 20;

        // Impresión de atributos de la segunda instancia
        System.out.println("La cantidad de puertas de la casa es: " + myHouse2.doors);

        // Invocación de método sin retorno
        myHouse2.openDoor();

        // Invocación y captura del método con retorno
        double area = myHouse2.calculateArea();
        System.out.println("El área de la casa es: " + area);
    }
}
```