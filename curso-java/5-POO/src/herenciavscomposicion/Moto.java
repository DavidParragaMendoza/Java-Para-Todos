package herenciavscomposicion;

public class Moto extends Veiculo {
    private boolean hasSidercar;
    private Motor mimotor;

    public Moto(String marca, String modelo, int year, boolean hasSidercar) {
        super(marca, modelo, year);
        this.hasSidercar = hasSidercar;
        this.mimotor = new Motor();
    }

    public boolean isHasSidercar() {
        return hasSidercar;
    }

    public void setHasSidercar(boolean hasSidercar) {
        this.hasSidercar = hasSidercar;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "hasSidercar=" + hasSidercar +
                '}' + super.toString();
    }

    public void enceder() {
        mimotor.enceder();
        System.out.println("La moto esta encendida we ");
    }
}
