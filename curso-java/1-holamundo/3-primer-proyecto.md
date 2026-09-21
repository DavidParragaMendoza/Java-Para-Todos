# 14: Primer Proyecto en Java

## Concepto Principal
Una vez configurado el JDK y las variables de entorno, se crea el primer proyecto en IntelliJ IDEA para familiarizarse con el entorno y la estructura de una aplicación de consola:

1. **Configuración y Creación del Proyecto en IntelliJ IDEA:**
   - En la sección *Projects* se selecciona **New Project**.
   - **Sistema de construcción (Build system):** Entre las opciones disponibles (*IntelliJ*, *Maven* y *Gradle*), se elige **IntelliJ**. Se explica que Maven y Gradle se utilizan para gestionar dependencias externas, las cuales no son necesarias en este proyecto inicial.
   - **Ubicación:** Se establece una carpeta contenedora en el Escritorio (*Desktop*) denominada `curso-java` para almacenar los proyectos del curso, definiendo el nombre del proyecto inicial (como `hello-world` / `1-holamundo`).
   - **Control de versiones:** La casilla *Create Git repository* se deja sin marcar por defecto.
   - **JDK:** Se vincula la versión instalada (JDK 23) y se finaliza con el botón *Create*.

2. **Estructura del Proyecto:**
   - El IDE genera automáticamente la estructura inicial compuesta por:
     - La carpeta principal del proyecto.
     - La carpeta `src` destinada al código fuente.
     - El archivo `Main.java` que contiene la clase `Main`.

3. **Punto de Entrada y Ejecución:**
   - **Clase `Main` y método `main`:** El método `main` es el punto de entrada fundamental de la aplicación. Todo el código que se ejecuta en una aplicación de consola en Java debe situarse dentro de este método principal; si no existe un método `main`, el proyecto no puede ejecutarse.
   - **Ejecución:** Se corre la aplicación directamente desde el IDE utilizando la opción *Run 'Main.main()'*, visualizando la salida ("hola mundo") en la consola integrada.

## Sintaxis y Métodos Clave
*(Estructura elemental de código y opciones de ejecución presentadas en la lección).*

### Estructura Mínima de una Aplicación de Consola
```java
public class Main {
    public static void main(String[] args) {
        // Todo lo que está dentro de este método principal es lo que se ejecuta
        System.out.println("hola mundo");
    }
}
```

### Opciones de Ejecución en IntelliJ IDEA
- **Run 'Main.main()':** Acción del IDE que compila y ejecuta el método principal de la clase, mostrando el resultado en la consola.

## Buenas Prácticas y Puntos a Recordar
- **Método `main` como punto de entrada:** Sin el método `main`, una aplicación de consola en Java no puede ser iniciada ni ejecutada.
- **Selección de Build System:** Para proyectos iniciales sin librerías externas, utilizar el sistema nativo de IntelliJ simplifica la estructura frente a herramientas como Maven o Gradle.
- **Gestión de proyectos en el IDE:** Quitar un proyecto de la lista reciente de IntelliJ no elimina los archivos físicos almacenados en el disco.
- **Organización de archivos:** Mantener todo el código fuente dentro del directorio `src` asignado por el proyecto.
