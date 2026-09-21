package herencia;

public class carro extends Vehiculo {
    //atributos particulares de la clase.
    private int puertas;

    public carro(String marca, String modelo, int year, int puertas) {
        super(marca, modelo, year);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
}
