package com.isep;

public class Main {
    public static void main(String[] args) {
        String pathfileVols = "projet_java_aeriennes\\src\\main\\resources\\Vols.csv";

        Vol.importVols(pathfileVols);
        System.out.println(Vol.getVols());
    }

    
}