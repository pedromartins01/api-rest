package rest.api.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.api.concessionaria.entity.Veiculo;

import java.util.List;
import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {

    boolean existsByPlaca(String placa);

    List<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByMarcaContainingIgnoreCase(String marca);
    List<Veiculo> findByModeloContainingIgnoreCase(String modelo);
}
