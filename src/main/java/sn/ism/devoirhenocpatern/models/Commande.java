package sn.ism.devoirhenocpatern.models;

import java.time.LocalDate;

public class Commande {
    private LocalDate date;      // Attribut pour la date de la commande
    private Double montant;      // Attribut pour le montant de la commande
    private Client client;       // Attribut pour le client associé à la commande

    // Getter et Setter pour date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter et Setter pour montant
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    // Getter et Setter pour client
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
