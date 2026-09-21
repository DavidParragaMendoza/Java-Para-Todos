package herenciavscomposicion;

public class Main {
    public static void main(String[] args) {
        Veiculo miCarro = new Carro("marca1", "modelo1", 2024, 5);
        Veiculo miMoto = new Moto("miMarca", "miModelo", 2025, true);

        ((Carro)miCarro).enceder();
        ((Moto)miMoto).enceder();

        mostrarVeiculo(miCarro);
        mostrarVeiculo(miMoto);

        System.out.println("Cambiando numero de puertas");

        ((Carro)miCarro).setPuertas(20);


        mostrarVeiculo(miCarro);
    }


    public static void mostrarVeiculo(Veiculo miVeiculo) {
        System.out.println("miVeiculo = " + miVeiculo.toString());
    }
}
