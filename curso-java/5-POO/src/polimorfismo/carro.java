package polimorfismo;

public class carro extends veiculo {
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

    //sobre escritura ocurre cuando una subclase redefine (reescribe el comportamiento de un metodo)
    @Override
    public void enceder() {
        System.out.println("El auto esta encendido y listo pa to");
    }


    @Override
    public String toString() {
        return "carro{" +
                "puertas=" + puertas +
                '}' + super.toString();
    }
}
