package rest.api.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.api.concessionaria.entity.Veiculo;

import java.util.UUID;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
}
