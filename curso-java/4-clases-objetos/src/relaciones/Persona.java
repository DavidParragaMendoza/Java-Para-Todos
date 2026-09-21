package relaciones;

public class Persona {

    public void calcularSuma(Calculator objCalculador){
        int resultado = objCalculador.add(5,3);

        System.out.println("Suma : "+ resultado);
    }
}
