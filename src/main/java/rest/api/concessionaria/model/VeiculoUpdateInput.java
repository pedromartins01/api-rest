package rest.api.concessionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VeiculoUpdateInput {

    private String marca;
    private String modelo;
    private Integer ano;
    private Double valor;
    private Double maximoDesconto;
    private Boolean vendido;
    private Double valorVenda;
}