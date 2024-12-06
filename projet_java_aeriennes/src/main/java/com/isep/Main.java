package com.isep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pathfileVols = "projet_java_aeriennes\\src\\main\\resources\\Vols.csv";

        importVols(pathfileVols);
    }

    public static ArrayList<Vol> importVols(String pathfileVols) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathfileVols))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return new ArrayList<Vol>(); // Placeholder return statement
    }
}