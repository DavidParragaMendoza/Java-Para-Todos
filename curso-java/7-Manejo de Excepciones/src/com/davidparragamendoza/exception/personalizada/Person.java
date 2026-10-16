package com.davidparragamendoza.exception.personalizada;

public class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.name = name;
        this.age = age;
    }

    public static Person createPerson(String name, Integer age) throws AgeValidationException {
        if(age<18){
            throw new AgeValidationException("Debes ser mayor de edad");
        }

        return new Person(age, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

