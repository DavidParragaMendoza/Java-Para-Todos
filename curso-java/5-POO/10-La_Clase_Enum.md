# 10 - La Clase Enum

## 📌 Concepto y Utilidad de las Enumeraciones (`enum`)

Un **`enum`** (enumeración) es un tipo especial de clase en Java que se utiliza para definir un **conjunto cerrado y predeterminado de valores constantes**.

### **¿Por qué utilizarlos en lugar de cadenas o enteros?**
- Si usamos `String` para categorías (ej. `"RED"`, `"red"`, `"Red"`), los errores tipográficos son comunes y difíciles de detectar en tiempo de compilación.
- Si usamos `int`, los valores carecen de semántica clara y pueden asignarse números fuera del rango esperado.
- Los `enum` aportan **seguridad de tipos (Type-Safety)**, garantizando que solo puedan asignarse las opciones explícitamente definidas.

---

## 🛠️ Declaración y Sintaxis de un `enum`

- Se define mediante la palabra clave **`enum`**:
  ```java
  public enum Color {
      RED, BLUE, WHITE, BLACK
  }
  ```
- **Convención:** Al representar valores constantes, los elementos se escriben obligatoriamente en **MAYÚSCULAS** y separados por comas.

### **Ejemplo de Enumeraciones en el Dominio de Vehículos:**
1. **`Color`:** Representa los colores válidos para un vehículo (`RED`, `BLUE`, `WHITE`, `BLACK`).
2. **`VehicleStatus`:** Representa el estado operacional del vehículo en el sistema (`AVAILABLE`, `SOLD`, `MAINTENANCE`).

---

## 💻 Integración en Clases y Modelos

Los tipos `enum` se emplean directamente como tipos de datos en la definición de atributos de una clase:
```java
public class Vehiculo {
    private Color color;
    private VehicleStatus vehicleStatus;
    // ...
}
```

Para utilizarlos en la creación de objetos o asignación de parámetros, se hace referencia a través del nombre de la enumeración seguido del punto y la constante:
```java
Vehiculo v = new Vehiculo("Fiat", "Uno", 2025, Color.RED, VehicleStatus.AVAILABLE);
```

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `Color.java`**
```java
public enum Color {
    RED,
    BLUE,
    WHITE,
    BLACK
}
```

### **Archivo 2: `VehicleStatus.java`**
```java
public enum VehicleStatus {
    AVAILABLE,
    SOLD,
    MAINTENANCE
}
```

### **Archivo 3: `Vehiculo.java` (Con Atributos Enum)**
```java
public class Vehiculo {
    private String brand;
    private String model;
    private int year;
    private Color color;
    private VehicleStatus vehicleStatus;

    public Vehiculo(String brand, String model, int year, Color color, VehicleStatus vehicleStatus) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vehicleStatus = vehicleStatus;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color=" + color +
                ", vehicleStatus=" + vehicleStatus +
                '}';
    }
}
```

### **Archivo 4: `Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        // Asignación segura mediante constantes del Enum
        Vehiculo miAuto = new Vehiculo(
                "Fiat",
                "Uno",
                2025,
                Color.RED,
                VehicleStatus.AVAILABLE
        );

        System.out.println(miAuto);
    }
}
```
