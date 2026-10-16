package com.davidparragamendoza.exception.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiResourcesExample {
    public static void main(String[] args) {

        try(
                BufferedReader reader = new BufferedReader(new FileReader("src/example.txt"));
                BufferedReader reader2 = new BufferedReader(new FileReader("src/example2.txt"))

        ){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

            System.out.println("Reader 2");
            System.out.println("\n--- Contenido de example2.txt ---");
            while ((line = reader2.readLine()) != null) {
                System.out.println(line);
            }



        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado.");

        }catch (IOException e) {
            System.out.println("Error en la lectura del archivo.");

        }
    }

}
