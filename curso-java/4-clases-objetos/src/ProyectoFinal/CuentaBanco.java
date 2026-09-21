package ProyectoFinal;

public class CuentaBanco {
    private String nombreCuenta;
    private double saldoCuenta;

    public CuentaBanco(String nombreCuenta, double saldoCuenta) {
        this.nombreCuenta = nombreCuenta;
        this.saldoCuenta = saldoCuenta;
    }

    public void deposito(double monto){
        if(monto>0){
            saldoCuenta += monto;
            System.out.println("Deposito Exitoso");
        }else{
            System.out.println("El monto no es correcto..");
        }

    }

    public void retiro(double monto){
        if (monto>0  && monto<=saldoCuenta){
            saldoCuenta-=monto;
            System.out.println("Retiro Exitoso");
        }else{
            System.out.println("Fondos insuficientes o mondo invalido. ");
        }
    }

    public void mostrarCuenta(){
        System.out.println("Saldo de la cuenta: " + saldoCuenta);
    }
}
