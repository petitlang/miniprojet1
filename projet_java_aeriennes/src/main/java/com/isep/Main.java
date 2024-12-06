package com.isep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String pathfileVols = "projet_java_aeriennes\\src\\main\\resources\\Vols.csv";

        importVols(pathfileVols);
    }

    public static ArrayList<Vol> importVols(String pathfileVols) {
        ArrayList<Vol> vols = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader reader = new BufferedReader(new FileReader(pathfileVols))) {
            String line;
            reader.readLine(); // 跳过第一行（假设是标题行）
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 6) {
                    try {
                        int numeroVol = Integer.parseInt(fields[0].trim());
                        String origine = fields[1].trim();
                        String destination = fields[2].trim();
                        Date dateHeureDepart = sdf.parse(fields[3].trim());
                        Date dateHeureArrivee = sdf.parse(fields[4].trim());
                        String Etat = fields[5].trim();

                        Vol vol = new Vol(numeroVol, origine, destination, dateHeureDepart, dateHeureArrivee, Etat);
                        vols.add(vol);
                    } catch (NumberFormatException | ParseException e) {
                        System.err.println("Ligne de résolution des erreurs : " + line + ", Erreur :" + e.getMessage());
                    }
                } else {
                    System.err.println("Erreur de formatage CSV, saut de lignes :" + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier :" + e.getMessage());
        }

        return vols;
    }
}