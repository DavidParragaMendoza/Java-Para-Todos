package proyectofinal;

public class Carro extends Vehiculo {
    private TipoCarro tipo;

    public Carro(String marca, String modelo, int año, TipoCarro tipo) {
        super(marca, modelo, año);
        this.tipo = tipo;
    }

    @Override
    public void start() {
        System.out.println("El auto arranco");
    }

    @Override
    public String toString() {
        return super.toString() +" tipox=" + tipo;
    }
}
