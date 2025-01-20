package sn.ism.devoirhenocpatern.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ism.devoirhenocpatern.dto.ClientDTO;
import sn.ism.devoirhenocpatern.models.Client;
import sn.ism.devoirhenocpatern.models.Commande;
import sn.ism.devoirhenocpatern.repositories.ClientRepository;
import sn.ism.devoirhenocpatern.repositories.CommandeRepository;

import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommandeRepository commandeRepository;  // Déclarez le repository pour les commandes

    public ClientDTO createClientWithCommandes(Long id, ClientDTO clientDTO) {
        if (clientDTO.getCommandes() == null || clientDTO.getCommandes().isEmpty()) {
            throw new IllegalArgumentException("Un client doit avoir au moins une commande.");
        }
        if (clientRepository.existsByTelephone(clientDTO.getTelephone())) {
            throw new IllegalArgumentException("Le téléphone doit être unique.");
        }

        Client client = new Client();
        client.setNomComplet(clientDTO.getNomComplet());
        client.setTelephone(clientDTO.getTelephone());
        Client finalClient = client;
        client.setCommandes(clientDTO.getCommandes().stream().map(c -> {
            Commande commande = new Commande();
            commande.setDate(java.time.LocalDate.parse(c.getDate()));
            commande.setMontant(c.getMontant());
            commande.setClient(finalClient);
            return commande;
        }).collect(Collectors.toList()));

        client = clientRepository.save(client);

        clientDTO.setNomComplet(client.getNomComplet());
        return clientDTO;
    }

    public ClientDTO getClientWithCommandes(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client non trouvé."));
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNomComplet(client.getNomComplet());
        clientDTO.setTelephone(client.getTelephone());
        return clientDTO;
    }

    public Client createClient(Client client) {
        // Vérifier si le téléphone est unique
        if (clientRepository.existsByTelephone(client.getTelephone())) {
            throw new IllegalArgumentException("Le téléphone du client doit être unique.");
        }

        // Vérifier si le client a au moins une commande
        if (client.getCommandes() == null || client.getCommandes().isEmpty()) {
            throw new IllegalArgumentException("Un client doit avoir au moins une commande.");
        }

        // Sauvegarder le client d'abord
        client = clientRepository.save(client);

        // Associer et sauvegarder les commandes
        final Client finalClient = client; // Rendre 'client' effectivement final
        client.getCommandes().forEach(commande -> {
            commande.setClient(finalClient); // Utiliser finalClient dans la lambda
            commandeRepository.save(commande); // Sauvegarder chaque commande
        });

        return client;
    }

}
