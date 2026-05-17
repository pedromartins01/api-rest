package rest.api.concessionaria.service;

import org.springframework.stereotype.Service;
import rest.api.concessionaria.repository.ClienteRepository;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
}
