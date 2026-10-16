package com.davidparragamendoza.exception.autocloseable;

public class CustomResourceExample {
    static void main(String[] args) {
        try(FakeDataBaseConnection conexion = new FakeDataBaseConnection()){
            conexion.fetchData();
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());

        }


    }
}
