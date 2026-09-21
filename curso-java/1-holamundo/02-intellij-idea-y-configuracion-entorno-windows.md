# 08 & 10: IntelliJ IDEA y Configuración del Entorno en Windows

## Concepto Principal
Para comenzar a trabajar con Java en el sistema operativo Windows, es necesario preparar el entorno mediante la instalación del IDE IntelliJ IDEA y la configuración de las variables de entorno del sistema:

1. **Descarga e Instalación de IntelliJ IDEA:**
   - En la página de descarga se presenta la versión Ultimate (de pago, con prueba de 30 días) y la versión que no requiere pago, la cual se descarga y utiliza directamente.
   - El proceso de instalación en Windows consiste en ejecutar el archivo descargado con permisos de confirmación, seguir los pasos estándar del instalador (`Next -> Next -> Install`) y esperar que concluya.
   - Al finalizar, se abre IntelliJ IDEA para verificar su correcto inicio y confirmar las pantallas iniciales requeridas.

2. **Configuración de Variables de Entorno en Windows:**
   - Se accede desde el menú buscando "variables de entorno" y abriendo "Editar las variables de entorno del sistema".
   - **Variable `JAVA_HOME`:** Se crea una nueva variable de entorno del sistema con el nombre `JAVA_HOME` (obligatoriamente en mayúsculas). Su valor corresponde a la ruta de instalación del JDK (por ejemplo, en `C:\Archivos de programa\Java\...`).
   - **Variable `Path`:** Se edita la variable del sistema existente llamada `Path`, añadiendo una nueva entrada con la ruta del JDK más la subcarpeta `\bin` (donde se encuentran las DLLs y herramientas funcionales del sistema).
   - Se guardan los cambios confirmando con "Aceptar".

## Sintaxis y Métodos Clave
*(Comandos de terminal y configuración de variables del sistema descritos en las lecciones).*

### Configuración de Variables del Sistema
- `JAVA_HOME`: `<Ruta_directorio_JDK>` (ruta raíz donde se encuentra instalado el JDK).
- `Path`: `<Ruta_directorio_JDK>\bin` (ruta hacia la carpeta bin que contiene los ejecutables y archivos DLL).

### Comandos de Verificación en Consola (`cmd`)
Para validar que Java y su compilador están correctamente configurados en el sistema operativo, se abre una nueva ventana de `cmd` y se ejecutan:

```bat
java -version
```
*Comprueba la versión instalada y confirma que la instalación de Java está operativa.*

```bat
javac -version
```
*Verifica que el comando `javac` esté disponible para la generación de bytecode.*

## Buenas Prácticas y Puntos a Recordar
- **Escritura en mayúsculas:** El nombre de la variable `JAVA_HOME` debe redactarse estrictamente en mayúsculas.
- **Diferencia de rutas:** `JAVA_HOME` apunta a la carpeta principal del JDK, mientras que en `Path` se debe apuntar a la subcarpeta `\bin`.
- **Nueva consola para validar:** Es necesario abrir una nueva ventana de `cmd` tras guardar las variables para que el sistema reconozca los cambios al ejecutar `java -version` y `javac -version`.
- **Validación del compilador:** No basta con validar `java`, se debe comprobar también `javac` para asegurar la capacidad de compilar código fuente a bytecode.
