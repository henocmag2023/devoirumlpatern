package sn.ism.devoirhenocpatern.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.devoirhenocpatern.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByTelephone(String telephone);
}
