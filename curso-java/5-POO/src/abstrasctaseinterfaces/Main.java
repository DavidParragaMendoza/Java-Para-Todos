package abstrasctaseinterfaces;

public class Main {
    static void main(String[] args) {


        /*Vehiculo miVehiculo = new Vehiculo("marca", "modelo", 2002) {
            @Override
            public void drive() {
                System.out.println("El carro esta en marcha.xddd");
            }
        };

        System.out.println(miVehiculo.toString());
        miVehiculo.drive();
        */

        Vehiculo miEletrico = new ElectricCar("marca1", "modelo2", 2027, Color.AZUL, Estatus.HABILITADO, 89);

        System.out.println(miEletrico.toString());

    }
}
