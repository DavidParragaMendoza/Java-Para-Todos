## 📌 El contexto de las variables (*Scope*)

En esta clase se analiza un concepto fundamental de la programación que determina el ciclo de vida, la visibilidad y la accesibilidad de los datos en Java: el **contexto de las variables** o, técnicamente conocido en la industria como **`scope`** (alcance).

---

### **1. ¿Qué es el Contexto o *Scope*?**

- **Definición:** El `scope` define **el ámbito o región del código donde una variable ha sido declarada y es accesible**.
- **La Regla de Oro de las Llaves (`{ }`):** En Java, el contexto está delimitado de forma física por las **llaves**. Una variable vive y es reconocida únicamente **dentro de las llaves en las que fue creada (entre la llave que abre `{` y la que cierra `}`)**.

---

### **2. Los Tipos de Variables según su Contexto**

Java gestiona tres categorías de variables, cada una vinculada a un ámbito, visibilidad y ciclo de vida diferentes:

#### **A. Variables Locales**

- **Ubicación:** Se declaran **dentro de un método** o dentro de bloques específicos (como condicionales `if` o bucles `for` y `while`).
- **Visibilidad:** Son sumamente restrictivas. Solo su propio bloque (su "mundo") puede verlas o modificarlas. Si intentas llamar a una variable declarada dentro de un `if` desde fuera de ese `if` o desde otro método, el compilador arrojará un error indicando que la variable no existe.
- **Relación de Jerarquía (Superior a Inferior):** Todo lo que se declare en un contexto superior (como las variables locales de un método) será perfectamente visible para los bloques internos (como un `if` dentro de ese método). Sin embargo, **lo que se declara en un bloque interno nunca será visible para el contexto exterior**.
- **Ciclo de vida:** Existen **únicamente mientras se esté ejecutando el método o bloque** en el que se declararon. Al terminar la ejecución de dicho bloque, la memoria se libera de inmediato. *(Nota: Las variables locales del método `main` son una excepción relativa, ya que viven hasta que el programa finalice debido a que el `main` es el punto de entrada de la aplicación).*

#### **B. Variables de Instancia (Atributos)**

- **Ubicación:** Se definen dentro del cuerpo de la clase pero fuera de cualquier método.
- **Visibilidad:** Al estar declaradas en un contexto superior (la clase envuelve a todos los métodos), **son visibles y accesibles para todos los constructores y métodos de instancia** dentro de esa misma clase.
- **Asociación:** Están ligadas directamente a un objeto individual creado en memoria. Accedemos a ellas a través de la instancia (`objeto.getAtributo()`).
- **Ciclo de vida:** Viven en memoria **mientras la instancia u objeto del que forman parte siga existiendo** en el sistema.

#### **C. Variables de Clase (Variables Estáticas / `static`)**

- **Ubicación:** Se declaran en la clase utilizando la palabra reservada **`static`**.
- **Visibilidad:** No pertenecen a un objeto o instancia en particular, sino a la **clase en general**.
- **Compartición Global:** Es una única variable **compartida por todos los objetos creados a partir de ese mismo molde**. Si un objeto modifica el valor de una variable estática, el cambio se refleja inmediatamente en todos los demás objetos de esa clase. Un ejemplo común es utilizar una variable estática para contar cuántos objetos se van instanciando en el sistema.
- **Ciclo de vida:** Tienen el ciclo de vida más largo: **existen durante toda la vida activa del programa**.

---

### **💻 Caso Práctico Demostrativo: El Ámbito en Código**

A continuación, se presenta un ejemplo de código estructurado que ilustra cómo interactúan estos diferentes contextos y qué errores de compilación ocurrirían si se intenta romper las reglas de visibilidad:

```java
package scopeExample;

public class ScopeDemo {

    // 1. Variable de Instancia: Visible en toda la clase
    private double instanceValue = 100.0;

    public void processData() {
        // 2. Variable Local del método: Visible solo dentro de processData()
        int localVariable = 10;

        System.out.println("Acceso a variable de instancia: " + this.instanceValue); 
        // OK
        System.out.println("Acceso a variable local del método: " + localVariable); 
        // OK

        if (localVariable > 5) {
            // 3. Variable Local de Bloque: Solo existe dentro de este 'if'
            String blockMessage = "El número es mayor a 5";

            System.out.println(blockMessage); 
            // OK (Estamos dentro del bloque)
            System.out.println(localVariable); 
            // OK (El if puede ver variables del método superior)
        }

        // ❌ ERROR DE COMPILACIÓN:
        // System.out.println(blockMessage);
        // Explicación: blockMessage no existe aquí porque su ciclo de vida terminó al 
        //cerrarse la llave del 'if'.
    }

    public void anotherMethod() {
        // ❌ ERRORES DE COMPILACIÓN:
        // System.out.println(localVariable);
        // System.out.println(blockMessage);
        // Explicación: Ninguna de estas variables es visible en este método porque pertenecen a processData().

        System.out.println("Acceso a variable de instancia: " + this.instanceValue); // OK (Es un atributo de la clase)
    }
}
```

```java
package scopeExample;

public class ScopeMain {
    static void main(String[] args) {
        // 1. Instanciamos la clase ScopeDemo (creamos el objeto en memoria)
        ScopeDemo demo = new ScopeDemo();

        // 2. Ejecutamos sus comportamientos públicos
        System.out.println("--- Ejecutando processData ---");
        demo.processData();

        System.out.println("\n--- Ejecutando anotherMethod ---");
        demo.anotherMethod();

    }
}
```