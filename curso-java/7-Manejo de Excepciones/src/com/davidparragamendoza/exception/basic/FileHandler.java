package com.davidparragamendoza.exception.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    public static void main(String[] args){
        try{
            readFile("scr/example.txt");

        }catch(FileNotFoundException e){
            System.out.println("El archivo no fue encontrado");
        }catch(IOException error){
            System.out.println(error.getMessage());
        }
    }


    public static void readFile(String fileName) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        System.out.println("El archivo fue abierto con éxito");
        reader.close();
        
    }

}
