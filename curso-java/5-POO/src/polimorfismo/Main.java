package polimorfismo;


public class Main {

    public static void main(String[] args) {
        veiculo miCarro = new carro("marcaCarro", "modeloCarro", 2020, 3);
        veiculo miMoto = new Moto("marcaMoto", "modeloMoto", 2020, true);


        miCarro.enceder();
        miMoto.enceder();
        mostrarVeiculo(miMoto);
        mostrarVeiculo(miCarro);

        ((carro)miCarro).setPuertas(5);




    }


    public static void mostrarVeiculo(veiculo miVeiculo) {
      System.out.println("miVeiculo = " + miVeiculo.toString());
    }

}
