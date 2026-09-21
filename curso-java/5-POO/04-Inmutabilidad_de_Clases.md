# 04 - Inmutabilidad de Clases

## 📌 Concepto de Inmutabilidad

Una clase es **inmutable** cuando, una vez creada una instancia física de la misma en memoria, su **estado interno no puede ser alterado bajo ninguna circunstancia**.
- Todos sus atributos permanecen constantes a lo largo de todo el ciclo de vida del objeto.
- No es posible modificar ni reasignar los valores de sus propiedades tras su construcción inicial.
- **Contraste con clases mutables:** En una clase mutable podemos cambiar sus valores en cualquier momento usando métodos `setter`. En una clase inmutable, si se necesita un objeto con datos distintos, es indispensable **crear una nueva instancia independiente** mediante el operador `new`.

---

## 🔒 Pasos para Construir una Clase Inmutable en Java

Para implementar una clase verdaderamente inmutable, se deben cumplir cuatro reglas estructurales esenciales:

1. **Declarar la clase con el modificador `final`:**
   - Impide que la clase sea extendida o heredada por otra clase.
   - Garantiza que ninguna subclase pueda sobrescribir sus métodos ni alterar su comportamiento interno.

2. **Declarar todos sus atributos como `private` y `final`:**
   - `private`: Restringe el acceso directo desde el exterior.
   - `final`: Convierte cada atributo en una constante que solo puede recibir un valor una única vez.

3. **Inicializar todos los atributos a través del constructor:**
   - Al ser atributos `final`, el compilador exige su inicialización obligatoria en el constructor para dotar de estado inicial al objeto.

4. **No proveer ningún método `setter`:**
   - La clase no debe exponer ningún método de modificación. Solo se deben generar métodos **`getter`** para permitir la lectura segura de los datos.

> [!IMPORTANT]
> **Imposibilidad de Herencia:**
> Una clase declarada como `final` (como `public final class House`) **no puede ser utilizada como superclase**. El compilador bloquea cualquier intento de herencia (`class Chalet extends House` generará un error de compilación inmediato).

---

## 💻 Código Fuente Completo de la Clase

### **Archivo 1: `House.java` (Clase Inmutable)**
```java
package Inmutabilidad;

public final class House {
    // 1. Atributos constantes y privados
    private final int doors;
    private final int windows;
    private final double size;

    // 2. Inicialización obligatoria mediante constructor
    public House(int doors, int windows, double size) {
        this.doors = doors;
        this.windows = windows;
        this.size = size;
    }

    // 3. Únicamente métodos getter (sin setters)
    public int getDoors() {
        return doors;
    }

    public int getWindows() {
        return windows;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "House{" +
                "doors=" + doors +
                ", windows=" + windows +
                ", size=" + size +
                '}';
    }
}
```

### **Archivo 2: `Main.java` (Uso de Clases Inmutables)**
```java
package Inmutabilidad;

public class Main {
    public static void main(String[] args) {
        // Creación del objeto inmutable
        House house1 = new House(2, 4, 100.5);
        System.out.println("Puertas de la casa: " + house1.getDoors());

        // house1.setDoors(4); // ERROR: El método no existe ni es permitido

        // Para obtener una casa con características distintas, se debe crear una nueva instancia:
        House house2 = new House(4, 6, 200.0);
        System.out.println("Segunda casa: " + house2);
    }
}
```
