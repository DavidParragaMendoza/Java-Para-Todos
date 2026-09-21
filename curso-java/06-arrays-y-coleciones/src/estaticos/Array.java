package estaticos;

public class Array {
    static void main(String[] args) {
        int[] numbersPrimitive = {1,2,3,4,5,6,7,0,9};

        int deletePosition = 2;

        /*numbersPrimitive[0] = 10;
        numbersPrimitive[1] = 99;

        //forma de agrandar un array de forma "dinamica"

        int[] newNumeros = new int[numbersPrimitive.length + 1];

        System.arraycopy(numbersPrimitive, 0, newNumeros, 0, numbersPrimitive.length);
        newNumeros[5]=300;


        Integer[] numbersWrapper = new Integer[5];
        numbersWrapper[0] = 30;
        numbersWrapper[1] = null;

        System.out.println("Nuemros INt");
        for (int number : newNumeros) {
            System.out.println(number);
        }


        System.out.println("Numeros INTEGER");
        for (Integer number : numbersWrapper) {
            System.out.println(number);
        }*/

        for (int i= deletePosition; i <numbersPrimitive.length-1; i++){
            numbersPrimitive[i] = numbersPrimitive[i+1];
        }

        numbersPrimitive[numbersPrimitive.length-1]=0;

        numbersPrimitive[0]=1010101;

        for (int number: numbersPrimitive){
            System.out.println(number);
        }





    }
}

