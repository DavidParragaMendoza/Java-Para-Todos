# 📌Java y javac - Compila y ejecuta sin IDE (En Windows)

### **El Concepto Teórico Detrás del Proceso**

Antes de abrir la terminal, es fundamental entender qué ocurre bajo el capó:

1. **`javac` (El Compilador):** Es el comando encargado de traducir tu archivo legible por humanos (`.java`) a un lenguaje intermedio.
2. **Bytecode (`.class`):** Es el resultado de esa traducción. Es un formato binario estructurado y optimizado que solo la máquina virtual puede entender.
3. **`java` (La Máquina Virtual / JVM):** Es el comando que despierta a la JVM para que lea, interprete y ejecute las instrucciones contenidas en el Bytecode (`.class`).

---

### **Paso a Paso en Windows (Consola y Bloc de Notas)**

Para que este proceso funcione en la terminal de Windows, es un prerrequisito indispensable haber instalado el JDK y configurado correctamente las **variables de entorno en Windows** (`PATH`).

#### **Paso 1: Abrir la Consola de Comandos**

1. Presiona la tecla **`Windows`** en tu teclado.
2. Escribe **`cmd`** (Símbolo del sistema) o **`PowerShell`** y presiona **`Enter`**.

#### **Paso 2: Crear el directorio del proyecto**

En la consola de macOS se usa `touch` para crear archivos vacíos, pero en Windows el flujo nativo más rápido es el siguiente:

1. Crea una nueva carpeta para este ejercicio escribiendo:
    
    ```
    mkdir 02-bytecode
    ```
    
2. Entra a la carpeta recién creada:
    
    ```
    cd 02-bytecode
    ```
    

#### **Paso 3: Crear y editar el código con el Bloc de Notas**

En lugar del editor `nano` que se usa en sistemas basados en Unix, en Windows utilizaremos el **Bloc de Notas (Notepad)** directamente desde la consola:

1. Escribe el siguiente comando para crear y abrir el archivo:
*(Si Windows te pregunta si deseas crear un archivo nuevo, selecciona **Sí**).*
    
    ```
    notepad Main.java
    ```
    
2. En la ventana del Bloc de notas que se abre, escribe el código clásico de tu aplicación (recuerda que el nombre de la clase pública y el archivo físico deben coincidir de forma idéntica):
    
    ```java
    public class Main {
        public static void main(String[] args) {
            System.out.println("Hola Mundo desde la consola de Windows!");
        }
    }
    ```
    
3. Guarda los cambios presionando **`Ctrl + S`**  y cierra el Bloc de Notas.

#### **Paso 4: Generar el Bytecode (`javac`)**

Ahora que tienes el archivo físico `Main.java` guardado en tu carpeta:

1. En tu consola de comandos, ejecuta el compilador:
    
    ```
    javac Main.java
    ```
    
2. Si no aparece ningún mensaje de error, significa que la compilación fue exitosa.
3. Puedes comprobar que se ha creado el archivo binario intermedio listando los archivos con el comando `dir`. Verás que ahora existe un archivo llamado **`Main.class`**.

#### **Paso 5: Ejecutar la aplicación (`java`)**

Finalmente, pídele a la máquina virtual que ejecute tu Bytecode:

1. Escribe el comando de ejecución:
*(⚠️ **Importante:** No debes escribir la extensión `.class` al final del comando; la JVM busca automáticamente la clase por su nombre).*
    
    ```
    java Main
    ```
    
2. Verás inmediatamente el mensaje impreso en la terminal:
`Hola Mundo desde la consola de Windows!`

---

### **⚠️ Solución a problemas comunes en Windows**

- **Error: *" 'javac' o 'java' no se reconoce como un comando interno o externo..."***
Este es el error más común en Windows. Significa que tu sistema operativo no sabe dónde está instalado el compilador de Java. Para solucionarlo, debes asegurarte de que la ruta donde se instaló tu JDK (por ejemplo, `C:\Program Files\Java\jdk-23\bin`) esté agregada correctamente a la variable de entorno `Path` de tu sistema.

---