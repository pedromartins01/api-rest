package rest.api.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.api.concessionaria.entity.Cliente;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{
}
