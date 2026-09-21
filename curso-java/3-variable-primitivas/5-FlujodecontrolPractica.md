## 📌 Condicionales - `if` & `switch`

Los flujos condicionales permiten alterar la ejecución secuencial del código para tomar decisiones dinámicas basándose en si una condición lógica es verdadera o falsa.

### **1. Estructura `if` / `else if` / `else`**

El bloque **`if`** evalúa una condición booleana. Si se cumple, ejecuta el código interno; de lo contrario, puede evaluar nuevas condiciones con **`else if`** o ejecutar un bloque por defecto con **`else`**.

- **La regla del salto:** En el momento en que se cumple una condición dentro de una cadena de `if / else if`, Java ejecuta ese bloque específico y **salta directamente al final de la estructura**, ignorando por completo todas las demás evaluaciones restantes.

**Ejemplo de código:**

```java
package condicionales;

public class Condicionales {
    public static void main(String[] args) {
        int edad = 17; //

        if (edad > 18) {
            System.out.println("Es mayor de edad."); //
        } else if (edad <= 0) {
            System.out.println("La edad ingresada no es válida."); //
        } else {
            System.out.println("Es menor de edad."); //
        }
    }
}
```

---

### **2. Estructura `switch`**

Es una alternativa más limpia al uso excesivo de `else if` secuenciales cuando se necesita comparar una misma variable contra múltiples valores específicos.

- **Uso del `break`:** Cada caso (`case`) dentro de un `switch` requiere la palabra clave `break` al final. Si la omites, el programa continuará ejecutando los bloques de los casos siguientes de forma descendente, incluso si sus condiciones no coinciden.
- **El caso `default`:** Actúa como un respaldo por defecto (similar al `else`) y se ejecuta únicamente cuando el valor de la variable evaluada no coincide con ninguno de los casos especificados.

**Ejemplo de código:**

```java
int day = 3; 

switch (day) {
    case 1:
        System.out.println("Lunes");
        break; 
    case 2:
        System.out.println("Martes");
        break; 
    case 3:
        System.out.println("Miércoles");
        break; 
    default:
        System.out.println("El dato ingresado no es válido."); 
        break;
}
```

---

## 📌Buenas Prácticas - `if` (Clean Code)

Escribir condicionales correctos a nivel sintáctico no es suficiente; también es vital que el código sea legible y fácil de mantener a largo plazo.

### **1. Evitar Lógica Compleja en Línea (Inline)**

Cuando tienes múltiples condiciones combinadas con operadores lógicos (`&&` o `||`), escribir la ecuación entera directamente dentro del paréntesis del `if` hace que el código sea difícil de comprender y nada reutilizable. Si esa lógica cambia en el futuro, tendrás que buscar y modificar manualmente cada parte del sistema que la contenga.

- **Solución de Código Limpio:** Extrae la lógica condicional en **variables booleanas descriptivas**.

**Refactorización:**

```java
// ❌ Práctica deficiente o compleja:
if (age > 17 && average >= 7) { ... } //

//  Práctica recomendada (Clean Code):
boolean isAdult = age > 17; //
boolean hasPassingGrade = average >= 7; //

if (isAdult && hasPassingGrade) {
    System.out.println("El estudiante cumple con todos los requisitos."); //
}
```

### **2. Evitar Comparaciones Redundantes**

Dado que las variables de control ya son de tipo booleano (`true` o `false`), realizar una comparación explícita contra un literal booleano es redundante e innecesario.

- **Redundante:** `if (isAdult == true)`
- **Limpio:** `if (isAdult)`

### **3. Negación Limpia**

Para evaluar si un booleano es falso, se debe utilizar el operador de negación unario **`!`** delante de la variable, en lugar de compararlo contra `== false`.

- **Redundante:** `if (isAdult == false)`
- **Limpio:** `if (!isAdult)`

---

## 📌 Bucle - `for`

Los bucles permiten repetir un bloque de instrucciones de manera eficiente bajo un control lógico estricto. La estructura **`for`** es ideal cuando se conoce de antemano el número exacto de iteraciones que se desean realizar.

### **La Sintaxis del `for` (Sus tres partes críticas):**

Se compone de tres expresiones esenciales separadas por punto y coma dentro de sus paréntesis:

