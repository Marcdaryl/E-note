package com.example.e_notes;

public class NotesClasse {
    private String Nom;
    private String Prenom;
    private String Notes;

    public NotesClasse(String nom, String prenom, String notes) {
        Nom = nom;
        Prenom = prenom;
        Notes = notes;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
