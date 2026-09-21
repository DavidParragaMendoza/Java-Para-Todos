## 📌 La clase String

En esta sesión se aborda de forma exhaustiva una de las clases más importantes, utilizadas y singulares de todo el ecosistema de Java: **la clase `String`**. Se analiza su funcionamiento interno en memoria, el concepto de inmutabilidad y cómo gestiona la máquina virtual de Java las cadenas de caracteres a través del **Pool de Strings**.

---

### **1. ¿Qué es la clase `String`?**

- **No es un tipo primitivo:** A diferencia de `int`, `double` o `char`, **`String` es una clase**. Representa una secuencia o cadena compleja de caracteres, una palabra, una frase o un párrafo completo.
- **La ilusión de primitivo:** Aunque para comodidad del desarrollador se declara e inicializa de manera muy similar a un dato primitivo (ej: `String name = "Gabriel";`), internamente es un **objeto**.
- **Funcionamiento interno:** Por debajo del capó, un `String` trabaja sobre el tipo primitivo `char` estructurado en forma de **arreglo o vector de caracteres**.
- **Equivalencia de la documentación:** Si accedes a la documentación oficial del lenguaje, verás que declarar una cadena literal equivale exactamente a definir un arreglo de caracteres e instanciarlo con el operador `new`:
    
    ```java
    // Esta declaración literal:
    String name = "Gabriel";
    
    // Equivale internamente a:
    char data[] = {'G', 'a', 'b', 'r', 'i', 'e', 'l'};
    String nameEquivalent = new String(data);
    ```
    
- Al estar soportado sobre una clase completa de la biblioteca estándar de Java, `String` nos provee de una inmensa gama de **atributos y métodos** prediseñados listos para procesar texto.

---

### **2. La Inmutabilidad de los Strings**

- **Definición:** Los objetos de tipo `String` son **estrictamente inmutables**. Esto significa que, una vez que se le asigna un valor a una variable de tipo `String` en memoria, **ese valor inicial no puede modificarse jamás**.
- **¿Qué pasa cuando modificamos un String?** Si aplicas un método que altera el texto (como convertirlo a mayúsculas con `.toUpperCase()`), **el `String` original permanece intacto**. Lo que hace Java es crear una **nueva instancia independiente en memoria** con el valor resultante.

#### **Demostración Práctica de Inmutabilidad:**

```java
String name = "Gabriel";
name.toUpperCase(); // ⚠️ Este método devuelve una NUEVA cadena, no modifica "name"

System.out.println(name); // Imprime "Gabriel" (Demuestra que es inmutable y no cambió)
```

Si deseas conservar el cambio, debes capturar la nueva instancia reasignándola a la variable o guardándola en otra variable de tipo `String`:

```java
String upperName = name.toUpperCase(); // Captura la nueva dirección de memoria generada
```

---

### **3. El Pool de Strings (String Pool) y la comparación con `==`**

El operador relacional de igualdad **`==`** en objetos no evalúa el contenido del texto, sino que **compara de manera estricta las direcciones físicas de memoria (referencias) de las variables**.

Para optimizar el uso de la memoria de la computadora y evitar duplicar cadenas de texto literales idénticas, Java implementa un mecanismo llamado el **Pool de Strings**.

#### **Caso A: Reutilización de Literales en el Pool**

```java
String name1 = "Gabriel";
String name2 = "Matías";
System.out.println(name1 == name2); // Devuelve 'false' (Tienen direcciones de memoria distintas)

name2 = "Gabriel"; // Reasignamos el literal
System.out.println(name1 == name2); // 🤯 Devuelve 'true'!
```

- **¿Por qué devuelve `true` si son dos variables diferentes?** Porque cuando asignas el literal `"Gabriel"` a `name2`, Java detecta que ese texto exacto ya existe guardado dentro de su **Pool de Strings**. En lugar de desperdiciar memoria creando otro objeto igual, **apunta la variable `name2` a la misma dirección física de memoria donde apunta `name1`**. Ambas apuntan al único dato físico `"Gabriel"` que existe en el pool.

#### **Caso B: Bypaseando el Pool con el Constructor (`new`)**

```java
String name1 = "Gabriel";
String name3 = new String("Gabriel"); // Forzamos la creación de un nuevo objeto

System.out.println(name1 == name3); // ❌ Devuelve 'false'!
```

- **¿Por qué devuelve `false` si ambos guardan "Gabriel"?** Porque al utilizar explícitamente el constructor con la palabra clave **`new`**, le estás ordenando a Java que **salte las optimizaciones del Pool de Strings** y reserve a la fuerza un nuevo espacio físico de memoria para un nuevo objeto fuera del pool. Al estar ubicados en bloques de memoria diferentes, la comparación física de sus referencias (`==`) evalúa como falsa.

<aside>
💡

**Regla de Oro:** Para comparar el **contenido** o texto real de dos Strings de forma segura sin importar su ubicación en memoria, nunca utilices `==`. Se debe utilizar de manera obligatoria el método **`.equals()`** (que se detalla en la siguiente clase).

</aside>

---

### **4. Vista Previa: Creación y el método `toString()`**

Al modelar clases de negocio (como una clase `Person` que contiene atributos `name` y `lastName`), es una excelente práctica autogenerar el método **`toString()`**.

- **¿Qué hace `toString()`?** Es un método que concatena y devuelve una representación en formato de texto (`String`) con el estado actual (los valores de los atributos) de la instancia del objeto. Esto permite imprimir la información del objeto directamente en consola para depuraciones rápidas.

---

## 💻 CÓDIGO FUENTE DE PRÁCTICA (`StringDemo`)

Crea y ejecuta este archivo dentro de tu IDE para ver el comportamiento del Pool de Strings e inmutabilidad en tiempo real:

```java
package stringExample;

public class StringDemo {
    public static void main(String[] args) {
        // 1. Demostración de Inmutabilidad
        String name = "Gabriel";
        name.toUpperCase();
        System.out.println("1. Inmutabilidad (original intacto): " + name); // Imprime "Gabriel"

        // 2. Comportamiento del String Pool (Literales iguales)
        String name1 = "Gabriel";
        String name2 = "Gabriel"; // Reutiliza la dirección del Pool
        System.out.println("2. Comparación de literales Pool (==): " + (name1 == name2)); // Imprime true

        // 3. Forzando objeto fuera del Pool con 'new'
        String name3 = new String("Gabriel");
        System.out.println("3. Comparación Pool vs New (==): " + (name1 == name3)); // Imprime false
    }
}
```

---

# Codigo Practica Creación de la clase Persona:

## Class Persona:

```java
package Strings;

public class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}

```

## Main: EjemploString.java

```java
package Strings;

import java.util.Locale;

public class EjemploString {

    static void main(String[] args) {
        Persona objP = new Persona("David", "Parraga");
        System.out.println(objP.toString());
    }
}

```