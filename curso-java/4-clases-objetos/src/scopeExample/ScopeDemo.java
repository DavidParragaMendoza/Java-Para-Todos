package scopeExample;

public class ScopeDemo {
   // 1. Variable de Instancia: Visible en toda la clase
    private double instanceValue = 100.0;

    public void processData() {
        // 2. Variable Local del método: Visible solo dentro de processData()
        int localVariable = 10;

        System.out.println("Acceso a variable de instancia: " + this.instanceValue);
        // OK
        System.out.println("Acceso a variable local del método: " + localVariable);
        // OK

        if (localVariable > 5) {
            // 3. Variable Local de Bloque: Solo existe dentro de este 'if'
            String blockMessage = "El número es mayor a 5";

            System.out.println(blockMessage);
            // OK (Estamos dentro del bloque)
            System.out.println(localVariable);
            // OK (El if puede ver variables del método superior)
        }

        // ❌ ERROR DE COMPILACIÓN:
        // System.out.println(blockMessage);
        // Explicación: blockMessage no existe aquí porque su ciclo de vida terminó al
        //cerrarse la llave del 'if'.
    }

    public void anotherMethod() {
        // ❌ ERRORES DE COMPILACIÓN:
        // System.out.println(localVariable);
        // System.out.println(blockMessage);
        // Explicación: Ninguna de estas variables es visible en este método porque pertenecen a processData().

        System.out.println("Acceso a variable de instancia: " + this.instanceValue); // OK (Es un atributo de la clase)
    }
}