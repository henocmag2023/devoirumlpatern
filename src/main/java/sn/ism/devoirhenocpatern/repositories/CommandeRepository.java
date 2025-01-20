package sn.ism.devoirhenocpatern.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.devoirhenocpatern.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
