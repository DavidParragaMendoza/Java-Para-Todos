package com.davidparragamendoza.estruturadedatos.equals;

import java.util.Objects;

public class Persona {
    private String name;

    public Persona(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        //comparar si tiene la misma direcion de memoria.
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Persona objPersona = (Persona) o;
        return Objects.equals(name, objPersona.name);
    }


    static void main(String[] args) {
        Persona persona1 = new Persona("David");
        Persona persona2 = new Persona("Deyvi");
        System.out.println(persona1.equals(persona2));
    }
}
