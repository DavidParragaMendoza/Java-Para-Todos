# 03 - Herencia

## 📌 Concepto de Herencia en Java

La **herencia** es el mecanismo que permite que una clase derivada denominada **subclase** adquiera y reutilice los atributos y métodos de otra clase superior llamada **superclase**.

- **¿Cuándo aplicarla?** Se utiliza cuando múltiples clases comparten características y comportamientos comunes en el dominio del problema ("cuando algo se parece a algo").
- **Beneficio principal:** Evita duplicar código, facilita la mantención del sistema y permite que las clases hijas se enfoquen únicamente en sus particularidades.

> [!CAUTION]
> **Regla Estricta de Herencia en Java:**
> En Java la herencia de clases es **estrictamente simple**. Una subclase solo puede extender de una única superclase de forma directa. No se permite la herencia múltiple mediante comas (`class Car extends Vehiculo, Otro` no compila). Para comportamientos múltiples se utiliza posteriormente la implementación de interfaces.

---

## 🛠️ Mecánica de Implementación de la Herencia

### **1. La palabra clave `extends`**
Para establecer la relación de parentesco se utiliza la instrucción `extends`:
```java
public class Car extends Vehiculo {
    // Car hereda todos los miembros no privados de Vehiculo
}
```

### **2. Atributos Específicos**
Aquellos atributos que no son comunes a todos los vehículos se definen exclusivamente dentro de la subclase correspondiente:
- En `Car`: atributo `doors` (`int`), ya que no todos los vehículos poseen puertas.
- En `Motorcycle`: atributo `hasSidecar` (`boolean`), específico de las motos.

### **3. El Constructor y la Invocación a `super()`**
- Para inicializar correctamente los atributos heredados de la superclase, el constructor de la subclase debe invocar obligatoriamente a **`super(...)`** en su primera línea.
- Luego de `super(...)`, se utiliza **`this`** para asignar los atributos propios de la subclase:

```java
public class Car extends Vehiculo {
    private int doors;

    public Car(String brand, String model, int year, int doors) {
        super(brand, model, year); // Inicializa los miembros de la superclase Vehiculo
        this.doors = doors;        // Asigna el atributo propio de Car
    }
}
```

### **4. Reutilización del método `toString()` con `super.toString()`**
Dentro del método `toString()` de la subclase, se puede invocar a `super.toString()` para obtener la cadena con los datos de la superclase y concatenarle los atributos propios, manteniendo el código limpio y sin repeticiones:

```java
@Override
public String toString() {
    return super.toString() + " | Puertas: " + doors;
}
```

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `Vehiculo.java` (Superclase)**
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

    public void start() {
        System.out.println("Vehículo encendido.");
    }

    public void stop() {
        System.out.println("Vehículo detenido.");
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
        return "Vehiculo [brand=" + brand + ", model=" + model + ", year=" + year + "]";
    }
}
```

### **Archivo 2: `Car.java` (Subclase)**
```java
public class Car extends Vehiculo {
    private int doors;

    public Car(String brand, String model, int year, int doors) {
        super(brand, model, year);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return super.toString() + ", doors=" + doors;
    }
}
```

### **Archivo 3: `Motorcycle.java` (Subclase con Comportamiento Propio)**
```java
public class Motorcycle extends Vehiculo {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    // Comportamiento particular de la motocicleta
    public void wheelie() {
        System.out.println("La moto está haciendo wheelie.");
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasSidecar=" + hasSidecar;
    }
}
```
