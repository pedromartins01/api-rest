package rest.api.concessionaria.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VeiculoDTO {

    @NotNull
    private UUID clienteId;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotNull
    private Integer ano;

    @NotNull
    private Double valor;

    @NotBlank
    private String placa;

    @NotNull
    private Double maximoDesconto;

    @NotNull
    private Boolean vendido;

    private Double valorVenda;
}
