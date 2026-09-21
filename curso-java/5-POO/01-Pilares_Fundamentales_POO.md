# 01 - Pilares Fundamentales de la POO

## 📌 Introducción y Filosofía de la POO en Java

Java es un lenguaje fundamentalmente orientado a objetos. En este paradigma, **todo se modela y organiza a través de clases y objetos**:
- Los datos, estructuras y operaciones se encapsulan dentro de clases y objetos como unidad básica de código.
- Los métodos y atributos pertenecen estrictamente a clases u objetos.
- La memoria y el comportamiento de un programa se definen a través de la interacción directa entre objetos.

> [!NOTE]
> **¿Por qué se dice que Java es un 99% orientado a objetos?**
> La existencia de los tipos de datos primitivos (`int`, `boolean`, `double`, etc.) hace que técnicamente no sea 100% puro. Para solucionar esto y permitir que los tipos primitivos puedan ser tratados como objetos, Java provee las **clases wrapper** (`Integer`, `Boolean`, `Double`, etc.).

---

## 🏛️ Los Cuatro Pilares de la Programación Orientada a Objetos

### **1. Abstracción**
- Es el proceso de selección y filtrado donde se determinan cuáles atributos y métodos son esenciales para modelar un objeto en función de las necesidades del sistema.
- Permite separar las características relevantes de las prescindibles:
  - Por ejemplo, modelar un vehículo para un videojuego requiere atributos distintos que modelarlo para el sistema de ventas de una concesionaria.
  - A partir de este análisis abstracto, se estructura la clase y su comportamiento en código.

### **2. Encapsulamiento**
- Consiste en agrupar los datos (atributos) y los métodos que operan sobre ellos dentro de una misma clase, **restringiendo el acceso directo** a los atributos desde el exterior.
- Se apoya en los modificadores de acceso (`private`, `protected`, `public`):
  - Los atributos se declaran como `private` para impedir que sean alterados o leídos libremente mediante la sintaxis de punto directo (`objeto.atributo`).
  - El acceso se centraliza y controla a través de métodos públicos:
    - Métodos **`getter`** (ej. `getBrand()`): retornan el valor de manera controlada.
    - Métodos **`setter`** (ej. `setBrand()`): permiten asignar o validar nuevos valores antes de modificar el estado interno.

> [!IMPORTANT]
> El objetivo del encapsulamiento es proteger el estado interno del objeto y asegurar que cualquier cambio pase por la lógica definida en la propia clase.

### **3. Herencia**
- Permite crear nuevas clases (**subclases**) basadas en clases de nivel superior (**superclases**), heredando sus atributos y comportamientos.
- **¿Cuándo se utiliza?** Cuando varias clases comparten atributos y métodos comunes (ej. camión, automóvil y motocicleta comparten modelo, año y marca como vehículos).
- Se implementa mediante la palabra clave **`extends`**:
  - La superclase actúa como plantilla general (`Vehiculo`).
  - Las subclases (`Car`, `Motorcycle`) heredan los miembros comunes y agregan sus propios atributos y métodos específicos.
  - Para reutilizar la inicialización de la superclase, el constructor de la subclase invoca al constructor superior mediante **`super()`**.

### **4. Polimorfismo**
- Permite que distintas clases derivadas de una misma jerarquía sean tratadas de manera uniforme a través de un tipo común (superclase o interfaz).
- **Flexibilidad de tipado:** En lugar de atar un método a recibir una clase concreta como `Car`, se puede declarar que reciba el tipo general `Vehiculo`. Así, el método puede operar sobre cualquier vehículo (`Car`, motocicleta, etc.).
- Incluye dos conceptos esenciales:
  - **Sobreescritura de métodos (Override):** Posibilidad de que una subclase redefina las instrucciones de un método heredado (ej. el método `start()` de encendido no funciona igual en un auto que en una moto).
  - **Sobrecarga de métodos (Overload):** Métodos que comparten el mismo nombre pero difieren en la cantidad o tipos de parámetros recibidos (como ocurre comúnmente en los constructores).

---

## 🎯 Ventajas Significativas de la POO

- **Reutilización de código:** A través de la herencia y componentes reutilizables sin necesidad de duplicar lógica.
- **Extensibilidad:** Capacidad de extender funcionalidades mediante sobreescritura y sobrecarga sin alterar el código base existente.
- **Modelado natural:** Permite conceptualizar el software como un conjunto de objetos que interactúan de forma análoga al mundo real.
- **Modularidad y mantenimiento:** Centraliza datos y comportamientos en entidades independientes, facilitando la detección de fallos y la evolución del sistema.
