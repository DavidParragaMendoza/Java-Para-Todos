package com.davidparragamendoza.estruturadedatos.set.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;

public class EjemploLinkedHahSet {

    static void main(String[] args) {
        Set<Integer>numero = new LinkedHashSet<>();

        numero.add(20);
        numero.add(10);
        numero.add(30);
        numero.add(40);
        numero.add(50);

        System.out.println(numero);

        numero.remove(30);
        System.out.println("numero = " + numero);

        numero.remove(50);
        numero.add(60);
        System.out.println("numero = " + numero);

        System.out.println("numero.contains(40) = " + numero.contains(40));
    }
}
