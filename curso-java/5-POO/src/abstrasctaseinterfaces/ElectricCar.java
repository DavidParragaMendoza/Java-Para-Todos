package abstrasctaseinterfaces;

public class ElectricCar extends Vehiculo implements Electrico, AutoConducion{
    private int nivelBateria;

    public ElectricCar(String marca, String modelo, int anio, Color color, Estatus estatus, int nivelBateria) {
        super(marca, modelo, anio, color, estatus);
        this.nivelBateria = nivelBateria;
    }

    public ElectricCar(String marca, String modelo, int anio, int nivelBateria) {
        super(marca, modelo, anio);
        this.nivelBateria = nivelBateria;
    }

    @Override
    public void drive() {
        System.out.println("El carro electrico anda good xd");

    }

    @Override
    public void cargarBateria() {
        nivelBateria = MAXIMA_CARGA_BATERIA;
        System.out.println("La bateria esta cargada ");
    }

    @Override
    public void activarCopilot() {
        System.out.println("Modo Piloto Autimatico Activado");
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "nivelBateria=" + nivelBateria +
                '}' + super.toString();
    }
}
