package EjemploCasa;

public class Casa {
    //atributos

    //modificadores de acceso -> private
    private int puerta;
    private int ventana;
    private double tamano;

    //constructor vacio
    public Casa() {
    }

    //Construtor con parametros
    public Casa(int puerta, int ventana, double tamano) {
        this.puerta = puerta;
        this.ventana = ventana;
        this.tamano = tamano;
    }

    //getter y setter
    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    public int getVentana() {
        return ventana;
    }

    public void setVentana(int ventana) {
        this.ventana = ventana;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }


    //metodos..

    public void abrirPuerta(){
        System.out.println("La puerta esta abierta");
    }

    public double areaCasa(){
        return tamano * tamano;
    }

}
