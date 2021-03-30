package com.example.listeplanetes;

public class Planet {
    private String nom;
    static String taille;

    public Planet(String nom, String taille) {
        this.nom = nom;
        this.taille = taille;
    }

    public String getNom(){
        return nom;
    }

    public static String getTaille(){
        return taille;
    }
}
