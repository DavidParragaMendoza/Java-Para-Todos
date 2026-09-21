package relaciones;

public class Casa {

    private Puerta objPuerta;
    private Cuarto objCuarto;
    private Propietario objPropietario;

    public Casa(Puerta objPuerta, Cuarto objCuarto, Propietario objPropietario) {
        this.objPuerta = objPuerta;
        this.objCuarto = objCuarto;
        this.objPropietario = objPropietario;
    }

    public Puerta getObjPuerta() {
        return objPuerta;
    }

    public void setObjPuerta(Puerta objPuerta) {
        this.objPuerta = objPuerta;
    }

    public Cuarto getObjCuarto() {
        return objCuarto;
    }

    public void setObjCuarto(Cuarto objCuarto) {
        this.objCuarto = objCuarto;
    }

    public Propietario getObjPropietario() {
        return objPropietario;
    }

    public void setObjPropietario(Propietario objPropietario) {
        this.objPropietario = objPropietario;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "objPuerta=" + objPuerta +
                ", objCuarto=" + objCuarto +
                ", objPropietario=" + objPropietario +
                '}';
    }
}