1. **Inicialización (`int i = 0`):** Establece el punto de partida y declara la variable de control que se utilizará para contar.
2. **Condición (`i < 5`):** Evalúa si el bucle debe continuar ejecutándose. Si se evalúa como `false`, el ciclo se rompe de inmediato.
3. **Contador / Incremento (`i++`):** Modifica la variable de control en cada vuelta. Su función principal es servir como el **"acercamiento a la condición de corte"** para evitar que el bucle se repita eternamente.

**Ejemplo de código:**

```java
package bucles;

public class Bucles {
    public static void main(String[] args) {
        // Cuenta e imprime los números pares del 2 al 4:
        for (int i = 2; i <= 5; i += 2) { //
            System.out.println("Contador par: " + i);
        }
        System.out.println("Bucle finalizado."); //
    }
}
```

---

## 📌 Bucles `while` y `do / while`

A diferencia del bucle `for`, estas estructuras se suelen utilizar cuando no se sabe con precisión cuántas veces se tendrá que repetir el bloque de código antes de finalizar.

### **1. Bucle `while` (Mientras)**

Evalúa la condición **antes** de ingresar al cuerpo del bucle. Si la condición es falsa desde el primer instante, el bloque de código interno jamás llegará a ejecutarse.

- **Control de bucle infinito:** Es mandatorio modificar manualmente el valor del contador o variable de evaluación dentro del bloque (por ejemplo, con `counter++`); de lo contrario, la condición nunca dejará de cumplirse y el programa fallará.

**Ejemplo con Acumulador:**
Un acumulador sirve para almacenar la suma progresiva de valores variables generados dentro de cada vuelta del ciclo.

```java
int counter = 0; // Inicialización previa obligatoria
int accumulator = 0; // Guarda la sumatoria acumulada

while (counter < 5) { // Condición de permanencia
    accumulator += counter; // Equivale a accumulator = accumulator + counter
    counter++; // Incremento manual para evitar bucle infinito
}
System.out.println("La sumatoria final es: " + accumulator); //
```

---

### **2. Bucle `do / while` (Hacer - Mientras)**

A diferencia de todos los demás bucles, la condición en el `do-while` se evalúa **al final** del bloque de instrucciones.

- **La gran diferencia:** **Se ejecuta obligatoriamente al menos una vez**, sin importar si la condición es falsa desde el principio.
- **Sintaxis crítica:** Es sumamente fácil olvidar colocar el **punto y coma `;`** al final del cierre del `while(...)`. Al ser una instrucción que finaliza en esa línea, es de carácter obligatorio para el compilador.

**Ejemplo de ejecución garantizada:**

```java
int counter2 = 30; //

do {
    System.out.println("Este mensaje se imprimirá aunque 30 no sea menor a 5: " + counter2); //
    counter2++; //
} while (counter2 < 5); // ⚠️ Requiere ';' al final
```

---

## 📌 Bucle `for` - Buenas Prácticas (Clean Code)

Esta clase nos enseña que aplicar refactorización a nuestras estructuras cíclicas ayuda a que nuestro código sea limpio y **se explique por sí mismo sin necesidad de comentarios excesivos**.

### **1. Dar Contexto a las Variables de Control**

El uso de la letra `i` como variable en los bucles `for` es sumamente popular, pero no aporta ningún tipo de significado en un sistema real. Es una mejor práctica renombrarla para darle un contexto legible dentro de tu algoritmo.

- *De:* `int i` ➡️ *A:* `int currentNumber`

### **2. Evitar Constantes Literales ("Números Mágicos")**

Escribir números fijos directamente en las condiciones de los bucles (como el `5` en `i < 5`) es una mala práctica conocida como usar constantes literales. Si necesitas cambiar ese límite en el futuro o reutilizarlo en otra parte, tu código no será adaptable.

- **Solución:** Declara una constante clara y descriptiva con la palabra clave `final`.

**Refactorización Completa:**

```java
// ❌ Código genérico con números mágicos:
for (int i = 1; i <= 5; i++) { ... }

//  Código Limpio (Self-explaining Code):
final int MAX_COUNT = 5; // Constante descriptiva

for (int currentNumber = 1; currentNumber <= MAX_COUNT; currentNumber++) { //
    System.out.println("Número actual: " + currentNumber);
}
```

---