# 05 - Polimorfismo: Sobrecarga y Sobreescritura

## 📌 Principio del Polimorfismo

El **polimorfismo** es el pilar de la programación orientada a objetos que permite que **un mismo método exhiba comportamientos diferentes según la clase concreta que lo implemente**.
- *Ejemplo conceptual:* Tanto un automóvil como una motocicleta son vehículos y ambos se encienden (`start()`), pero el mecanismo físico y las acciones de encendido son diferentes para cada uno.

En Java, el polimorfismo se divide en dos categorías según el momento en que se resuelve:
1. **Polimorfismo en tiempo de compilación (Sobrecarga de Métodos / Overloading).**
2. **Polimorfismo en tiempo de ejecución (Sobreescritura de Métodos / Overriding).**

---

## ⚡ 1. Polimorfismo en Tiempo de Compilación (Sobrecarga / Overloading)

Ocurre directamente durante la escritura del código y es resuelto por el compilador según la firma del método.
- **Regla de la sobrecarga:** Métodos dentro de la misma clase que comparten exactamente el mismo nombre, pero **difieren en su lista de parámetros**:
  - Distinta cantidad de parámetros.
  - Distintos tipos de datos en sus argumentos.

> [!WARNING]
> No es posible sobrecargar un método cambiando únicamente el nombre del parámetro si el tipo de dato es idéntico (ej. `start(boolean silentMode)` y `start(boolean silent)`). El compilador detecta una colisión de firma y rechaza el código por ambigüedad.

```java
// Sobrecarga del método start en Vehiculo:
public void start() {
    System.out.println("Vehículo encendido.");
}

public void start(boolean silentMode) {
    if (silentMode) {
        System.out.println("Vehículo encendido en modo silencioso.");
    } else {
        System.out.println("Vehículo encendido.");
    }
}
```

---

## 🔄 2. Polimorfismo en Tiempo de Ejecución (Sobreescritura / Overriding)

Ocurre cuando una subclase **redefine el comportamiento de un método heredado de su superclase** para adaptarlo a su naturaleza específica.
- Se identifica explícitamente mediante la anotación **`@Override`**.
- La firma del método (nombre, retorno y parámetros) debe coincidir con la de la superclase.
- Durante la ejecución del programa, la Máquina Virtual de Java invoca la versión redefinida correspondiente al tipo real del objeto instanciado.

> [!NOTE]
> **El origen de `@Override toString()`:**
> En Java, todas las clases heredan implícitamente de la clase universal **`Object`**. Por ello, cuando definimos `toString()` estamos sobreescribiendo el método provisto por `Object` para personalizar el formato textual de nuestra clase.

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `Vehiculo.java`**
```java
public class Vehiculo {
    private String brand;
    private String model;
    private int year;

    public Vehiculo(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Método base
    public void start() {
        System.out.println("Vehículo encendido.");
    }

    // Sobrecarga (Overloading) en tiempo de compilación
    public void start(boolean silentMode) {
        if (silentMode) {
            System.out.println("Vehículo encendido en modo silencioso.");
        } else {
            System.out.println("Vehículo encendido.");
        }
    }

    @Override
    public String toString() {
        return "Vehiculo [brand=" + brand + ", model=" + model + ", year=" + year + "]";
    }
}
```

### **Archivo 2: `Car.java` (Sobreescritura)**
```java
public class Car extends Vehiculo {
    private int doors;

    public Car(String brand, String model, int year, int doors) {
        super(brand, model, year);
        this.doors = doors;
    }

    // Sobreescritura (Overriding) en tiempo de ejecución
    @Override
    public void start() {
        System.out.println("El auto está encendido.");
    }
}
```

### **Archivo 3: `Motorcycle.java` (Sobreescritura)**
```java
public class Motorcycle extends Vehiculo {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    // Sobreescritura (Overriding) adaptada a la moto
    @Override
    public void start() {
        System.out.println("La moto está encendida.");
    }
}
```

### **Archivo 4: `Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Fiat", "Uno", 2000, 4);
        Motorcycle myMoto = new Motorcycle("Honda", "CB", 2020, false);

        // Cada subclase ejecuta su propia versión redefinida:
        myCar.start();  // Salida: El auto está encendido.
        myMoto.start(); // Salida: La moto está encendida.
    }
}
```
