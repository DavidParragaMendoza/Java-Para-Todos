package herencia;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int year;

    public Vehiculo(String marca, String modelo, int year) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int anioActual = java.time.Year.now().getValue();

        if (year <1886 || year>anioActual+2){
            throw new IllegalArgumentException("Año Inválido!!");
        }

        this.year = year;
    }

    @Override
    public String toString() {
        return "AbstracciónEncapsulacion.Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", year=" + year +
                '}';
    }


    //Metodos Personalizados:
    public void enceder(){
        System.out.println("Encendio xd");
    }

    public void apagar(){
        System.out.println("se apago we xd");
    }
}
