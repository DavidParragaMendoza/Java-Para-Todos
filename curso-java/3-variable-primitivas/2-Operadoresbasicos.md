# 📌 Teoría - Operadores Básicos

Los operadores son símbolos especiales que permiten realizar cálculos, comparaciones, asignaciones y lógicas utilizando variables y constantes como materia prima. Se dividen en las siguientes categorías principales:

### **1. Operadores de Asignación**

Sirven para dar o actualizar el valor de una variable.

- **Asignación Simple (`=`):** Copia el valor de la derecha en la variable de la izquierda. Ejemplo: `int a = 10;`.
- **Asignación Compuesta (Acumuladores):** Ahorran código combinando una operación aritmética con una asignación:
    - `+=` (Suma y asigna): `a += 5` es equivalente a `a = a + 5`.
    - `-=` (Resta y asigna): `a -= 3` es equivalente a `a = a - 3`.
    - `*=` (Multiplica y asigna): `a *= 2` es equivalente a `a = a * 2`.
    - `/=` (Divide y asigna): `a /= 4` es equivalente a `a = a / 4`.
    - `%=` (Módulo y asigna): `a %= 3` es equivalente a `a = a % 3`.

---

### **2. Operadores Aritméticos**

Realizan operaciones matemáticas tradicionales:

- `+` (Suma),  (Resta),  (Multiplicación), `/` (División).
- `%` (Módulo): Devuelve el **resto o residuo de una división entera**. Muy útil en lógica de programación para evaluar divisibilidad (como números pares).

---

### **3. Operadores Relacionales**

Comparan dos valores y devuelven un resultado booleano (`true` o `false`):

- `==` (Igual a): `a == b` evalúa si son idénticos.
- `!=` (Distinto de): `a != b` evalúa si son diferentes.
- `>` (Mayor que) y `<` (Menor que).
- `>=` (Mayor o igual que) y `<=` (Menor o igual que).

---

### **4. Operadores Lógicos**

Permiten evaluar y combinar expresiones condicionales booleanas:

- **`&&` (AND lógico):** Devuelve `true` **solo si ambas** condiciones son verdaderas. Si una de ellas es falsa, todo es falso.
- **`||` (OR lógico):** Devuelve `true` si **al menos una** de las condiciones es verdadera. Solo devuelve `false` si ambas lo son.
- **`!` (NOT lógico / Negación):** Invierte el valor de verdad. Si una variable `flag` es `true`, `!flag` evalúa como `false`.

---

### **5. Operadores Unarios**

Se aplican sobre un **único operando**. Los más comunes son el incremento (`++`) y el decremento (`--`):

- **Signo negativo (-):** Invierte el signo matemático de una variable (ej: `int b = -a;` convierte un valor positivo en negativo).
- **Post-incremento/decremento (`c++` / `c--`):** Primero se lee o utiliza el valor actual de la variable en la expresión, y posteriormente se incrementa/decrementa en 1.
- **Pre-incremento/decremento (`++c` / `-c`):** Primero se realiza el incremento/decremento de forma inmediata, y luego se lee o utiliza el nuevo valor en la expresión.

---