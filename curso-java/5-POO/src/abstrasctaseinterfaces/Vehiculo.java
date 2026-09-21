package abstrasctaseinterfaces;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;

    private Color color;
    private Estatus estatus;


    public Vehiculo(String marca, String modelo, int anio, Color color, Estatus estatus) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.estatus = estatus;
    }

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public abstract void drive();

    public void detener(){
        System.out.println("se apago we xd");
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {

        int anioActual = java.time.Year.now().getValue();

        if (anio <1886 || anio>anioActual+2){
            throw new IllegalArgumentException("Año Inválido!!");
        }

        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", color=" + color +
                ", estatus=" + estatus +
                '}';
    }
}
