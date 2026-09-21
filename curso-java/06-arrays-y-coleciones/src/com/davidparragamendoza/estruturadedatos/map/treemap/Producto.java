package com.davidparragamendoza.estruturadedatos.map.treemap;

import java.util.Map;
import java.util.TreeMap;

public class Producto implements Comparable<Producto>{
    private Integer id;
    private String name;

    public Producto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Producto o) {
        return Integer.compare(this.id, o.id);
    }

    static void main(String[] args) {
        Map<Producto, Double>precioMap = new TreeMap<>();

        precioMap.put(new Producto(1, "laptop"),10.0);
        precioMap.put(new Producto(2, "iphone"),20.0);
        precioMap.put(new Producto(3, "xiomi"),30.0);

        System.out.println("precioMap = " + precioMap);

        precioMap.remove(new Producto(3, "xiomi"));

        System.out.println("precioMap = " + precioMap);

        precioMap.put(new Producto(1, "laptop"), 121.0);

        System.out.println("precioMap = " + precioMap);

        System.out.println("precioMap.get(new Producto(2, \"iphone\")) = " + precioMap.get(new Producto(2, "iphone")));

    }




}
