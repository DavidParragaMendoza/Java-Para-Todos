package ProyectoFinal;

public class Main {
    public static void main(String[] args) {
        CuentaBanco miCuentaBanco = new CuentaBanco("DaviD Parraga", 1200.49);
        BancoApp bancoApp = new BancoApp(miCuentaBanco);
        bancoApp.start();
    }

}
