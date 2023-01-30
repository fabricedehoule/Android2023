package com.example.recyclerview;

public class Produit
{
    String nom, marque;
    double prix;

    public Produit(String nom, String marque, double prix) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }
}
