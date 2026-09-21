package scanner;

import java.util.Scanner;

public class NumeroComparador {
    static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        System.out.println("Ingrese el primer Numero: ");
        int numeroUno = cin.nextInt();
        System.out.println("Ingrese el segundo Numero");
        int numeroDos = cin.nextInt();


        int suma =  numeroUno+numeroDos;
        int resta = numeroUno-numeroDos;
        int multiplicacion = numeroUno*numeroDos;

        System.out.println("RESULTADOS: ");
        System.out.println("La suma es: "+ suma);
        System.out.println("La resta es: "+ resta);
        System.out.println("La multiplicacion es: "+ multiplicacion);

        if(numeroUno>numeroDos){
            System.out.println("Numero 1 es mayor que numero dos");
        }else if(numeroUno == numeroDos){
            System.out.println("Los Numeros son iguales");
        }else{
            System.out.println("Numero 2 es mayor que numero uno");
        }

        System.out.println("Fin de la Aplicación...");

        cin.close();
    }

}
