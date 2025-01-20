package sn.ism.devoirhenocpatern.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ism.devoirhenocpatern.models.Commande;
import sn.ism.devoirhenocpatern.repositories.CommandeRepository;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    /**
     * Récupérer toutes les commandes.
     */
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    /**
     * Récupérer une commande par son ID.
     */
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Commande non trouvée."));
    }

    /**
     * Ajouter une nouvelle commande.
     */
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    /**
     * Mettre à jour une commande existante.
     */
    public Commande updateCommande(Long id, Commande updatedCommande) {
        Commande existingCommande = getCommandeById(id);
        existingCommande.setDate(updatedCommande.getDate());
        existingCommande.setMontant(updatedCommande.getMontant());
        return commandeRepository.save(existingCommande);
    }

    /**
     * Supprimer une commande par son ID.
     */
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
