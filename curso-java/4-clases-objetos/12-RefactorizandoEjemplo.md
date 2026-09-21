## 📌 Refactorizando ejemplo final (Modularización y Reutilización)

En esta clase se aborda un proceso de **refactorización integral** aplicado a la aplicación práctica de consola que veníamos construyendo. El objetivo es aplicar los conceptos de la Programación Orientada a Objetos para resolver un problema común en el desarrollo de software: **el acoplamiento y el exceso de responsabilidades en una sola clase**.

---

### **1. El Problema de Diseño: El principio de Responsabilidad Única**

En el ejercicio anterior, la clase se llamaba `NumberComparer`. Sin embargo, al analizar el código detalladamente, se evidencian serias deficiencias de diseño:

- **Incoherencia en el Nombre:** La clase no solo comparaba números; también realizaba operaciones aritméticas de suma y resta, y gestionaba la captura de datos por teclado. El nombre de la clase quedaba muy corto y no representaba lo que realmente hacía.
- **Monolitismo:** Todo el flujo lógico estaba metido "a la fuerza" dentro del método `main`.
- **Violación de Responsabilidad:** Una buena clase debe hacer una sola cosa y hacerla bien. Para resolver esto, el código se divide en **métodos modulares independientes**.

---

### **2. La Solución: Creación de `SimpleCalculator`**

Se crea una clase mucho más adecuada llamada **`SimpleCalculator`**. En ella, el método `main` se limpia por completo para actuar únicamente como un **orquestador o coordinador**, delegando el trabajo pesado a tres métodos especializados que aprenderemos a diseñar:

#### **A. Método con Retorno y Parámetros Dinámicos: `getNumbers`**

En lugar de duplicar líneas de código para solicitar y capturar el primer número, y luego volver a repetir la misma estructura exacta para el segundo número, creamos un único método reutilizable:

- **Firma:** `public static int getNumbers(Scanner scanner, String message)`
- **Funcionamiento:** Recibe la instancia del `Scanner` activa y un texto personalizado (`message`) que servirá de prompt para el usuario. Solicita el número en consola, captura la entrada entera y la **retorna** utilizando la palabra clave **`return`**.
- **Ventaja:** Al invocarlo dos veces con distintos mensajes en el `main`, ahorramos código duplicado de forma masiva.

#### **B. Método de Acción sin Retorno: `printArithmeticOperations`**

- **Firma:** `public static void printArithmeticOperations(int firstNumber, int secondNumber)`
- **Funcionamiento:** Es de tipo **`void`** (no retorna nada). Recibe como parámetros de entrada los dos números previamente capturados por el scanner. Su única responsabilidad es calcular e imprimir en consola la suma y la resta correspondientes.

#### **C. Método de Evaluación Lógica: `compareNumber`**

- **Firma:** `public static void compareNumber(int first, int second)`
- **Funcionamiento:** Recibe los dos números y encapsula de forma aislada la estructura condicional (`if-else`) encargada de evaluar y mostrar cuál de los dos valores es mayor.

---

## 💻 CÓDIGO FUENTE REFACTORIZADO Y MODULAR

A continuación se detalla la estructura limpia y refactorizada del código completo de la clase, ideal para que lo estudies y comprendas cómo se comunican los métodos a través de parámetros y retornos:

```java
package ScannerExample;

import java.util.Scanner;

public class SimpleCalculator {
    public static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int primerNumero = getNumeros("Ingrese el primer numero");
        int segundoNumero = getNumeros("Ingrese el segundo numero");
        mostarOperacionArimetica(primerNumero, segundoNumero);
        compararNumero(primerNumero, segundoNumero);

    }

    public static int getNumeros(String mensaje) {
        System.out.println(mensaje);
        int numero = cin.nextInt();
        return numero;
    }

    public static void mostarOperacionArimetica(int primerNumero, int segundoNumero) {
        System.out.println("La suma de a + b = " + (primerNumero + segundoNumero));

        System.out.println("La diferencia entre a - b = " + (primerNumero - segundoNumero));
    }

    public static void compararNumero(int primerNumero, int segundoNumero) {
        if (primerNumero > segundoNumero) {
            System.out.println("El primer Numero es mayor");
        } else if (primerNumero == segundoNumero) {
            System.out.println("Los numero son iguales");
        } else {
            System.out.println("El segundo numero es mayor");

        }
    }
}

```

---