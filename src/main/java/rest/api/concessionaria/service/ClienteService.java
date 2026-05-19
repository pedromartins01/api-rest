package rest.api.concessionaria.service;

import org.springframework.stereotype.Service;
import rest.api.concessionaria.entity.Cliente;
import rest.api.concessionaria.model.ClienteDTO;
import rest.api.concessionaria.repository.ClienteRepository;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente(dto);
        this.clienteRepository.save(cliente);
    }
}
