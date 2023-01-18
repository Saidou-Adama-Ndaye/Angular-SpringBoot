package com.tirage.springbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "etudiants")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "nom")
    private String nom;
    @Column(name = "email")
    private String email;

    public Etudiant() {
    }

    public Etudiant(String prenom, String nom, String email) {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
