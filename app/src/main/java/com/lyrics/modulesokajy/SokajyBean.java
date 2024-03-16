package com.lyrics.modulesokajy;

public class SokajyBean {
    private String titre;
    private String nom;

    public SokajyBean(String titre, String nom) {
        this.titre = titre;
        this.nom = nom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
