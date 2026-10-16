import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Integer[] numeros = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("numeros = " + numeros[9]);

        numeros[0]=11;
        System.out.println("numeros = " + numeros[0]);

        int[] numeros2 = new int[99];

        System.out.println("Dimension = " + numeros2.length);


        //Estrutura dinamicas:
        ArrayList<Integer> numeros3 = new ArrayList<>();

        numeros3.add(10);
        numeros3.add(22);

        System.out.println("numeros3 = " + numeros3);


    }
}
