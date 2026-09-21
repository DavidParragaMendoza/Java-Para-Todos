# 09 - Clases Abstractas e Interfaces: Parte 2

## 📌 Implementación de Interfaces y Métodos Abstractos

Cuando una subclase concreta extiende de una clase abstracta e implementa una interfaz, asume el compromiso de **implementar todos los métodos pendientes**:
- **Métodos abstractos heredados:** Debe sobrescribir obligatoriamente los métodos declarados como `abstract` en la clase base (`drive()` de `Vehiculo`).
- **Métodos de la interfaz:** Debe definir obligatoriamente la implementación de las firmas del contrato (`chargeBattery()` de `Electric`).

```java
public class ElectricCar extends Vehiculo implements Electric {
    // Debe implementar drive() y chargeBattery()
}
```

---

## ⚡ Herencia Múltiple mediante Interfaces

Una de las reglas fundamentales de Java es que **ninguna clase permite herencia múltiple de clases** (`extends` admite únicamente una superclase).

Sin embargo, Java permite solventar esta limitación a través de las interfaces:
- Una clase puede implementar **múltiples interfaces separadas por comas**:
  ```java
  public class ElectricCar extends Vehiculo implements Electric, SelfDriving { ... }
  ```
- Esto permite dotar a la clase de múltiples capacidades y comportamientos sin caer en las complejidades ni ambigüedades de la herencia múltiple tradicional.

---

## 📊 Cuadro Comparativo Definitivo

| Aspecto | Clase Abstracta | Interfaz |
| :--- | :--- | :--- |
| **Herencia Múltiple** | ❌ No permitida (solo una clase base). |  Permite implementar múltiples interfaces simultáneamente. |
| **Constructores** |  Posee constructores (invocados con `super()`). | ❌ No posee ningún tipo de constructor. |
| **Métodos con Cuerpo** |  Permite métodos con implementación completa y métodos abstractos. | ❌ Tradicionalmente solo firmas de métodos abstractos sin cuerpo. |
| **Tipos de Atributos** | Variables, constantes, privados, protegidos, etc. | Exclusivamente constantes (`public static final`). |
| **Tipo de Relación** | **Parentesco real ("Es un"):** El hijo se parece al padre (`Car` es un `Vehiculo`). | **Comportamiento / Capacidad ("Puede hacer"):** Un comportamiento común aplicable a entidades no emparentadas (ej. `Volar` para un ave, un avión o un dron). |

---

## 💡 Concepto Avanzado: Clases Anónimas

Aunque no se puede instanciar directamente una clase abstracta con el constructor convencional, Java permite crear una **clase anónima**:
- Es una clase sin nombre que se declara e instancia en una sola expresión mediante `new`.
- Permite sobrescribir al vuelo los métodos abstractos necesarios:

```java
Vehiculo v = new Vehiculo("Fiat", "Uno", 2000) {
    @Override
    public void drive() {
        System.out.println("Conduciendo vehículo desde clase anónima.");
    }
};
```

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `SelfDriving.java` (Segunda Interfaz)**
```java
public interface SelfDriving {
    void activatePilot();
}
```

### **Archivo 2: `ElectricCar.java` (Extensión e Implementación Múltiple)**
```java
public class ElectricCar extends Vehiculo implements Electric, SelfDriving {
    private int batteryLevel;

    public ElectricCar(String brand, String model, int year, int batteryLevel) {
        super(brand, model, year);
        this.batteryLevel = batteryLevel;
    }

    // 1. Implementación del método abstracto de Vehiculo
    @Override
    public void drive() {
        System.out.println("El auto eléctrico está en marcha.");
    }

    // 2. Implementación de la interfaz Electric
    @Override
    public void chargeBattery() {
        this.batteryLevel = 100;
        System.out.println("Batería cargada al 100%.");
    }

    // 3. Implementación de la interfaz SelfDriving
    @Override
    public void activatePilot() {
        System.out.println("Modo piloto automático activado.");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
```

### **Archivo 3: `Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        // Uso de subclase concreta
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 50);
        tesla.drive();
        tesla.chargeBattery();
        tesla.activatePilot();

        // Demostración de Clase Anónima para instanciación directa
        Vehiculo customVehicle = new Vehiculo("Fiat", "Uno", 2000) {
            @Override
            public void drive() {
                System.out.println("Conduciendo vehículo genérico.");
            }
        };
        customVehicle.drive();
        System.out.println(customVehicle);
    }
}
```
