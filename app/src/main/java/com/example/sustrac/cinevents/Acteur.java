package com.example.sustrac.cinevents;

public class Acteur {
    private String nom, prenom;
    private Long id;

    public Acteur(Long id, String nom, String prenom){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Long getId() {
        return id;
    }
}
