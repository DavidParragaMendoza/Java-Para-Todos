package com.davidparragamendoza.exception.autocloseable;

public class FakeDataBaseConnection implements AutoCloseable  {

    public FakeDataBaseConnection() {
        System.out.println("Coneccion a la base de datos establecida");
    }

    public void fetchData(){
        System.out.println("Obteniendo informacion de la BD");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Conexion cerrada correctamente");

    }
}
