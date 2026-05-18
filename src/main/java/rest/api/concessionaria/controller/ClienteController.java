package rest.api.concessionaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.concessionaria.entity.Cliente;
import rest.api.concessionaria.service.ClienteService;

@RestController
@RequestMapping("/api/v1/cliente")

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarCliente (@RequestBody Cliente cliente) {
        this.clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
}
