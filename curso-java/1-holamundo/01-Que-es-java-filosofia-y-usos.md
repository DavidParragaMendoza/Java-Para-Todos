# 07 - ¿Qué es Java? Filosofía y Usos

## Concepto Principal
Java es un lenguaje de programación desarrollado por Sun Microsystems en 1995, cuya historia comenzó en 1991 con un equipo de 13 personas liderado por James Gosling en el proyecto denominado "Green Project". Su propósito original era ser adaptable para dispositivos como tarjetas inteligentes y sintonizadores de televisión. Inicialmente fue llamado "Oak" (en honor a un roble frente a la oficina de Gosling), pero debió ser renombrado al estar registrado como marca, eligiéndose "Java" por el café donde el equipo se reunía (en honor a la isla de Indonesia).

Java está inspirado en C++, tomando su base pero buscando superar sus complejidades para ofrecer un lenguaje más sencillo, portable y seguro. Su filosofía principal es **"Write Once, Run Anywhere"** (Escríbelo una vez y ejecútalo en cualquier lugar). 

El lenguaje fue lanzado públicamente en 1996 junto al navegador HotJava y los Applets, y en 1998 presentó Java Enterprise Edition para aplicaciones empresariales escalables (con Servlets y Enterprise JavaBeans). Es utilizado por empresas como Google, Amazon, Netflix y Spotify debido a su confiabilidad y capacidad para manejar grandes cargas de trabajo mediante frameworks y herramientas como Spring e Hibernate. Abarca áreas como Backend (servidores web, APIs Restful, servicios financieros, comercio electrónico), Mobile (aplicaciones móviles y juegos), Frontend (JavaFX, entornos web), Big Data (Apache Hadoop, Apache Kafka) y sistemas empresariales críticos (ERP, CRM).

Técnicamente, su independencia de plataforma funciona gracias a la Java Virtual Machine (JVM):
1. El programador escribe el código fuente en archivos `.java`.
2. El compilador de Java (`javac`) traduce el código fuente a un lenguaje intermedio llamado **bytecode** (archivos `.class`).
3. La JVM instalada en cada sistema operativo (Windows, Linux, macOS) toma este bytecode y lo ejecuta directamente sin necesidad de recompilar.

Otras dos características clave del lenguaje son:
- **Programación Orientada a Objetos:** Todo lo que se realiza en Java se basa en clases y objetos.
- **Fuertemente tipado:** Cada vez que se crea una variable, clase, objeto o lista, es obligatorio reservar espacio de memoria y especificar qué tipo de dato se va a almacenar.

## Sintaxis y Métodos Clave
*(En esta lección conceptual no se detalla código de programación de sintaxis ni métodos particulares, únicamente el comando del compilador y el flujo de archivos del sistema).*

### Flujo de Compilación y Ejecución
```text
Código fuente (.java) ──> [javac] ──> Bytecode (.class) ──> [JVM] ──> Ejecución en cualquier SO
```

- `javac`: Comando/compilador de Java que traduce el código fuente `.java` a código intermedio (`.class`).
- `.java`: Extensión del archivo de código fuente escrito por el desarrollador.
- `.class`: Archivo generado que contiene el bytecode entendible por la Java Virtual Machine.

## Buenas Prácticas y Puntos a Recordar
- **Principio "Write Once, Run Anywhere":** El código no requiere recompilación para cada sistema operativo; el compilador `javac` genera bytecode (`.class`) y la JVM específica de cada plataforma se encarga de ejecutarlo.
- **Tipado estricto:** Recordar siempre que es mandatorio definir el tipo de dato para cualquier variable, objeto o estructura antes de almacenar información en memoria.
- **Base orientada a objetos:** En Java todo componente fundamental se modela mediante clases y objetos.
- **Confiabilidad y robustez:** Diseñado para tolerar altas cargas de trabajo y aplicaciones empresariales de gran escala.
