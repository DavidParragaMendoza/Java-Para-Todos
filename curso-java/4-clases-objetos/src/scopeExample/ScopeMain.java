package scopeExample;

public class ScopeMain {
    static void main(String[] args) {
        // 1. Instanciamos la clase ScopeDemo (creamos el objeto en memoria)
        ScopeDemo demo = new ScopeDemo();

        // 2. Ejecutamos sus comportamientos públicos
        System.out.println("--- Ejecutando processData ---");
        demo.processData();

        System.out.println("\n--- Ejecutando anotherMethod ---");
        demo.anotherMethod();

    }
}
