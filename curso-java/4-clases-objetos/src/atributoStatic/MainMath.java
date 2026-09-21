package atributoStatic;
//metodos estaticos
public class MainMath {
    static void main(String[] args) {
        /**
        int resultado = MathExample.add(2,2);

        System.out.println("Resultado suma= " + resultado);

        MathExample objMath = new MathExample();
        resultado = objMath.subtract(10, 4);
        System.out.println("Resultado resta = " + resultado);


        MathExample objMath2 = new MathExample();
        resultado = objMath.subtract(100, 4);
        System.out.println("Resultado resta 2 = " + resultado);
        */

        int resultado = MathExample.add(2,4);
        System.out.println("Suma 1 : "+ resultado);

        resultado = MathExample.subtract(180, 4);
        System.out.println("Resta 1 = " + resultado);

        resultado = MathExample.subtract(200, 100);
        System.out.println("Resta 2 = " + resultado);




    }
}
