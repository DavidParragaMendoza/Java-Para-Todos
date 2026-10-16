package com.davidparragamendoza.estruturadedatos.set.treeset;

import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    static void main(String[] args) {
        Set<Integer> numero = new TreeSet<>();

        numero.add(50);
        numero.add(20);
        numero.add(40);
        numero.add(10);
        numero.add(30);
        numero.add(2);
        numero.add(2222);

        System.out.println(numero);

        numero.remove(30);
        System.out.println("numero = " + numero);

        numero.remove(50);
        numero.add(60);
        System.out.println("numero = " + numero);

        System.out.println("numero.contains(40) = " + numero.contains(40));

    }
}
