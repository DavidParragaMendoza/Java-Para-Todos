package PuntoDeEntreda;

public class MainApp {
    public void mensaje1(){
        System.out.println("Hola mundo");
    }

    public static void mensaje2(){
        System.out.println("mensaje2: Hello world");
    }

    public static void main(String[] args) {
        System.out.println("=== Arrancando la aplicación principal ===\n");

        mensaje2();

        System.out.println("Instaciando la clase principal.. ");
        MainApp miapp = new MainApp();
        miapp.mensaje1();

    }
}
