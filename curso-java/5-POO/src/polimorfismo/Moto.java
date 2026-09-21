package polimorfismo;

public class Moto extends veiculo {
    private boolean hasSidercar;

    public Moto(String marca, String modelo, int year, boolean hasSidercar) {
        super(marca, modelo, year);
        this.hasSidercar = hasSidercar;
    }

    public void popWheelie(){
        System.out.println("Se esta haciendo el pendejo con la moto.");
    }

    @Override
    public String toString() {
        return "Moto{" +
                "hasSidercar=" + hasSidercar +
                '}' +  super.toString();
    }


    @Override
    public void enceder() {
        System.out.println("La moto esta encendida ");
    }
}
