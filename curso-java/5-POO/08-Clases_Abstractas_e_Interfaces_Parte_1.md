# 08 - Clases Abstractas e Interfaces: Parte 1

## 📌 Clases Abstractas (`abstract class`)

Una **clase abstracta** es aquella diseñada específicamente para **servir como base y plantilla para otras subclases**, proporcionando la estructura y el comportamiento común del dominio.

- Se declara utilizando la palabra clave **`abstract`**:
  ```java
  public abstract class Vehiculo { ... }
  ```
- **Imposibilidad de instanciación directa:** No se puede crear un objeto directamente con `new Vehiculo()`. Solo es posible instanciar sus subclases concretas (o de forma indirecta mediante clases anónimas).
- **Constructores:** Las clases abstractas sí poseen constructores. Estos son invocados por las subclases a través del método `super()` para inicializar los atributos base.
- **Métodos abstractos:** Son métodos que se declaran con la palabra clave `abstract` y finalizan en punto y coma (`;`), **sin cuerpo ni llaves `{}`**. Establecen un comportamiento obligatorio que las subclases concretas deben implementar.
- **Métodos concretos:** Pueden convivir métodos abstractos con métodos comunes implementados (como `stop()`).

---

## 📜 Interfaces (`interface`): Definición y Contratos

Una **interfaz** es un **contrato formal** que define un conjunto de operaciones que una clase se compromete a cumplir a rajatabla si decide implementarla.

- Se declara con la palabra clave **`interface`**:
  ```java
  public interface Electric {
      void chargeBattery();
  }
  ```
- **Sin cuerpo de método:** Los métodos de una interfaz tradicional no pueden contener bloque de código ni llaves `{}`.
- **Sin constructores:** A diferencia de las clases abstractas, las interfaces no tienen constructores de ningún tipo.
- **Modificadores redundantes:** Los métodos en una interfaz son **públicos y abstractos por defecto**. Colocar explícitamente `public abstract` es considerado redundante en Java.

---

## ⚖️ Atributos en Interfaces vs. Clases Abstractas

| Característica | Clase Abstracta | Interfaz |
| :--- | :--- | :--- |
| **Tipos de Atributos** | Cualquier tipo: variables, constantes, privados, protegidos, etc. | Únicamente constantes públicas y estáticas. |
| **Modificadores Implícitos** | No hay modificadores implícitos; se deben declarar. | Todo atributo es implícitamente **`public static final`**. |
| **Justificación de `static`** | Acceso ligado a instancias normales mediante constructores. | Como no hay constructor ni instancias directas de la interfaz, el atributo **debe ser estático** para poder accederse a través del nombre de la interfaz (`Electric.CONSTANTE`). |

> [!NOTE]
> Las clases abstractas e interfaces no compiten entre sí; se complementan para resolver diferentes niveles de abstracción y desacoplamiento en el diseño de software.

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `Vehiculo.java` (Clase Abstracta)**
```java
public abstract class Vehiculo {
    private String brand;
    private String model;
    private int year;

    // Constructor utilizado por subclases mediante super()
    public Vehiculo(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // 1. Método abstracto (obligatorio a implementar en subclases)
    public abstract void drive();

    // 2. Método concreto con cuerpo
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
        return "Vehiculo [brand=" + brand + ", model=" + model + ", year=" + year + "]";
    }
}
```

### **Archivo 2: `Electric.java` (Interfaz / Contrato)**
```java
public interface Electric {
    // Atributo constante implícito: public static final
    int MAX_BATTERY = 100;

    // Método abstracto implícito: public abstract (sin cuerpo)
    void chargeBattery();
}
```
