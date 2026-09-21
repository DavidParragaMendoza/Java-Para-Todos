# ☕ Mi Viaje: Java — Explora el Lenguaje Desde Cero

¡Hola! 👋 Soy **David Parraga Mendoza**.  
Este repositorio es mi **"Jardín Digital"** 🌱 donde documento mi avance, prácticas y proyectos en el curso **[Java: Explora el lenguaje desde cero](https://www.udemy.com/course/devtalles-java/)** de **Udemy**.

Aquí no solo encontrarás el código fuente de los ejercicios y proyectos desarrollados en IntelliJ IDEA, sino también **mis notas conceptuales estructuradas** sobre cómo funciona Java "bajo el capó": el ciclo de compilación a Bytecode, la máquina virtual (JVM), la administración de memoria y los fundamentos sólidos del paradigma de Programación Orientada a Objetos (POO).

> *"Write Once, Run Anywhere"* — Principio fundacional de Java (James Gosling & Sun Microsystems).  
> *Aprender Java no se trata solo de memorizar sintaxis; es comprender cómo diseñar software fuertemente tipado, robusto y preparado para arquitectura empresarial.*

---

## 🚀 Progreso del Curso

| # | Sección | Clases | Estado |
|:-:|---------|:------:|:------:|
| 1 | **Sección 1: Introducción** | 4 / 4 | ✅ |
| 2 | **Sección 2: Primeros pasos en Java** | 11 / 11 | ✅ |
| 3 | **Sección 3: Fundamentos del lenguaje** | 19 / 19 | ✅ |
| 4 | **Sección 4: Clases y Objetos** | 20 / 20 | ✅ |
| 5 | **Sección 5: Programación Orientada a Objetos (POO)** | 15 / 15 | ✅ |
| 6 | **Sección 6: Estructuras de Datos y Colecciones** | 24 / 24 | ✅ |
| 7 | **Sección 7: Manejo de Excepciones** | 0 / 17 | ⏳ |
| 8 | **Sección 8: Manejo de JSON** | 0 / 15 | ⏳ |
| 9 | **Sección 9: Aplicación práctica con el patrón MVC** | 0 / 15 | ⏳ |
| 10 | **Sección 10: Bonus: Lombok** | 0 / 2 | ⏳ |
| 11 | **Sección 11: Fin del curso** | 0 / 1 | ⏳ |

---

## 📂 Estructura del Repositorio

Los proyectos están organizados por carpetas modulares dentro de `curso-java/`. Cada sección incluye el código fuente Java (`src/`) y sus apuntes teóricos:

```text
curso-java/
├── 1-holamundo/                # Sección 1 y 2: Introducción y Primeros pasos en Java
├── 2-bytecode/                 # Sección 2: Compilación con javac, JVM y archivos .class
├── 3-variable-primitivas/      # Sección 3: Fundamentos del lenguaje (Variables, control de flujo)
├── 4-clases-objetos/           # Sección 4: Clases y Objetos
├── 5-POO/                      # Sección 5: Programación Orientada a Objetos (POO)
├── 5-proyecto-final-seccion-5/ # Sección 5: Proyecto final integrador de POO
└── 06-arrays-y-coleciones/     # Sección 6: Estructuras de Datos y Colecciones
```

---

## 🧠 Aprendizajes Destacados

<details>
<summary><strong>☕ Sección 1 & 2 — Introducción y Primeros pasos en Java</strong></summary>

&nbsp;

Java no ejecuta el código fuente directamente en el sistema operativo ni lo interpreta línea por línea desde texto plano. Utiliza un modelo híbrido de **dos fases**:

```text
Código fuente (.java) ──> [javac] ──> Bytecode (.class) ──> [JVM] ──> Código Máquina (SO nativo)
```

| Componente | Rol en el Ecosistema |
|---|---|
| **`javac`** | Compilador de Java. Transforma el archivo legible humano (`.java`) en **Bytecode** intermedio (`.class`). |
| **Bytecode** | Instrucciones portables y optimizadas que no dependen de la arquitectura del procesador. |
| **JVM (Java Virtual Machine)** | La máquina virtual instalada en cada SO (Windows, Linux, macOS) que traduce el Bytecode a instrucciones de máquina nativas en tiempo real. |

> **Conclusión:** Gracias a la JVM, se cumple la premisa *"Escríbelo una vez, ejecútalo en cualquier lugar"*, garantizando portabilidad absoluta sin necesidad de recompilar para cada plataforma.

</details>

<details>
<summary><strong>🔢 Sección 3 — Fundamentos del lenguaje</strong></summary>

&nbsp;

Java es un lenguaje **fuertemente tipado**. Toda variable debe declarar su tipo de dato y reservar un espacio concreto de memoria antes de ser utilizada.

- **Primitivos vs. Clases Wrapper:**
  - *Primitivos:* Almacenan directamente el valor (`int`, `double`, `boolean`, `char`, `long`, `float`, `byte`, `short`). Viven comúnmente en la memoria **Stack**.
  - *Wrappers:* Envuelven al primitivo en un objeto (`Integer`, `Double`, `Boolean`). Permiten que los primitivos se comporten como objetos dentro de colecciones y métodos utilitarios.
- **Memoria Stack vs. Heap:**
  - **Stack:** Almacena llamadas a métodos, variables locales y referencias a objetos (rápida, limpia al salir del ámbito).
  - **Heap:** Almacena los objetos instanciados en tiempo de ejecución (`new`).
- **Estructuras de Control y Lectura:**
  - Bifurcaciones con `if`, `else if`, `else` y estructuras múltiples con `switch`.
  - Bucles iterativos: `while`, `do-while` y bucles `for` (tradicional y for-each).
  - Entrada de datos por consola con `java.util.Scanner`.

</details>

<details>
<summary><strong>🏗️ Sección 4 — Clases y Objetos</strong></summary>

&nbsp;

La clase representa el plano o molde (*blueprint*), mientras que el objeto es la instancia concreta viva en memoria Heap.

- **Constructores:** Métodos especiales para inicializar el estado del objeto. Se puede implementar **sobrecarga de constructores** (*overloading*) para admitir distintas formas de instanciación.
- **Modificadores de Acceso:**
  - `private`: Accesible únicamente dentro de la misma clase.
  - *Default (package-private)*: Accesible dentro del mismo paquete.
  - `protected`: Accesible dentro del paquete y por subclases vía herencia.
  - `public`: Accesible desde cualquier lugar del proyecto.
- **La palabra clave `static`:**
  - Indica que un atributo o método pertenece a la **clase en sí**, no a una instancia particular.
  - No requiere `new` para invocarse (ej. `Math.sqrt()` o métodos utilitarios).
- **Inmutabilidad y la clase `String`:**
  - En Java, los objetos `String` son **inmutables**.
  - Se gestionan en un área especial de memoria llamada **String Pool**, optimizando espacio al reutilizar cadenas con el mismo contenido literal.

</details>

<details>
<summary><strong>🏛️ Sección 5 — Programación Orientada a Objetos (POO)</strong></summary>

&nbsp;

El paradigma que sostiene la arquitectura de Java:

| Pilar | Concepto Clave | Aplicación en Java |
|---|---|---|
| **Abstracción** | Aislar las características y comportamientos esenciales de una entidad, ignorando detalles secundarios. | Definición de clases, métodos abstractos e interfaces. |
| **Encapsulamiento** | Ocultar el estado interno de un objeto para protegerlo contra modificaciones no autorizadas o inconsistentes. | Atributos marcados como `private` y acceso controlado mediante `getters` y `setters`. |
| **Herencia** | Reutilizar y extender la lógica de una superclase hacia subclases jerárquicas. | Uso de la palabra clave `extends` (herencia simple de clase). |
| **Polimorfismo** | Capacidad de un objeto o método de comportarse de múltiples formas según el contexto. | Sobrescritura (`@Override`), sobrecarga de métodos y polimorfismo de inclusión con interfaces/clases base. |

- **Herencia vs. Composición:**
  - *Herencia ("Es un"):* Acopla fuertemente la jerarquía.
  - *Composición ("Tiene un"):* Favorece el bajo acoplamiento y mayor flexibilidad arquitectónica.
- **Clases Abstractas vs. Interfaces:**
  - *Clase Abstracta:* No puede instanciarse; puede contener métodos abstractos y métodos con implementación, además de atributos de estado.
  - *Interfaz:* Define un contrato estricto de comportamiento (`implements`) que las clases deben cumplir.
- **La clase `enum`:** Tipos especiales para definir conjuntos cerrados de constantes fuertemente tipadas y seguras.

</details>

<details>
<summary><strong>📦 Sección 6 — Estructuras de Datos y Colecciones</strong></summary>

&nbsp;

Manejo de colecciones dinámicas mediante el **Java Collections Framework**:

| Colección | Implementaciones Clave | Características |
|---|---|---|
| **List** | `ArrayList`, `LinkedList` | Elementos ordenados, permite duplicados, acceso posicional e iteración con `Iterator` / `ListIterator`. |
| **Set** | `HashSet`, `LinkedHashSet`, `TreeSet` | Colección sin duplicados. `TreeSet` mantiene orden natural o por `Comparator`. |
| **Map** | `HashMap`, `TreeMap` | Estructura clave-valor (`Key-Value`). Claves únicas; `TreeMap` mantiene ordenado por clave. |

- **El contrato `equals()` y `hashCode()`:**
  - Fundamental para el correcto funcionamiento de colecciones como `HashSet` y `HashMap`.
  - Si dos objetos son iguales según `equals()`, **deben** retornar el mismo valor en `hashCode()`.

</details>

---

## 🛠️ Stack & Herramientas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Udemy](https://img.shields.io/badge/Udemy-A435F0?style=for-the-badge&logo=udemy&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Markdown](https://img.shields.io/badge/Markdown-000000?style=for-the-badge&logo=markdown&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

---

## 📫 Redes & Contacto

* 💼 **LinkedIn:** [David Parraga Mendoza](https://www.linkedin.com/in/davidparragamendoza/)
* 🐦 **X (Twitter):** [@DavidParragaMen](https://x.com/DavidParragaMen)
