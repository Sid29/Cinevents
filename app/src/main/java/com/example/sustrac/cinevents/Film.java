package com.example.sustrac.cinevents;

public class Film {


    String titre, Description;
    Long id;

    public Film(Long id, String titre, String Description){
        this.titre = titre;
        this.Description = Description ;
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return Description;
    }

    public Long getId() {
        return id;
    }
}
