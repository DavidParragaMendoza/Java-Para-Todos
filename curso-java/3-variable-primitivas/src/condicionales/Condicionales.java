package condicionales;

public class Condicionales {
    static void main(String[] args) {
        int edad = 19;
        double promedio = 7.5;

        boolean esAdulto = edad >=18;
        boolean estaAprovado = promedio >=7;

        if (esAdulto && estaAprovado) {
            System.out.println("El estudiante cumple con todos los requisitos");
        }

        if (!esAdulto) {
            System.out.println("NO Es un  adulto");
        }else{
            System.out.println("Es un adulto");
        }


        //Comentarios

        /*
        int dia = 0;

        switch (dia){
            case  1:
                System.out.println("Es Lunes");
                break;
            case 2:
                System.out.println("Es Martes");
                break;
            case 3:
                System.out.println("Es Miercoles");
                break;
            default:
                System.out.println("El dato ingresado no es valido");
        }
        */
    }
}
