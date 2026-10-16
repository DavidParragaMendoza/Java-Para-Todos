package com.davidparragamendoza.estruturadedatos.iteradores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjemploIteradores {
    static void main(String[] args) {
        List<String>nombres = new ArrayList<>();
        nombres.add("ARonald");
        nombres.add("David");
        nombres.add("Párraga");
        nombres.add("CMendoza");

        for (String nombre: nombres){
            if (nombre.startsWith("A") || nombre.startsWith("C")){
                nombres.remove(nombre);
            }
        }

        Iterator<String>iterador = nombres.iterator();
        while (iterador.hasNext()){
            String nombre = iterador.next();
            if (nombre.startsWith("P")){
                iterador.remove();
            }
        }

        System.out.println(nombres);
    }
}
