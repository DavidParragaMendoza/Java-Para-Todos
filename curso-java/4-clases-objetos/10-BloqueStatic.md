## 📌 Bloque Static

En esta clase se analiza el concepto y el funcionamiento del **bloque estático** (*static block*), una estructura especial de Java diseñada para ejecutar lógica de configuración global y preparar recursos antes de que el programa principal comience a funcionar.

---

### **1. ¿Qué es un Bloque Estático?**

- **Definición:** Es un bloque de código definido dentro de una clase utilizando únicamente la palabra reservada **`static`** seguida de llaves `{ }`.
- **Momento Único de Ejecución:** Se ejecuta **una única vez cuando la clase se carga en memoria** por primera vez.
- **Prioridad Absoluta:** Su ejecución ocurre de manera obligatoria **antes de que se cree cualquier objeto (instancia) de esa clase y antes de que se ejecute el propio método `main`**.
- **Independencia del Orden:** No es un tema de orden físico en el código. Aunque escribas el bloque estático debajo del método `main`, Java lo identificará y lo cargará primero debido a su ciclo de vida prioritario.
- **Caso de Uso Principal:** Se utiliza de forma masiva para inicializar variables estáticas y configurar recursos globales e indispensables que la aplicación necesitará para arrancar (como configuraciones de bases de datos o lecturas de archivos del sistema).

---

### **2. Restricciones Lógicas del Bloque Estático**

- **Aislamiento de Instancia:** Un bloque estático **no puede contener ni manipular atributos o métodos de instancia** (no estáticos).
- **Causa del Error:** Si intentas acceder a un atributo común no estático dentro de un bloque `static`, el compilador detendrá el proceso de inmediato arrojando un error. Esto se debe a que el bloque estático se ejecuta cuando la clase se carga en memoria, un momento en el que todavía no existe ninguna instancia física de la cual leer información.
- **Regla de Oro:** Dentro de un bloque estático **únicamente se deben manejar variables y atributos declarados como `static`**.

---

### **3. Buenas Prácticas: Constantes de Configuración (`static final`)**

Para robustecer el diseño de nuestras clases de configuración, se aplican dos conceptos clave:

- **Uso de `final`:** Al declarar las variables de configuración como `final` (además de `static`), garantizamos que sus valores **no puedan ser reasignados ni modificados** a lo largo de la vida activa del programa, convirtiéndolas en constantes de configuración seguras e inmutables.
- **Estilo UPPER_CASE:** Por convenciones de código limpio (*Clean Code*), estas constantes de configuración se escriben en mayúsculas sostenidas.

---

## 💻 CÓDIGO FUENTE DE PRÁCTICA (`ConfigurationDB`)

Este ejercicio práctico modela una clase típica de configuración de base de datos utilizando atributos estáticos constantes, un bloque estático para su inicialización y un punto de entrada para verificar su ejecución:

```java
package configExample;

public class ConfigurationDB {
    // Atributos estáticos declarados como constantes (final) para configuración segura
    public static final String URL;
    public static final String USER;

    // 1. Bloque Estático: Se ejecuta automáticamente antes que el main
    static {
        USER = "admin"; 
        // Inicialización de constante
        URL = "jdbc:database_path"; 
        // URL de conexión simulada (no dar importancia a los valores reales por ahora)
        System.out.println("Configuración de Base de Datos cargada en memoria.");
    }

    // 2. Método Main: Punto de entrada ordinario del programa
    public static void main(String[] args) {
        System.out.println("-> Método Main: Iniciando ejecución...");

        // Accedemos directamente a los atributos estáticos sin necesidad de usar 'new'
        System.out.println("Conectando a: " + URL);
        System.out.println("Usuario activo: " + USER);
    }
}
```

#### **Salida en Consola Esperada:**

Al correr el programa anterior, notarás cómo el bloque estático se ejecuta antes de la primera instrucción del método `main`:

```java
Configuración de Base de Datos cargada en memoria.
Iniciando ejecución...
Conectando a: jdbc:database_path
Usuario activo: admin
```