# 11 - Proyecto Final: Consolidación de POO (Sección 5)

## 📌 Objetivo del Proyecto Final

El objetivo de esta lección práctica es consolidar de forma integral todos los principios de la **Programación Orientada a Objetos** estudiados a lo largo de la Sección 5 dentro de una misma arquitectura de software:
- Clases abstractas y métodos abstractos.
- Herencia simple y jerárquica en cadena (`extends`).
- Encapsulamiento con atributos privados, constructores, getters y setters.
- Enumeraciones (`enum`) para tipado seguro de categorías.
- Interfaces (`interface`) para definir contratos de comportamiento.
- Sobreescritura polimórfica de métodos (`@Override`).
- Reutilización de código con llamadas a `super()` y `super.toString()`.

---

## 🏗️ Arquitectura de Componentes del Proyecto

1. **`Vehiculo` (Clase Abstracta):**
   - Superclase base que modela los atributos comunes (`brand`, `model`, `year`).
   - Define el método abstracto obligatorio `public abstract void start();`.
   - Provee el método concreto común `public void stop()` que imprime `"El vehículo está detenido."`.
   - Implementa constructor, getters, setters y el método `toString()`.

2. **`CardType` (Enumeración):**
   - Define las categorías cerradas de tipo de carrocería en mayúsculas: `SPORTS`, `SEDAN`, `TRUCK`.

3. **`Car` (Subclase Concreta):**
   - Extiende de `Vehiculo` (`public class Car extends Vehiculo`).
   - Aplica encapsulamiento con el atributo privado `private CardType type;`.
   - Su constructor invoca a `super(brand, model, year)` para inicializar los atributos de `Vehiculo`.
   - Implementa obligatoriamente el método abstracto `start()` imprimiendo `"El auto arrancó."`.
   - Sobrescribe `toString()` integrando `super.toString() + " tipo: " + type`.

4. **`Electric` (Interfaz):**
   - Contrato que define el comportamiento eléctrico: `public void chargeBattery();`.

5. **`ElectricCar` (Jerarquía en Cadena e Interfaz):**
   - Extiende de `Car` (`public class ElectricCar extends Car implements Electric`).
   - Al extender de `Car`, hereda transitivamente de `Vehiculo` y tiene acceso a la jerarquía de `super`.
   - Encapsula el atributo propio `private int batteryLevel;`.
   - Sobrescribe el método `start()` indicando `"El auto eléctrico está encendido."`.
   - Implementa el método de la interfaz `chargeBattery()` fijando `batteryLevel = 100` y mostrando `"La batería está cargada al 100%."`.
   - Sobrescribe `toString()` reutilizando la cadena generada por `super.toString()`.

---

## 💻 Código Fuente Completo del Proyecto

### **1. `Vehiculo.java`**
```java
package proyectofinal;

public abstract class Vehiculo {
    private String brand;
    private String model;
    private int year;

    public Vehiculo(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Método abstracto obligatorio
    public abstract void start();

    // Método con implementación común
    public void stop() {
        System.out.println("El vehículo está detenido.");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
```

### **2. `CardType.java`**
```java
package proyectofinal;

public enum CardType {
    SPORTS,
    SEDAN,
    TRUCK
}
```

### **3. `Car.java`**
```java
package proyectofinal;

public class Car extends Vehiculo {
    private CardType type;

    public Car(String brand, String model, int year, CardType type) {
        super(brand, model, year);
        this.type = type;
    }

    @Override
    public void start() {
        System.out.println("El auto arrancó.");
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " tipo: " + type;
    }
}
```

### **4. `Electric.java`**
```java
package proyectofinal;

public interface Electric {
    void chargeBattery();
}
```

### **5. `ElectricCar.java`**
```java
package proyectofinal;

public class ElectricCar extends Car implements Electric {
    private int batteryLevel;

    public ElectricCar(String brand, String model, int year, CardType type, int batteryLevel) {
        super(brand, model, year, type);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void start() {
        System.out.println("El auto eléctrico está encendido.");
    }

    @Override
    public void chargeBattery() {
        this.batteryLevel = 100;
        System.out.println("La batería está cargada al 100%.");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return super.toString() + " | batteryLevel=" + batteryLevel + "%";
    }
}
```

### **6. `Main.java`**
```java
package proyectofinal;

public class Main {
    public static void main(String[] args) {
        // Creación del auto convencional
        Car car = new Car("Toyota", "Corolla", 2022, CardType.SEDAN);
        car.start();
        car.stop();
        System.out.println(car);

        System.out.println("----------------------------------------");

        // Creación del auto eléctrico
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 2024, CardType.SPORTS, 40);
        electricCar.start();
        electricCar.chargeBattery();
        electricCar.stop();
        System.out.println(electricCar);
    }
}
```
