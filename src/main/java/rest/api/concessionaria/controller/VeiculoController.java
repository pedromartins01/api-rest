package rest.api.concessionaria.controller;

import org.springframework.web.bind.annotation.RestController;
import rest.api.concessionaria.service.VeiculoService;

@RestController
public class VeiculoController {

    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }
}
