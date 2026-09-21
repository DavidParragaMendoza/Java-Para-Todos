package bucles;

public class Bucle {
    static void main(String[] args) {

        //bucle for - Para;

        /**
        for (int i = 0; i < 10; i++) {
            System.out.println("Valor: "+ i);

        }

        for (int i=2; i <=10; i+=2){
            System.out.println("Numero Par: "+i);
        }
         */

        //Buenas Practicas For

        final int NUMERO_MAXIMO = 10;

        for (int numeroActual = 1; numeroActual<=NUMERO_MAXIMO; numeroActual++){
            System.out.println("numeroActual = " + numeroActual);
        }


        // buble while - mientras

        /**
        int contador = 0;
        int acumulador = 0;
        while (contador < 5){
            System.out.println("contador = " + contador);

            acumulador = acumulador + contador;
            contador++;


        }
        System.out.println("acumulador = " + acumulador);

         */

        //do while - hacer mientas

        /**
        int contador2 = 1;
        do {
            System.out.println("contador2 = " + contador2);
            contador2++;
        }while (contador2<=10);

         */

    }
}
