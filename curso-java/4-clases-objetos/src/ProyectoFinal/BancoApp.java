package ProyectoFinal;

import java.util.Scanner;

public class BancoApp {
    private Scanner cin;
    private CuentaBanco cuentaBanco;

    public BancoApp(CuentaBanco cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
        this.cin = new Scanner(System.in);
    }

    public void start() {
        int opcionSelecionada;
        do {
            menu();
            opcionSelecionada = leerOpcion(); // Usamos el nuevo método aquí
            opciones(opcionSelecionada);
        } while (opcionSelecionada != 4);
    }

    private void menu() {
        System.out.println("\nSeleccionar opciones");
        System.out.println("1. Depositar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Mostar Saldo");
        System.out.println("4. Salir");
    }

    // Nuevo método creado con nombre en español
    private int leerOpcion() {
        return cin.nextInt();
    }

    private void opciones(int opcion) {
        switch (opcion) {
            case 1 -> hacerDeposito();
            case 2 -> hacerRetiro();
            case 3 -> {
                cuentaBanco.mostrarCuenta();
            }
            case 4 -> {
                System.out.println("Gracias Por utilizar la APP");
            }
            default -> {
                System.out.println("Opcion Incorrecta");
            }
        }
    }

    private void hacerDeposito() {
        System.out.println("Ingrese el monto a depositar");
        double montoDepositado = cin.nextDouble();
        cuentaBanco.deposito(montoDepositado);
    }

    private void hacerRetiro() {
        System.out.println("Ingrese el monto a retirar");
        double montoRetirar = cin.nextDouble();
        cuentaBanco.retiro(montoRetirar);
    }
}