package rest.api.concessionaria.service;

import org.springframework.stereotype.Service;
import rest.api.concessionaria.entity.Cliente;
import rest.api.concessionaria.entity.Veiculo;
import rest.api.concessionaria.exception.ConflitoException;
import rest.api.concessionaria.exception.DadosInvalidosException;
import rest.api.concessionaria.exception.RecursoNaoEncontradoException;
import rest.api.concessionaria.model.VeiculoDTO;
import rest.api.concessionaria.model.VeiculoInput;
import rest.api.concessionaria.model.VeiculoUpdateInput;
import rest.api.concessionaria.repository.ClienteRepository;
import rest.api.concessionaria.repository.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    private ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarVeiculo(VeiculoInput dto) {
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

    public List<VeiculoDTO> buscarVeiculos(String placa, String marca, String modelo) {
        List<Veiculo> veiculos;

        if (placa != null) {
            veiculos = this.veiculoRepository.findByPlaca(placa);
        } else if (marca != null) {
            veiculos = this.veiculoRepository.findByMarcaContainingIgnoreCase(marca);
        } else if (modelo != null) {
            veiculos = this.veiculoRepository.findByModeloContainingIgnoreCase(modelo);
        } else {
            veiculos = this.veiculoRepository.findAll();
        }

        List<VeiculoDTO> resultado = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            resultado.add(new VeiculoDTO(veiculo));
        }
        return resultado;
    }

    public void atualizarVeiculo(UUID id, VeiculoUpdateInput dto) {
        Veiculo veiculo = this.veiculoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo não encontrado"));

        if (dto.getMarca() != null) {
            veiculo.setMarca(dto.getMarca());
        }
        if (dto.getModelo() != null) {
            veiculo.setModelo(dto.getModelo());
        }
        if (dto.getAno() != null) {
            veiculo.setAno(dto.getAno());
        }
        if (dto.getValor() != null) {
            veiculo.setValor(dto.getValor());
        }
        if (dto.getMaximoDesconto() != null) {
            veiculo.setMaximoDesconto(dto.getMaximoDesconto());
        }
        if (dto.getVendido() != null) {
            veiculo.setVendido(dto.getVendido());
        }
        if (dto.getValorVenda() != null) {
            veiculo.setValorVenda(dto.getValorVenda());
        }

        if (veiculo.getVendido() && veiculo.getValorVenda() == null) {
            throw new DadosInvalidosException("Valor venda é obrigatório quando vendido for true");
        }

        this.veiculoRepository.save(veiculo);
    }

    public void removerVeiculo(UUID id) {
        if (!this.veiculoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Veículo não encontrado");
        }
        this.veiculoRepository.deleteById(id);
    }
}
