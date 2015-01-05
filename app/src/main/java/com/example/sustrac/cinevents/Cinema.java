package com.example.sustrac.cinevents;

public class Cinema {
    private String nom, adresse;
    private Long id;

    public Cinema(Long id, String nom, String adresse){
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Long getId() {
        return id;
    }
}
