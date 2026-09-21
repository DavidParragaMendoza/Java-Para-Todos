## 📌 Constructores de Clase

En esta clase se analiza a fondo el concepto de **Constructor**, detallando para qué sirve, cuáles son sus reglas sintácticas dentro de Java y cómo optimiza la inicialización de nuestros objetos.

---

### **1. ¿Qué es un Constructor?**

- **Definición:** Un constructor es un **método especial** cuyo propósito principal es **inicializar los atributos del objeto** y establecer su estado inicial válido al momento de reservarse espacio en memoria.
- **Particularidad Sintáctica Única:** A diferencia de los métodos convencionales que hemos diseñado, **los constructores no tienen ningún tipo de retorno**, es decir, no devuelven ningún tipo de dato ni tampoco llevan la palabra clave `void`. Además, su nombre debe coincidir de forma **idéntica** con el nombre de la clase.

---

### **2. El Constructor Vacío (Por Defecto)**

- **Existencia implícita:** Siempre que creas una clase en Java, el compilador genera automáticamente un **constructor vacío** (sin parámetros) por defecto.
- Debido a esto, en la clase anterior pudimos instanciar `new House()` sin necesidad de escribir físicamente el constructor dentro del archivo `House.java`. Sin embargo, si deseas personalizarlo o usarlo explícitamente, puedes declararlo de la siguiente manera:
    
    ```java
    public House() {
        // Constructor vacío explícito
    }
    ```
    

---

### **3. La Palabra Reservada `this`**

Cuando pasamos parámetros a un constructor para inicializar atributos, es una convención de la industria que los parámetros tengan el **mismo nombre** que las variables de instancia de la clase.

- Para evitar que el compilador se confunda y no sepa cuál es el atributo de la clase y cuál es el parámetro entrante, se utiliza la palabra **`this`**.
- **`this` hace referencia estrictamente al objeto actual** en el que se está ejecutando el código.

```java
public House(int doors, int windows, double size) {
    this.doors = doors;     // 'this.doors' es el atributo. 'doors' es el parámetro.
    this.windows = windows;
    this.size = size;
}
```

---

### **4. Sobrecarga de Constructores**

<aside>
💡

La **sobrecarga** es un concepto fundamental del paradigma que permite tener **dos o más constructores (o métodos) con el mismo nombre, pero que se diferencian por la cantidad o tipo de parámetros** que reciben.

</aside>

- Gracias a esto, una misma clase puede ofrecer múltiples configuraciones para ser instanciada (por ejemplo, crear una casa vacía, una casa especificando solo el número de puertas o una casa especificando todos sus atributos).

---

### **5. Ventajas de utilizar Constructores**

Implementar constructores en lugar de asignar los atributos manualmente línea por línea tras crear el objeto ofrece tres ventajas clave:

1. **`Consistencia`:** Asegura que los objetos nazcan en memoria con un **estado válido desde el primer instante**, sin depender de que los datos sean cargados manualmente desde fuera más adelante.
2. **`Flexibilidad`:** Permite la creación de múltiples configuraciones de inicialización de acuerdo con lo que el programa requiera.
3. **`Encapsulamiento:`** Centraliza y protege la lógica de inicialización directamente dentro de su propia clase, haciendo que el código sea mucho más fácil de comprender y mantener.

---

## 💻 CÓDIGO FUENTE REFACTORIZADO CON CONSTRUCTORES

A continuación, se detalla la actualización de la clase `House` incorporando la **sobrecarga de constructores** (uno vacío y otro con parámetros) y el uso de `this`, junto a la simplificación de su clase ejecutora `HouseMain`:

### **Archivo 1: `House.java` (Molde con Constructores)**

```java
package HouseExample;

public class House {
    // Atributos de instancia
    int doors;
    int windows;
    double size;

    // 1. Constructor Vacío (Explícito por flexibilidad)
    public House() {
    }

    // 2. Constructor con Parámetros (Sobrecarga de constructor)
    public House(int doors, int windows, double size) {
        this.doors = doors;     
        // Asigna los parámetros entrantes a los atributos del objeto actual
        this.windows = windows;
        this.size = size;
    }

    // Comportamiento de instancia (void)
    public void openDoor() {
        System.out.println("La puerta está abierta.");
    }

    // Comportamiento de instancia (retorna un double)
    public double calculateArea() {
        return size * size;
    }
}
```

### **Archivo 2: `HouseMain.java` (Instanciación directa y compacta)**

```java
package HouseExample;

public class HouseMain {
    public static void main(String[] args) {
        // Inicialización clásica (dependiente de carga externa paso a paso)
        House myHouse = new House();
        myHouse.doors = 2;
        myHouse.windows = 4;
        myHouse.size = 10;

 // Inicialización directa, segura y consistente gracias al constructor con parámetros
        House myHouse2 = new House(4, 6, 20.0); 
        // Se define el estado inicial en una sola línea

        // Uso de los objetos creados
        System.out.println("La cantidad de puertas de la casa es: " + myHouse2.doors);
        myHouse2.openDoor();

        double area = myHouse2.calculateArea();
        System.out.println("El área de la casa es: " + area);
    }
}
```

---