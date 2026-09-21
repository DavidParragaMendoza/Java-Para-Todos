package proyectofinal;

public class CarroElectrico extends Carro implements Electrico{
    private int nivelBateria;

    public CarroElectrico(String marca, String modelo, int año, TipoCarro tipo, int nivelBateria) {
        super(marca, modelo, año, tipo);
        this.nivelBateria = nivelBateria;
    }

    @Override
    public void start() {
        System.out.println("El auto Electrico esta encendido");
    }


    @Override
    public void cargaBateria() {
        nivelBateria = 100;
        System.out.println("La bateria esta cargada al 100%");
    }

    @Override
    public String toString() {
        return "CarroElectrico{" +
                "nivelBateria=" + nivelBateria +
                '}' + super.toString();
    }
}
