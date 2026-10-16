package com.davidparragamendoza.exception.personalizada;

public class AgeValidation {
    public static void main(String[] args){
        Person person= null;
        try{
            person = Person.createPerson("Juan", 2);
            System.out.println(person.toString());

        }catch (AgeValidationException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Fin");
    }
}
