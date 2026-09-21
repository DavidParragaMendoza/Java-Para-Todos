package BlockStatic;

public class ConfiguracionBD {

    static final String URL;
    static final String USER;

    static {
        URL = "localhost:8000";
        USER = "admin";
        System.out.println("Configuracion completada");

    }

    static void main(String[] args) {
        System.out.println("USER = " + USER);
        System.out.println("URL = " + URL);
    }
}
