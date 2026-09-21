## 📌 Modificadores de acceso y Encapsulamiento

Los modificadores de acceso en Java controlan la visibilidad de las clases, constructores, atributos y métodos, sirviendo como la herramienta principal para implementar el **encapsulamiento**. El encapsulamiento consiste en proteger y ocultar el estado interno (datos) de un objeto para evitar que sea manipulado o alterado de forma directa e indebida desde fuera de su propia clase.

---

### **1. La Mala Práctica de Acceso Directo**

En los ejercicios anteriores, accedíamos directamente a las variables del objeto utilizando el operador punto (por ejemplo, `myHouse.doors = 2;`). Esto se considera una **mala práctica de programación** en el paradigma de objetos.

- **¿Por qué podíamos hacerlo?** Hasta ahora, tanto `House` como `HouseMain` se encontraban guardados dentro del mismo directorio o paquete (`HouseExample`). Al no asignarle ninguna palabra clave inicial a los atributos, Java les otorga automáticamente un nivel de visibilidad por defecto que permite que cualquier clase vecina dentro de la misma carpeta los lea y modifique.
- **El riesgo:** Permitir el acceso directo expone los datos del objeto, lo que puede provocar inconsistencias o errores si se le asignan valores incoherentes desde clases externas.

---

### **2. Los Niveles de Visibilidad (Esquema de Modificadores)**

Java cuenta con cuatro niveles de visibilidad que van desde el más cerrado (núcleo) hasta el más abierto:

!image.png

- **`private` (Privado):** Es el modificador más restrictivo. Un miembro (atributo o método) marcado como `private` **solo puede ser visto y utilizado dentro de las llaves de su propia clase**. Si se intenta acceder a él desde el exterior, el compilador bloqueará la acción arrojando un error de acceso privado.
- **`default` (Por defecto / Protección de paquete):** No se escribe ninguna palabra reservada. El acceso predeterminado restringe el uso del miembro únicamente a las clases que comparten el **mismo paquete**.
- **`protected` (Protegido):** Permite el acceso a miembros de la clase si están dentro del mismo paquete o dentro de clases que heredan de ella (**subclases**), incluso si están en paquetes distintos.
- **`public` (Público):** Es el nivel menos restrictivo. Se puede acceder al miembro desde cualquier parte del sistema sin ningún tipo de barrera o restricción.

---

### **3. Métodos *Getter* y *Setter***

Para cumplir con el encapsulamiento, la regla de oro de la POO dicta que **los atributos siempre deben declararse como `private` y los métodos (comportamientos) como `public`**.

Pero, si los atributos son privados, ¿cómo interactuamos con ellos? Lo hacemos de forma segura a través de métodos intermediarios públicos conocidos como **Getters** y **Setters**:

- **El Setter (Establecedor):** Es un método `public void` que recibe un valor por parámetro y lo asigna de forma controlada al atributo privado. Permite añadir lógica de validación (por ejemplo, verificar que las puertas no sean un número negativo) antes de guardar el dato.
- **El Getter (Obtenedor):** Es un método `public` que especifica un tipo de retorno y se encarga de devolver el valor actual del atributo privado.

> 💡 **Atajo de Productividad en IntelliJ:** Puedes generar todos estos métodos de forma automática presionando **`Cmd + N`** en Mac (o **`Alt + Insert` / clic derecho** en Windows), seleccionando la opción **Getter and Setter** y eligiendo los atributos deseados.
> 

---

## 💻 CÓDIGO FUENTE REFACTORIZADO Y ENCAPSULADO

A continuación, se presenta la refactorización de tus archivos de clase aplicando el encapsulamiento estricto, la protección de atributos y el uso de *Getters* y *Setters*:

### **Archivo 1: `House.java` (Molde Encapsulado)**

```java
package HouseExample;

public class House {
    // 1. Atributos privados (Nadie puede acceder a ellos de forma directa con '.')
    private int doors;
    private int windows;
    private double size;

    // 2. Constructores públicos
    public House() {
    }

    public House(int doors, int windows, double size) {
        this.doors = doors;
        this.windows = windows;
        this.size = size;
    }

    // 3. Métodos Getters y Setters generados para el control de acceso
    public int getDoors() {
        return doors; // Retorna el valor actual
    }

    public void setDoors(int doors) {
        this.doors = doors; // Asigna el valor entrante de forma controlada
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    // 4. Comportamientos públicos de la clase
    public void openDoor() {
        System.out.println("La puerta está abierta.");
    }

    public double calculateArea() {
        return size * size;
    }
}
```

### **Archivo 2: `HouseMain.java` (Ejecución Segura)**

```java
package HouseExample;

public class HouseMain {
    public static void main(String[] args) {
        // Creación del primer objeto usando constructor vacío
        House myHouse = new House();

        // Asignación controlada a través de los métodos Setter
        myHouse.setDoors(2);
        myHouse.setWindows(4);
        myHouse.setSize(10.0);

        // Creación del segundo objeto directo con constructor parametrizado
        House myHouse2 = new House(4, 6, 20.0);

        // Intento de acceso directo prohibido:
        // System.out.println(myHouse2.doors); 
        // ❌ ERROR DE COMPILACIÓN: doors es privado

        // Lectura segura a través del método Getter
        System.out.println("La cantidad de puertas de la casa es: " + myHouse2.getDoors());

        // Invocación de comportamientos públicos
        myHouse2.openDoor();

        double area = myHouse2.calculateArea();
        System.out.println("El área de la casa es: " + area);
    }
}
```

---