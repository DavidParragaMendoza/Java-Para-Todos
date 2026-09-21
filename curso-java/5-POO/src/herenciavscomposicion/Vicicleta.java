package herenciavscomposicion;

public class Vicicleta extends Veiculo{
    private boolean hasBell;

    public Vicicleta(String marca, String modelo, int year, boolean hasBell) {
        super(marca, modelo, year);
        this.hasBell = hasBell;
    }




}
