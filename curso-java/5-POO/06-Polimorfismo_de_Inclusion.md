# 06 - Polimorfismo de Inclusión

## 📌 Concepto de Polimorfismo de Inclusión

El **polimorfismo de inclusión** (también denominado polimorfismo de sustitución o subtipado) consiste en **tratar instancias de distintas subclases (`Car`, `Motorcycle`) a través de la referencia común de su superclase (`Vehiculo`)**.

- En lugar de declarar variables estrictamente con el tipo concreto de la subclase:
  ```java
  Car myCar = new Car("Fiat", "Uno", 2000, 4); // Forma concreta restrictiva
  ```
- Se declara la referencia del tipo de la superclase:
  ```java
  Vehiculo myCar = new Car("Fiat", "Uno", 2000, 4); // Polimorfismo de inclusión
  Vehiculo myMoto = new Motorcycle("Honda", "CB", 2020, false);
  ```

---

## 🚀 Flexibilidad en Métodos Reutilizables

La ventaja principal de esta aproximación se observa al diseñar métodos utilitarios. Si un método se diseña para recibir solo `Car`:
```java
// Limitante: solo acepta objetos Car, falla si le pasamos una motocicleta
public static void printVehicle(Car car) { ... }
```

Aplicando polimorfismo de inclusión, el método se parametriza para recibir el tipo general **`Vehiculo`**:
```java
public static void printVehicle(Vehiculo vehicle) {
    System.out.println(vehicle.toString());
}
```
De esta manera, el método se vuelve universal y adaptable: puede procesar cualquier objeto que sea un `Vehiculo` (autos, motos, camiones, etc.) sin necesidad de duplicar código ni sobrecargar métodos para cada subtipo.

---

## 🔍 Invocación Directa vs. Casteo Explícito (Downcasting)

### **1. Acceso Directo a Miembros Comunes**
Cualquier método que haya sido declarado en la superclase `Vehiculo` (como `start()` o `toString()`) puede invocarse de manera directa sin ninguna conversión adicional:
```java
Vehiculo myCar = new Car("Fiat", "Uno", 2000, 4);
myCar.start(); // Funciona directamente porque start() pertenece a Vehiculo
```

### **2. Acceso a Miembros Particulares mediante Casteo**
Cuando la variable está referenciada como `Vehiculo`, el compilador no permite acceder directamente a los atributos o métodos exclusivos de la subclase (por ejemplo, `setDoors(int)` exclusivo de `Car`).

Para acceder a estos miembros particulares, es obligatorio realizar un **casteo explícito** envolviendo el objeto con paréntesis:
```java
// myCar.setDoors(5); // ERROR DE COMPILACIÓN: Vehiculo no reconoce setDoors

// Solución mediante casteo (Downcasting):
((Car) myCar).setDoors(5);
```

> [!IMPORTANT]
> **Resumen de Tiempos:**
> - **Tiempo de compilación:** El compilador verifica que el tipo de la variable sea `Vehiculo`.
> - **Tiempo de ejecución:** La Máquina Virtual de Java resuelve la llamada al objeto real instanciado (`Car`), ejecutando sus implementaciones y permitiendo el casteo a su tipo efectivo.

---

## 💻 Código Fuente Completo de la Clase

### **Archivo: `Main.java`**
```java
public class Main {
    // Método flexible que acepta cualquier subclase de Vehiculo
    public static void printVehicle(Vehiculo vehicle) {
        System.out.println(vehicle.toString());
    }

    public static void main(String[] args) {
        // 1. Declaración polimórfica (referencia Vehiculo, instancia Car y Motorcycle)
        Vehiculo myCar = new Car("Fiat", "Uno", 2000, 4);
        Vehiculo myMoto = new Motorcycle("Honda", "CB", 2020, false);

        // 2. Invocación polimórfica uniforme
        printVehicle(myCar);
        printVehicle(myMoto);

        // 3. Ejecución directa de métodos de la superclase
        myCar.start();

        // 4. Acceso a métodos específicos de la subclase mediante casteo
        ((Car) myCar).setDoors(5);

        // Verificación de los datos modificados
        printVehicle(myCar);
    }
}
```
