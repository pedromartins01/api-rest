package rest.api.concessionaria.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.concessionaria.model.VeiculoBuscarDTO;
import rest.api.concessionaria.model.VeiculoInput;
import rest.api.concessionaria.model.VeiculoUpdateInput;
import rest.api.concessionaria.service.VeiculoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/veiculo")

public class VeiculoController {

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarVeiculo (@Valid @RequestBody VeiculoInput veiculo) {
        this.veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<VeiculoBuscarDTO>> buscarVeiculos(
            @RequestParam(required = false) String placa,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo) {
        List<VeiculoBuscarDTO> veiculos = this.veiculoService.buscarVeiculos(placa, marca, modelo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarVeiculo(@PathVariable UUID id, @RequestBody VeiculoUpdateInput veiculo) {
        this.veiculoService.atualizarVeiculo(id, veiculo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerVeiculo(@PathVariable UUID id) {
        this.veiculoService.removerVeiculo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
