package com.davidparragamendoza.estruturadedatos.list.arraylist;


import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> estudiantes = new ArrayList<>();
        //Agregar
        estudiantes.add("Ronald");
        estudiantes.add("David");
        estudiantes.add("Parraga");
        estudiantes.add("Mendoza");

        //Mostrar
        System.out.println("estudiantes = " + estudiantes);

        //Mostrar Segun el index
        System.out.println("estudiantes.get(0) = " + estudiantes.get(0));

        //Eliminar Segun el index
        System.out.println("estudiantes.remove(1) = " + estudiantes.remove(1));

        //Mostrar los cambios
        System.out.println("estudiantes = " + estudiantes);

        //Actualizar
        System.out.println("Nuevo estudiante Update = " + estudiantes.set(0, "Angela"));

        System.out.println("estudiantes = " + estudiantes);

        //Buscar
        System.out.println(estudiantes.contains("Angela"));

    }
}
