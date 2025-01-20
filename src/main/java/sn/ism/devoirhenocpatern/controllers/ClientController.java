package sn.ism.devoirhenocpatern.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ism.devoirhenocpatern.dto.ClientDTO;
import sn.ism.devoirhenocpatern.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/{id}/commandes")
    public ResponseEntity<ClientDTO> createClientWithCommandes(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.createClientWithCommandes(id, clientDTO));
    }

    @GetMapping("/{id}/commandes")
    public ResponseEntity<?> getClientWithCommandes(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientWithCommandes(id));
    }
}
