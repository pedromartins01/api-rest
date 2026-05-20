package rest.api.concessionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rest.api.concessionaria.entity.Veiculo;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VeiculoBuscarDTO {

        private UUID id;
        private UUID clienteId;
        private String marca;
        private String modelo;
        private Integer ano;
        private Double valor;
        private String placa;
        private Double maximoDesconto;
        private Boolean vendido;
        private Double valorVenda;

        public VeiculoBuscarDTO(Veiculo veiculo) {
            this.id = veiculo.getId();
            this.clienteId = veiculo.getCliente().getId();
            this.marca = veiculo.getMarca();
            this.modelo = veiculo.getModelo();
            this.ano = veiculo.getAno();
            this.valor = veiculo.getValor();
            this.placa = veiculo.getPlaca();
            this.maximoDesconto = veiculo.getMaximoDesconto();
            this.vendido = veiculo.getVendido();
            this.valorVenda = veiculo.getValorVenda();
        }
}
