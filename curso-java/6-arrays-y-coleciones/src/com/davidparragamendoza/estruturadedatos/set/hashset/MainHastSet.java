package com.davidparragamendoza.estruturadedatos.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class MainHastSet {
    static void main(String[] args) {
        // un set no tiene orden y tampoco acepta datos repetidos.
        Set<Integer>numeros = new HashSet<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        numeros.add(60);

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        numeros.add(60);

        System.out.println("numeros = " + numeros);

        numeros.remove(30);
        System.out.println("numeros = " + numeros);






    }

}
