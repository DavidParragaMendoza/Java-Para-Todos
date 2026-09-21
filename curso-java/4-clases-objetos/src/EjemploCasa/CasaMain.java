package EjemploCasa;

public class CasaMain {

    static void main(String[] args) {
        Casa objCasa = new Casa();

        objCasa.setPuerta(2);
        objCasa.setVentana(10);
        objCasa.setTamano(130);

        Casa objCasa2 = new Casa(2, 3,6);

        System.out.println("La casa 1 Tienes estas carateristicas:");

        System.out.println("La cantidad de puertas de la casa es: "+ objCasa.getPuerta());

        objCasa.abrirPuerta();

        double area = objCasa.areaCasa();
        System.out.println("El area de la casa es: "+ area);

    }
}
