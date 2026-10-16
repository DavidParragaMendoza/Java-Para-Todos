package com.davidparragamendoza.estruturadedatos.map.treemap;

import java.util.Map;
import java.util.TreeMap;

public class EjemploTreeMap {
    static void main(String[] args) {
        //key - value
        Map<String, Integer> productoPrecio = new TreeMap<>();

        //TREE respecta el orden
        productoPrecio.put("Laptop", 100);
        productoPrecio.put("Tablet", 200);
        productoPrecio.put("Telefono", 300);
        productoPrecio.put("TV", 400);
        productoPrecio.put("Mouse", 320);
        productoPrecio.put("WASD", 430);

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
