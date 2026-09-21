## 📌 Proyecto Final (Integración de Conceptos)

En esta clase de cierre de sección se consolida todo el aprendizaje previo mediante el desarrollo de un programa práctico en consola. El propósito es estructurar una solución real integrando de manera simultánea variables, tipos de datos, captura por teclado, operaciones matemáticas, condicionales y lógica repetitiva.

### **1. Planteamiento y Requisitos del Problema**

El software a desarrollar debe cumplir con la siguiente secuencia lógica:

1. Solicitar y registrar la **edad** del usuario.
2. Solicitar el ingreso de **tres calificaciones**.
3. Realizar la sumatoria y calcular el **promedio** exacto de estas notas.
4. Evaluar el estado del estudiante: si el promedio obtenido es **mayor o igual a 6**, el sistema mostrará el mensaje **"Aprobado"**; de lo contrario, mostrará **"Desaprobado"**.
5. Permitir al usuario **repetir el proceso** completo para un nuevo estudiante tantas veces como desee antes de salir.

---

### **2. Arquitectura de Control y Lógica del Algoritmo**

- **El uso de `do-while` (Garantizar la ejecución):** Como requerimos que el programa capture obligatoriamente los datos de al menos un estudiante antes de preguntar si se desea repetir la operación, la estructura cíclica nativa ideal es el **`do-while`**.
- **Mecanismo de repetición dinámico:** Se declara una variable booleana `repeat`. Al final de cada iteración, el programa pregunta si se desean ingresar nuevos datos indicando al usuario ingresar `1 para Sí` o `0 para No`. Se captura esta respuesta en una variable entera `option`. Si el valor es `1`, la expresión relacional `option == 1` evalúa como **`true`**, manteniendo el bucle activo; cualquier otra entrada evalúa como **`false`**, rompiendo el ciclo y permitiendo la salida del programa.
- **Precisión en Decimales (`double` y `3.0`):** Al calcular el promedio, si se divide la sumatoria (un entero) entre el número entero `3`, Java realizará una truncación o división entera perdiendo los decimales. Para asegurar un cálculo exacto de tipo flotante doble precisión (`double`), la sumatoria se debe dividir explícitamente entre el literal decimal **`3.0`**.
- **Liberación formal de recursos (`close`):** Al finalizar por completo el bucle de repetición y antes de terminar la ejecución de la aplicación, es indispensable ejecutar **`scanner.close()`** para liberar los recursos del sistema de entrada asignados en memoria.

---

## 📌 CLASE #33: Código Fuente Completo (`GradeCalculator`)

A continuación, se detalla el código limpio, comentado y estructurado del archivo fuente final de la sección, aplicando las buenas prácticas de diseño y nomenclatura recomendadas:

```java
package proyectoFinal;

import java.util.Scanner;

public class calcularNotas {
    static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        boolean repetir;

        do {
            System.out.println("Ingrese la Edad: ");
            int edad = cin.nextInt();

            System.out.println("Ingrese 3 calificaciones: ");
            System.out.println("NOTA 1: ");
            double nota1 = cin.nextInt();
            System.out.println("NOTA 2: ");
            double nota2 = cin.nextInt();
            System.out.println("NOTA 3: ");
            double nota3 = cin.nextInt();

            double suma = nota1 + nota2 + nota3;
            double promedio = suma/3.0;

            if (promedio>=6) {
                System.out.println("Aprobado " + "Edad: "+edad);
            }else{
                System.out.println("Desaprobado " + "Edad: "+edad);
            }

            System.out.println("¿Desea Repetir? (1 para si, 0 para no): ");
            int opcion = cin.nextInt();
            repetir = opcion ==1;

        }while (repetir);

        System.out.println("Programa Finalizado");
        cin.close();
    }
}

```