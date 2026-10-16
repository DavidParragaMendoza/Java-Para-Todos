package com.davidparragamendoza.estruturadedatos.set.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Persona {
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
        Set<Persona>personas = new HashSet<>();

        //Insert: Se declara los datos de los campos
        Persona persona1 = new Persona("Angela", "123");
        Persona persona2 = new Persona("David", "456");
        Persona persona3 = new Persona("David2", "456");
        Persona persona4 = null;

        //Se envia el insert a la tabla personas.
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);

        //Select: mostramos los datos guardados en la "tabla" persona.
        System.out.println("personas = " + personas);

        //Select con una condición
        for (Persona listapersonas: personas){
            if (listapersonas!=null){
                System.out.println(listapersonas.name);
            }

        }

        //Delete
        personas.remove(persona4);


        //Select
        System.out.println(personas);

        //update
        personas.add(persona4);
        System.out.println(personas);

    }
}
