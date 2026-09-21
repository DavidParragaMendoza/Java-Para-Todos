## 📌 El método `main()` - punto de entrada

En esta sesión se desmitifica y analiza a fondo la estructura del método más famoso de Java: **`public static void main(String[] args)`**. Aunque lo hemos utilizado desde el primer día para arrancar nuestros programas, ahora que dominamos el paradigma de objetos podemos comprender técnicamente por qué se declara con cada uno de sus modificadores y cómo se comporta dentro del flujo de la Máquina Virtual de Java (JVM).

---

### **1. Desglose Técnico de la Firma del Método**

Cada palabra clave en la declaración de este método cumple una función indispensable y obligatoria para que el sistema reconozca el punto de inicio de la aplicación:

- **`public` (Público):** Permite que la JVM acceda al método desde fuera del proyecto para iniciar la ejecución. Si fuera privado o tuviera nivel de paquete, la JVM no podría invocarlo y el programa fallaría al arrancar.
- **`static` (Estático):** Es el modificador crucial. Indica que el método pertenece a la clase y **no requiere que se cree una instancia u objeto de ella** en memoria para ser llamado.
- **`void` (Sin retorno):** Significa que el método no devuelve ningún dato al finalizar su ejecución. Simplemente ejecuta el bloque de código y termina.
- **`main` (Nombre):** Es el identificador exacto que la JVM busca por convención para iniciar el programa. No se puede usar otro nombre.
- **`String[] args` (Parámetros):** Es un arreglo de cadenas de texto (`String`) que permite recibir argumentos opcionales desde la consola al momento de iniciar la aplicación (parámetros de línea de comandos).

---

### **2. ¿Por qué el método `main` debe ser obligatoriamente `static`?**

Esta es una de las preguntas técnicas más habituales y tiene una explicación de arquitectura muy lógica:

- **Evitar la Instanciación Obligatoria:** Cuando inicias un programa de consola, la JVM busca y llama al método `main`. Si `main` no fuera estático, la JVM se vería obligada a crear primero una instancia (objeto) de tu clase principal (usando `new MainApp()`) para poder llamar al método.
- **Optimización de Pasos:** Al declarar `main` como `static`, la JVM puede saltarse por completo el paso de instanciación. Simplemente carga la clase en memoria y ejecuta `main` de forma directa, ahorrando tiempo y recursos físicos del sistema al arrancar la aplicación.

---

### **3. Acceso a Miembros (Métodos de Instancia vs. Estáticos)**

Debido a que el método `main` es un bloque estático por naturaleza, hereda las mismas restricciones que analizamos en los métodos estáticos:

- **Métodos Estáticos Auxiliares:** Si creas un método auxiliar estático dentro de la misma clase principal, puedes invocarlo directamente dentro de `main`.
- **Métodos de Instancia:** Si creas un método auxiliar de instancia (no estático), **no podrás llamarlo directamente**. Para usarlo dentro de `main`, estás obligado a instanciar la clase principal primero y luego llamarlo con el operador punto.

---

## 💻 CÓDIGO FUENTE DE PRÁCTICA (`MainApp`)

Este ejercicio práctico demuestra claramente las dos formas de invocar comportamientos (estáticos y de instancia) desde el método `main`:

```java
package entryPointExample;

public class MainApp {

    // 1. Método de Instancia (No estático)
    public void sayHelloInstance() {
        System.out.println("Soy un método de INSTANCIA. Requerí que un 'new'.");
    }

    // 2. Método de Clase (Estático)
    public static void sayHelloStatic() {
        System.out.println("Soy un método ESTÁTICO. Me ejecuté directo sin crear obj.");
    }

    // 3. El Método Main: Punto de Entrada de Ejecución
    public static void main(String[] args) {
        System.out.println("=== Arrancando la aplicación principal ===\n");

        // Caso A: Llamando a un método estático de la misma clase
        // Se puede llamar de forma directa porque 'main' también es estático
        sayHelloStatic();

        // Caso B: Intentando llamar a un método de instancia directo
        // sayHelloInstance(); 
        /* ❌ ERROR DE COMPILACIÓN: 
        No se puede llamar a un método no estático en un contexto estático.
        */
        
        // Solución para Caso B: Debemos instanciar la clase principal primero
        System.out.println("Instanciando la clase principal...");
        MainApp app = new MainApp(); // Creamos la instancia en memoria
        app.sayHelloInstance();      // Ahora sí es accesible
    }
}
```

---