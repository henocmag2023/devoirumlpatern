package sn.ism.devoirhenocpatern.models;

import java.util.List;

public class Client {
    private String nomComplet;  // Attribut pour le nom complet du client
    private String telephone;   // Attribut pour le téléphone du client
    private List<Commande> commandes;  // Attribut pour les commandes du client

    // Getter et Setter pour nomComplet
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    // Getter et Setter pour telephone
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Getter et Setter pour commandes
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
