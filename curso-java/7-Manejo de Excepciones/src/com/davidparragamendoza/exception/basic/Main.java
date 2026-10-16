package com.davidparragamendoza.exception.basic;

public class Main {
    public static void recursividad(){
        recursividad();
    }
    static void main(String[] args) {
        //Error: recursividad();

        //Excepciones:
        try {
            int resultado = 10/0;
            System.out.println("Resultado: " + resultado);
        }catch (ArithmeticException e){
            System.out.println("Division Por cero.");
        }finally {
            System.out.println("Este mensaje se ejecuta siempre.");
        }


    }

}
