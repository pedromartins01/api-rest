package rest.api.concessionaria.service;

import org.springframework.stereotype.Service;
import rest.api.concessionaria.entity.Cliente;
import rest.api.concessionaria.entity.Veiculo;
import rest.api.concessionaria.exception.ConflitoException;
import rest.api.concessionaria.exception.DadosInvalidosException;
import rest.api.concessionaria.exception.RecursoNaoEncontradoException;
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
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
        if (dto.getVendido() && dto.getValorVenda() == null) {
            throw new DadosInvalidosException("Valor venda é obrigatório quando vendido for true");
        }
        if (this.veiculoRepository.existsByPlaca(dto.getPlaca())) {
            throw new ConflitoException("Placa já cadastrada");
        }
        Veiculo veiculo = new Veiculo(dto, cliente);
        this.veiculoRepository.save(veiculo);
    }
}
