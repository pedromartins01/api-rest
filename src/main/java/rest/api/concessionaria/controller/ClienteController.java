package rest.api.concessionaria.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.concessionaria.model.ClienteDTO;
import rest.api.concessionaria.model.ClienteInput;
import rest.api.concessionaria.service.ClienteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cliente")

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarCliente (@Valid @RequestBody ClienteInput cliente) {
        this.clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarClientes(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        List<ClienteDTO> clientes = this.clienteService.buscarClientes(nome, cpf);
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable UUID id) {
        this.clienteService.removerCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
