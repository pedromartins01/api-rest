package rest.api.concessionaria.service;

import org.springframework.stereotype.Service;
import rest.api.concessionaria.entity.Cliente;
import rest.api.concessionaria.exception.ConflitoException;
import rest.api.concessionaria.model.ClienteBuscarDTO;
import rest.api.concessionaria.model.ClienteDTO;
import rest.api.concessionaria.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(ClienteDTO dto) {
        if (this.clienteRepository.existsByCpf(dto.getCpf())) {
            throw new ConflitoException("CPF já cadastrado");
        }
        Cliente cliente = new Cliente(dto);
        this.clienteRepository.save(cliente);
    }

    public List<ClienteBuscarDTO> buscarClientes(String nome, String cpf) {
        List<Cliente> clientes;

        if (nome != null) {
            clientes = this.clienteRepository.findByNomeContainingIgnoreCase(nome);
        } else if (cpf != null) {
            clientes = this.clienteRepository.findByCpf(cpf);
        } else {
            clientes = this.clienteRepository.findAll();
        }

        List<ClienteBuscarDTO> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            resultado.add(new ClienteBuscarDTO(cliente));
        }
        return resultado;
    }
}
