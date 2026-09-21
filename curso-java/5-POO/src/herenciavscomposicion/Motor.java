package herenciavscomposicion;

public class Motor {

    public void enceder(){
        System.out.println("El motor esta encendido.....");
    }


    //sobrecarga de metodos - Polimorfismo en tiempo de compilacion
    public void enceder(boolean modoSilencio){
        if (modoSilencio){
            System.out.println("Esta encendido en modo silecioso");
        }else{
            System.out.println("Encendio xd");
        }
    }

}
