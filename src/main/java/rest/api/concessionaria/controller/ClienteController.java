package rest.api.concessionaria.controller;

import org.springframework.web.bind.annotation.RestController;
import rest.api.concessionaria.service.ClienteService;

@RestController
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
}
