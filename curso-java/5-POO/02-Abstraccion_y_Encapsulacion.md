# 02 - Abstracción y Encapsulación

## 📌 Abstracción en la Práctica

La **abstracción** es el proceso mediante el cual seleccionamos las propiedades (atributos) y los comportamientos (métodos) esenciales que requiere nuestra clase a partir del problema que deseamos resolver.

En el ejemplo de la clase **`Vehiculo`**, se abstraen tres características esenciales:
- `brand`: Marca del vehículo (`String`).
- `model`: Modelo del vehículo (`String`).
- `year`: Año de fabricación (`int`).

Junto con ellos, se define su método constructor para inicializar los valores y el método especial **`toString()`** anotado con **`@Override`** para devolver la representación textual de la instancia.

---

## 🛡️ Encapsulación: Protección y Control del Estado

### **1. El problema del acceso directo**
Cuando los atributos no cuentan con un modificador restrictivo (acceso por defecto a nivel de paquete), es posible acceder a ellos y alterarlos directamente desde el `Main`:
```java
// Modificación directa insegura:
vehicle.year = 1700; // Se puede asignar un valor inconsistente sin control
```

> [!WARNING]
> Intentar validar asignaciones directamente en el `Main` mediante bloques `if` es una mala práctica: sobrecarga el método principal y dispersa la lógica de negocio que le corresponde estrictamente a la clase.

### **2. Implementación de Atributos Privados**
Para garantizar la integridad de los datos, todos los atributos deben declararse obligatoriamente con el modificador **`private`**:
- Al intentar acceder directamente desde el `Main` (`vehicle.brand`), el compilador deniega el acceso indicando que el atributo es privado en `Vehiculo`.
- Toda modificación debe canalizarse a través de métodos públicos **`setter`**.

---

## ⚙️ Validación Avanzada en Métodos Setter

La ventaja primordial de la encapsulación es incorporar reglas de validación antes de permitir cualquier modificación interna del atributo.

### **Validación de Año con `java.time.Year`**
Para evaluar si el año ingresado es realista, se utiliza la API de fecha de Java:
- `java.time.Year.now().getValue()`: Obtiene dinámicamente el año actual del sistema.
- **Regla de negocio definida:**
  - El año no puede ser menor a `1886` (año del primer automóvil fabricado en la historia).
  - El año no puede ser mayor al año actual más 2 (`currentYear + 2`, contemplando modelos que los fabricantes anuncian de forma anticipada).

```java
public void setYear(int year) {
    int currentYear = java.time.Year.now().getValue();
    
    // Si el año es menor a 1886 o superior a currentYear + 2, se rechaza
    if (year < 1886 || year > currentYear + 2) {
        throw new IllegalArgumentException("Año inválido");
    }
    
    this.year = year;
}
```

> [!IMPORTANT]
> **Interrupción de Flujo:**
> Cuando se lanza una excepción mediante `throw new IllegalArgumentException(...)`, la ejecución del programa se detiene inmediatamente. Las líneas subsiguientes no se ejecutan y el atributo conserva su integridad sin registrar datos erróneos.

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `Vehiculo.java`**
```java
public class Vehiculo {
    // 1. Atributos privados (Encapsulación)
    private String brand;
    private String model;
    private int year;

    // 2. Constructor
    public Vehiculo(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // 3. Getters y Setters con validación
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
        int currentYear = java.time.Year.now().getValue();
        if (year < 1886 || year > currentYear + 2) {
            throw new IllegalArgumentException("Año inválido");
        }
        this.year = year;
    }

    // 4. Método toString con @Override
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

### **Archivo 2: `Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        Vehiculo vehicle = new Vehiculo("Fiat", "Uno", 2000);

        // Intento con valor erróneo: detiene el programa lanzando IllegalArgumentException
        // vehicle.setYear(170);

        // Modificación controlada válida:
        vehicle.setYear(2001);
        System.out.println(vehicle);
    }
}
```
