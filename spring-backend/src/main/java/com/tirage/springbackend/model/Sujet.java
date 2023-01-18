package com.tirage.springbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sujet")
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private  String nom;

    public Sujet(String nom) {
        super();
        this.nom = nom;
    }

    public Sujet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
