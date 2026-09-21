package constantes;

public class PracticaConstante {
    static void main(String[] args) {
        /**
        variable
        int diasTrabajo = 10;
        diasTrabajo = 20;
        diasTrabajo = 30;

        //constante
        final double TASA_INTERES_ANUAL = 0.05;

        TASA_INTERES_ANUAL=1;
        */

        final double TASA_DE_IMPUESTOS = 0.10;
        int sueldoBruto = 3000;
        double sueldoNeto = 3000 * (1 - TASA_DE_IMPUESTOS);
        System.out.println("sueldoNeto = " + sueldoNeto);

    }






}
