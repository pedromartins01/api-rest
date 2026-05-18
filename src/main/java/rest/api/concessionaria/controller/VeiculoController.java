package rest.api.concessionaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.concessionaria.entity.Veiculo;
import rest.api.concessionaria.service.VeiculoService;

@RestController
@RequestMapping("/api/v1/veiculo")

public class VeiculoController {

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarVeiculo (@RequestBody Veiculo veiculo) {
        this.veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
