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
