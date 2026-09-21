package proyectofinal;

public class Main {

    public static void main(String[] args) {
        Vehiculo miVehiculo = new Carro("Fiat", "Duna", 2024, TipoCarro.ACECERA);
        Vehiculo miVehiculoElectrico = new CarroElectrico("Tesla", "modelo ultimate", 2026, TipoCarro.SPORTS, 20);

        miVehiculo.start();
        miVehiculoElectrico.start();

        ((CarroElectrico)miVehiculoElectrico).cargaBateria();
        System.out.println(miVehiculo);

        miVehiculo.start();
    }






}
