package com.davidparragamendoza.estruturadedatos.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {

    static void main(String[] args) {
        //key - value
        Map<String, Integer> productoPrecio = new HashMap<>();

        //hash no respecta el orden
        productoPrecio.put("Laptop", 100);
        productoPrecio.put("Laptop", 99900);
        productoPrecio.put("Tablet", 200);
        productoPrecio.put("Telefono", 300);
        productoPrecio.put("TV", 400);

        System.out.println("productoPrecio = " + productoPrecio);

        //obtener un precio osea un valor

        System.out.println("productoPrecio.get(\"Laptop\") = " + productoPrecio.get("Laptop"));

        //actualizar
        System.out.println("productoPrecio.put(\"Tablet\", 12000) = " + productoPrecio.put("Tablet", 12000));

        System.out.println("productoPrecio = " + productoPrecio);
        
        //eliminar
        System.out.println("productoPrecio.remove(\"Laptop\") = " + productoPrecio.remove("Laptop"));


        System.out.println("productoPrecio = " + productoPrecio);

        
    }
}
