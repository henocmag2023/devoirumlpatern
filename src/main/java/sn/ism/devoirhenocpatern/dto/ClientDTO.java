package sn.ism.devoirhenocpatern.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private String nomComplet;
    private String telephone;
    private List<CommandeDTO> commandes;
}
