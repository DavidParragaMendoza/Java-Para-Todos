package herenciavscomposicion;

public class Carro extends Veiculo{
    private int puertas;
    private Motor miMotor;

    public Carro(String marca, String modelo, int year, int puertas) {
        super(marca, modelo, year);
        this.puertas = puertas;
        this.miMotor = new Motor();
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "puertas=" + puertas +
                '}' + super.toString();
    }

    public void enceder() {
        miMotor.enceder();
        System.out.println("El auto esta encendido y listo pa to");
    }
}
