# 07 - Herencia vs. Composición

## 📌 Criterios de Decisión: "¿Es un?" vs. "¿Tiene un?"

Al modelar un sistema orientado a objetos, determinar cuándo aplicar herencia y cuándo aplicar composición es una de las decisiones arquitectónicas más cruciales.

- **Herencia ("Es un" / "Is-a"):**
  - Se debe responder afirmativamente a la pregunta: *¿La clase hija **es un** tipo de la superclase?*
  - `Car` **es un** `Vehiculo` (Válido).
  - `Motorcycle` **es un** `Vehiculo` (Válido).
- **Composición ("Tiene un" / "Has-a"):**
  - Plantea una relación de tenencia o ensamblaje: *¿La clase **tiene un** componente?*
  - `Car` **tiene un** `Engine` (motor) o puertas (Válido para composición).

---

## ⚠️ El Problema de la Herencia Excesiva

Supongamos que incorporamos la clase **`Bicycle`** (bicicleta). Una bicicleta indudablemente es un vehículo (`Bicycle extends Vehiculo`).

Sin embargo, si la superclase `Vehiculo` define un método como `start()` para encender un motor:
- La bicicleta hereda obligatoriamente `start()`, a pesar de que las bicicletas **no tienen motor ni encendido**.
- **Costo de la herencia indebida:** Las subclases heredan absolutamente todo lo definido en la superclase, incluso métodos y comportamientos que no necesitan ni pueden implementar coherentemente.
- Si intentamos eliminar o alterar `start()` en `Vehiculo`, se genera un impacto en cascada sobre todas las demás subclases (`Car`, `Motorcycle`), rompiendo el sistema.

> [!WARNING]
> Cuando un comportamiento no es universal a todos los miembros de una jerarquía, forzarlo dentro de la superclase mediante herencia es un error grave de diseño que complica el mantenimiento.

---

## 🧩 La Solución mediante Composición

La composición resuelve este problema extrayendo la funcionalidad específica en una clase dedicada e independiente:

1. **Creación de la clase `Engine` (Motor):**
   - Centraliza el comportamiento de encendido mediante su propio método `start()`.
2. **Ajuste en `Vehiculo`:**
   - Se retira el método `start()` de `Vehiculo`, conservando únicamente comportamientos verdaderamente comunes a todos los vehículos (como `stop()` para frenar o detenerse).
3. **Composición en `Car` y `Motorcycle`:**
   - Se declara un atributo privado del tipo `Engine`:
     ```java
     private Engine engine;
     ```
   - En el constructor se inicializa la instancia (`this.engine = new Engine();`).
   - El método `start()` de `Car` deja de ser una sobreescritura y pasa a **delegar la acción al motor**: `engine.start();`.

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `Engine.java` (Componente Reutilizable)**
```java
public class Engine {
    public void start() {
        System.out.println("El motor se encendió.");
    }
}
```

### **Archivo 2: `Vehiculo.java` (Superclase Limpia)**
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

    // Comportamiento verdaderamente común a cualquier vehículo
    public void stop() {
        System.out.println("El vehículo está detenido.");
    }

    @Override
    public String toString() {
        return "Vehiculo [brand=" + brand + ", model=" + model + ", year=" + year + "]";
    }
}
```

### **Archivo 3: `Car.java` (Herencia + Composición)**
```java
public class Car extends Vehiculo {
    private int doors;
    private Engine engine; // Composición: Car tiene un Engine

    public Car(String brand, String model, int year, int doors) {
        super(brand, model, year);
        this.doors = doors;
        this.engine = new Engine();
    }

    public void start() {
        System.out.print("El auto está encendido. ");
        engine.start(); // Delegación al objeto compuesto
    }
}
```

### **Archivo 4: `Bicycle.java` (Herencia sin Motor)**
```java
public class Bicycle extends Vehiculo {
    private boolean hasBell;

    public Bicycle(String brand, String model, int year, boolean hasBell) {
        super(brand, model, year);
        this.hasBell = hasBell;
    }

    // Hereda stop() de Vehiculo, pero NO tiene que lidiar con métodos de motor
}
```

### **Archivo 5: `Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        Vehiculo myCar = new Car("Fiat", "Uno", 2000, 4);
        Vehiculo myMoto = new Motorcycle("Honda", "CB", 2020, false);

        // Invocación a los métodos con delegación interna al motor mediante casteo:
        ((Car) myCar).start();
        ((Motorcycle) myMoto).start();

        // Parada común de vehículos:
        myCar.stop();
        myMoto.stop();
    }
}
```
