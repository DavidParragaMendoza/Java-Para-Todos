## 📌 Atributo `static` VS Atributo de Instancia

Esta clase profundiza en el uso del modificador **`static`** aplicado a las variables de una clase (atributos), estableciendo un claro contraste con los atributos de instancia que veníamos utilizando.

### **1. Atributos de Instancia**

- **Definición:** Son las variables declaradas dentro de una clase que pertenecen de forma única e independiente a cada objeto individual (instancia).
- **Comportamiento en memoria:** Cada vez que creas un objeto con la palabra clave `new`, Java realiza una **copia física exclusiva** de estos atributos en un espacio de memoria nuevo. Los cambios que le hagas a un objeto no afectarán en absoluto al otro.
- **Ejemplo del curso:** En la clase `Classroom`, el nombre del estudiante (`studentName`) es un atributo de instancia, porque cada alumno que se registre en el aula tendrá un nombre único que variará de persona en persona.

---

### **2. Atributos Estáticos o de Clase (`static`)**

- **Definición:** Son atributos declarados utilizando el modificador **`static`**. No pertenecen a un objeto en particular, sino a la **clase en general**.
- **Comportamiento en memoria:**
    - **Copia única:** Java genera **una única copia** de este atributo en memoria.
    - **Compartición Global:** Todos los objetos creados a partir de esa plantilla **comparten exactamente la misma variable**. Si un objeto modifica el valor del atributo estático, este se actualiza inmediatamente para todas las demás instancias de la clase.
    - **Optimización:** Al no duplicar la variable por cada objeto que nace en memoria, se logra un consumo de recursos sumamente eficiente.
- **Ejemplo del curso:** En la misma clase `Classroom`, el nombre del colegio (`schoolName`) se define como `static` porque se asume que todos los alumnos de esa aula pertenecen a la misma institución. Si el nombre del colegio cambia, se actualiza globalmente para todos los estudiantes al mismo tiempo.

---

### **3. Diferencia de Acceso en Código**

- **Atributos de Instancia:** Requieren obligatoriamente instanciar un objeto con `new` y se accede a ellos a través de la variable del objeto.
    
    ```java
    Classroom student1 = new Classroom("María"); // Atributo de instancia
    ```
    
- **Atributos Estáticos:** No se necesita crear un objeto para acceder a ellos. Se accede utilizando directamente el **nombre de la clase**.
    
    ```java
    Classroom.setSchoolName("Escuela Técnica N° 1"); // Acceso directo por clase
    ```
    

---

## 📌 Métodos de Clase (`static`)

Al igual que las variables, los comportamientos o métodos de una clase pueden ser declarados con el modificador `static`.

### **1. ¿Qué es un Método Estático?**

- **Definición:** Es un método que pertenece a la **clase** y no a una instancia u objeto en particular.
- **Comportamiento:** Se puede utilizar e invocar directamente **sin necesidad de crear un objeto en memoria** con el operador `new`.
- **Casos de uso comunes:** Se utilizan para construir **clases de utilidad**, operaciones matemáticas (como la clase estándar `Math` de Java) o clases de tipo ***helpers*** que resuelven tareas lógicas comunes e independientes en nuestro sistema.

---

### **2. Restricciones de los Miembros Estáticos**

- **Aislamiento de la instancia:** Un método estático **no puede acceder de forma directa a variables o métodos de instancia** (atributos comunes no estáticos), a menos que primero cree un objeto de esa clase dentro de su bloque de código.
- **La razón lógica:** Como el método estático se carga a nivel de clase cuando el programa inicia (antes de que existan objetos en memoria), el método "no tiene forma de saber" de qué objeto físico debe leer el atributo mutable.

---

### **3. Los Métodos en Memoria (Mitos y Realidades)**

- **Mito de la Duplicación:** Existe la creencia de que si creas mil objetos de una clase en memoria, sus métodos también se duplican mil veces en el sistema.
- **La Realidad:** En Java, **los métodos nunca se duplican en memoria**. El código ejecutable del método se almacena una única vez en un área de memoria especial del sistema (denominada **Metaspace** según la versión de Java).
- Lo único que se clona y diferencia a cada instancia en el mapa de memoria ordinario son sus **atributos de instancia**.

---

## 💻 CÓDIGO FUENTE DE PRÁCTICA INTEGRADO

Este ejemplo reúne la aplicación práctica de los atributos estáticos (`schoolName`) y un método estático de utilidad matemática (`add`) visto en tus clases:

### **Archivo 1: `Classroom.java` (Molde con variables de instancia y estáticas)**

```java
package classroomExample;

public class Classroom {
    // Atributo de instancia (Cada estudiante tiene su copia única en memoria)
    private String studentName;

    // Atributo estático (Una única copia compartida globalmente por la clase)
    private static String schoolName = "Escuela Técnica N° 1";

    // Constructor que inicializa el atributo de instancia
    public Classroom(String studentName) {
        this.studentName = studentName;
    }

    // Getters y Setters de instancia
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Getter y Setter ESTÁTICOS (pertenecen a la clase)
    public static String getSchoolName() {
        return schoolName;
    }

    public static void setSchoolName(String newSchoolName) {
        schoolName = newSchoolName; // Cambia el valor de forma global para todos
    }

    // Comportamiento de instancia para mostrar información
    public void displayInfo() {
        System.out.println("Estudiante: " + studentName + " | Colegio: " + schoolName);
    }
}
```

### **Archivo 2: `MathUtility.java` (Clase Helper con Método Estático)**

```java
package classroomExample;

public class MathUtility {
    // Método estático de utilidad matemática
    public static int add(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }
}
```

### **Archivo 3: `MainApp.java` (Punto de Ejecución Principal)**

```java
package classroomExample;

public class MainApp {
    public static void main(String[] args) {
        // 1. Instanciamos dos estudiantes con diferentes nombres de instancia
        Classroom student1 = new Classroom("María");
        Classroom student2 = new Classroom("Juan");

        System.out.println("--- Estado Inicial de los Objetos ---");
        student1.displayInfo(); 
        // Imprime: María | Colegio: Escuela Técnica N° 1
        student2.displayInfo(); 
        // Imprime: Juan | Colegio: Escuela Técnica N° 1

        // 2. Modificamos el atributo estático llamando directamente a la CLASE
        Classroom.setSchoolName("Colegio de Especialización N° 2");

        System.out.println("\n--- Estado Post-Modificación Estática ---");
        student1.displayInfo(); 
        // Imprime: María | Colegio: Colegio de Especialización N° 2
        student2.displayInfo(); 
        // Imprime: Juan | Colegio: Colegio de Especialización N° 2
        
        // El cambio afectó a ambos estudiantes porque comparten el 
        // mismo atributo estático.

        // 3. Ejecutamos un método estático de utilidad (sin instanciar con 'new')
        System.out.println("\n--- Ejecutando Método Estático de Utilidad ---");
        int result = MathUtility.add(25, 15); 
        // Llamada directa
        System.out.println("La suma calculada es: " + result); 
        // Imprime 40
    }
}
```

---