package com.davidparragamendoza.exception.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceExample {
    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader("src/example.txt"))) {
            System.out.println("El archivo se logro abrir ...");
            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado.");

        }catch (IOException e) {
            System.out.println("Error en la lectura del archivo.");;

        }
    }
}
