package rest.api.concessionaria.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.concessionaria.model.ClienteBuscarDTO;
import rest.api.concessionaria.model.ClienteDTO;
import rest.api.concessionaria.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarCliente (@Valid @RequestBody ClienteDTO cliente) {
        this.clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteBuscarDTO>> buscarClientes(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        List<ClienteBuscarDTO> clientes = this.clienteService.buscarClientes(nome, cpf);
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

}
