package com.mexpedition.dto;

public class ExpeditionDTO {
    private Long id;
    private int idCommande;
    private int etat;

    public ExpeditionDTO(Long id, int idCommande, int etat) {
        this.id = id;
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}