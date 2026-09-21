package proyectoFinal;

import java.util.Scanner;

public class calcularNotas {
    static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        boolean repetir;

        do {
            System.out.println("Ingrese la Edad: ");
            int edad = cin.nextInt();

            System.out.println("Ingrese 3 calificaciones: ");
            System.out.println("NOTA 1: ");
            double nota1 = cin.nextInt();
            System.out.println("NOTA 2: ");
            double nota2 = cin.nextInt();
            System.out.println("NOTA 3: ");
            double nota3 = cin.nextInt();

            double suma = nota1 + nota2 + nota3;
            double promedio = suma/3.0;

            if (promedio>=6) {
                System.out.println("Aprobado " + "Edad: "+edad);
            }else{
                System.out.println("Desaprobado " + "Edad: "+edad);
            }

            System.out.println("¿Desea Repetir? (1 para si, 0 para no): ");
            int opcion = cin.nextInt();
            repetir = opcion ==1;

        }while (repetir);

        System.out.println("Programa Finalizado");
        cin.close();
    }
}
