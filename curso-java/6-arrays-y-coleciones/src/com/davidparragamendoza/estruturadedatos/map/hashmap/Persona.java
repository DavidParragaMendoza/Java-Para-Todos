package com.davidparragamendoza.estruturadedatos.map.hashmap;

import java.util.*;

public class Persona{
    private String name;
    private String cedula;

    public Persona(String name, String cedula) {
        this.name = name;
        this.cedula = cedula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(cedula, persona.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cedula);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }

    static void main(String[] args) {
        //el set persona seria la tabla de la base de datos.
        Map<String, Persona> personas = new HashMap<>();

        //Insert: Se declara los datos de los campos
        Persona persona1 = new Persona("Angela", "123");
        Persona persona2 = new Persona("David", "456");
        Persona persona3 = new Persona("David2", "456");
        Persona persona5 = new Persona("Angela2", "4564");

        //Se envia el insert a la tabla personas.
        personas.put(persona1.cedula, persona1);
        personas.put(persona2.cedula, persona2);
        personas.put(persona3.cedula, persona3);
        personas.put(persona5.cedula, persona5);

        //Select: mostramos los datos guardados en la "tabla" persona.
        System.out.println("personas = " + personas);


        //Delete
        personas.remove(persona3.cedula);

        //Select
        System.out.println(personas);

        //update
        personas.put(persona3.cedula, new Persona("Gabi", "999"));
        System.out.println(personas);



    }


}
