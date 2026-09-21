## 📌 Relaciones entre Clases

En esta clase se explora un concepto fundamental del diseño de software orientado a objetos: **cómo se conectan, interactúan y dependen las clases entre sí**. Dependiendo de qué tan estrecho sea el vínculo y cómo se maneje el ciclo de vida de los objetos, Java clasifica estas conexiones en tres relaciones principales: **Dependencia, Asociación y Composición**.

---

### **1. Relación de Dependencia (Uso Temporal)**

La **dependencia** representa el tipo de relación más débil o acoplado de forma más ligera entre clases. Se produce cuando una clase necesita utilizar los servicios o métodos de otra clase únicamente de manera **temporal** para realizar una tarea específica.

- **Sintaxis típica:** La clase dependiente **no almacena** a la otra como un atributo de instancia. En su lugar, la recibe como un **parámetro dentro de uno de sus métodos**.
- **La Ventaja:** Si agregas nuevos métodos o cálculos a la clase proveedora, la clase dependiente los adquiere y puede utilizarlos de inmediato sin necesidad de duplicar código.

#### **Ejemplo Práctico de Dependencia en Código:**

Imagina que tenemos una clase `Calculator` y una clase `Person`. Para que la persona realice una suma, depende temporalmente de la calculadora:

```java
package relaciones;

public class Calculator {
    public int add(int numeroUno, int numeroDos){
        return numeroUno + numeroDos;
    }
}
```

```java
package relaciones;

public class Persona {

    public void calcularSuma(Calculator objCalculador){
        int resultado = objCalculador.add(5,3);

        System.out.println("Suma : "+ resultado);
    }
}
```

---

### **2. Relación de Asociación (Vínculo Débil)**

La **asociación** es una relación estructural donde una clase contiene a otra como un atributo, pero de manera **independiente**. Ambos objetos tienen **ciclos de vida totalmente desconectados**.

- **Independencia de Existencia:** Si el objeto contenedor se destruye, el objeto asociado **sigue existiendo sin ningún problema** en el sistema.
- **Ejemplo clásico:** La relación entre una **`House` (Casa)** y su **`Owner` (Propietario)**.
    - Una casa puede registrar un propietario en su base de datos como un atributo de clase.
    - Si la casa es demolida o eliminada físicamente de la memoria, el propietario no muere ni desaparece; simplemente queda libre para ser asociado a otra propiedad o seguir existiendo de forma autónoma.

---

### **3. Relación de Composición (Vínculo Fuerte)**

La **composición** es una relación de pertenencia muy estrecha y rígida ("una parte de"). Representa un acoplamiento donde una clase está **físicamente constituida** por otras clases secundarias que actúan como sus componentes esenciales.

- **Dependencia de Ciclo de Vida Absoluta:** Los objetos componentes **no pueden existir de forma independiente** fuera de la clase contenedora.
- **Destrucción en Cascada:** Al instanciar la clase contenedora, se crean también sus componentes. Si la clase principal se destruye o se elimina de la memoria, **todos sus componentes se destruyen automáticamente junto con ella**.
- **Ejemplo clásico:** La relación entre **`House` (Casa)** y sus componentes internos **`Room` (Habitaciones)** o **`Door` (Puertas)**.
    - Cuando aplicas el proceso de abstracción, comprendes que una casa está compuesta de forma obligatoria por paredes, puertas y habitaciones.
    - Una habitación específica (con sus medidas y distribución) pertenece únicamente a esa casa y no a otra. Si la casa es destruida, sus habitaciones y puertas dejan de existir en cascada.

---

### **Esquema Comparativo de Relaciones**

| Característica | Dependencia | Asociación | Composición |
| --- | --- | --- | --- |
| **Fuerza del Vínculo** | Muy Débil 🟢 | Débil / Medio 🟡 | Muy Fuerte 🔴 |
| **Estructuración** | Se pasa como parámetro en un método. | Se define como atributo de la clase. | Se define como atributo de la clase. |
| **Ciclo de Vida** | Temporal (solo dura la ejecución del método). | **Independiente:** Si la clase A se destruye, la clase B sobrevive. | **Co-dependiente:** Si la clase A se destruye, la clase B también muere. |
| **Analogía** | Una persona usando una herramienta temporalmente. | Una casa y su propietario. | Una casa y sus habitaciones/puertas. |

---

## 💻 CÓDIGO FUENTE DE MODELADO MULTI-RELACIÓN

El siguiente ejemplo simula de forma limpia cómo se estructuran la **Asociación** y la **Composición** dentro de una clase `House`, utilizando objetos complejos como atributos:

## Puerta.java

```java
package relaciones;

public class Puerta {
    private String material;

    public Puerta(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

```

## Cuarto.java

```java
package relaciones;

public class Cuarto {

    private String name;

    public Cuarto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

## Propietario.java:

```java
package relaciones;

public class Propietario {
    private String nombre;

    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

```

## Casa.java:

```java
package relaciones;

public class Casa {

    private Puerta objPuerta;
    private Cuarto objCuarto;
    private Propietario objPropietario;

    public Casa(Puerta objPuerta, Cuarto objCuarto, Propietario objPropietario) {
        this.objPuerta = objPuerta;
        this.objCuarto = objCuarto;
        this.objPropietario = objPropietario;
    }

    public Puerta getObjPuerta() {
        return objPuerta;
    }

    public void setObjPuerta(Puerta objPuerta) {
        this.objPuerta = objPuerta;
    }

    public Cuarto getObjCuarto() {
        return objCuarto;
    }

    public void setObjCuarto(Cuarto objCuarto) {
        this.objCuarto = objCuarto;
    }

    public Propietario getObjPropietario() {
        return objPropietario;
    }

    public void setObjPropietario(Propietario objPropietario) {
        this.objPropietario = objPropietario;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "objPuerta=" + objPuerta +
                ", objCuarto=" + objCuarto +
                ", objPropietario=" + objPropietario +
                '}';
    }
}

```

---