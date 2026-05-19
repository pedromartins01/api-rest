package rest.api.concessionaria.service;

import org.springframework.stereotype.Service;
import rest.api.concessionaria.entity.Cliente;
import rest.api.concessionaria.entity.Veiculo;
import rest.api.concessionaria.model.VeiculoDTO;
import rest.api.concessionaria.repository.ClienteRepository;
import rest.api.concessionaria.repository.VeiculoRepository;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    private ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarVeiculo(VeiculoDTO dto) {
        Cliente cliente = this.clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Veiculo veiculo = new Veiculo(dto, cliente);
        this.veiculoRepository.save(veiculo);
    }
}
