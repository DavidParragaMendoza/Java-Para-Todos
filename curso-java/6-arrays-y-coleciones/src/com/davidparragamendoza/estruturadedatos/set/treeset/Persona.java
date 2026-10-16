package com.davidparragamendoza.estruturadedatos.set.treeset;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Persona implements Comparable<Persona> {
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
        Set<Persona>personas = new TreeSet<>();

        //Insert: Se declara los datos de los campos
        Persona persona1 = new Persona("Angela", "123");
        Persona persona2 = new Persona("David", "456");
        Persona persona3 = new Persona("David2", "456");
        Persona persona5 = new Persona("Angela2", "4564");

        //Se envia el insert a la tabla personas.
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona5);

        //Select: mostramos los datos guardados en la "tabla" persona.
        System.out.println("personas = " + personas);
        System.out.println("personas = " + personas.size());

        //Select con una condición
        for (Persona listapersonas: personas){
            if (listapersonas!=null){
                System.out.println(listapersonas.name);
            }

        }

        //Delete
        personas.remove(persona3);

        //Select
        System.out.println(personas);

        //update
        personas.add(persona3);
        System.out.println(personas);


        //buscar
        Persona personaABuscar = new Persona("Ronald", "08590");
        System.out.println("personas = " + personas.contains(personaABuscar));
    }

    @Override
    public int compareTo(Persona o) {
        return this.cedula.compareTo(o.cedula);
    }
}
