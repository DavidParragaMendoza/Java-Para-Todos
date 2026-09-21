package herencia;


public class Main {

    public static void main(String[] args){
        Vehiculo vehiculo1 = new Vehiculo("carrito", "carito", 2026);

        vehiculo1.setYear(1808);

        System.out.println(vehiculo1.toString());

    }
}
