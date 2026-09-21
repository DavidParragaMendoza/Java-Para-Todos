package com.davidparragamendoza.estruturadedatos.list.linkendlist;

import java.util.LinkedList;
import java.util.List;

public class Main {
    //lista doblemente enlazada.

    static void main(String[] args) {
        List<String>ciudades = new LinkedList<>();
        ciudades.add("Guayaquill");
        ciudades.add("Paris");
        ciudades.add("Libertad");
        ciudades.add("Santa Elena");
        ciudades.add("Pau Dos Ferros");

        //poner algo al principio
        ciudades.addFirst("Londres");
        ciudades.addLast("Berlin");

        System.out.println("ciudades = " + ciudades);

        System.out.println("ciudades.set(2, \"Madrid\") = " + ciudades.set(2, "Madrid"));
        System.out.println("ciudades.remove(\"Guayaquill\") = " + ciudades.remove("Guayaquill"));


        ciudades.removeFirst();
        ciudades.removeLast();

        String nombreCiudad = "Lima";
        if (ciudades.remove(nombreCiudad)){
            System.out.println("Esta En La Lista");
        }else{
            System.out.println("No Esta en la Lista");
        }

        //listar mediante un fore

        for (String ciudad: ciudades){
            System.out.println("- " + ciudad);
        }


    }
}
