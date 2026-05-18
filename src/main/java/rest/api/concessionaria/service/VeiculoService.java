package rest.api.concessionaria.service;

import org.springframework.stereotype.Service;
import rest.api.concessionaria.entity.Veiculo;
import rest.api.concessionaria.repository.VeiculoRepository;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        this.veiculoRepository.save(veiculo);
    }
}
