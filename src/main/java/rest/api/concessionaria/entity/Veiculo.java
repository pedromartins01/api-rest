package rest.api.concessionaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rest.api.concessionaria.model.VeiculoDTO;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Double maximoDesconto;

    @Column(nullable = false)
    private Boolean vendido;

    private Double valorVenda;

    public Veiculo(VeiculoDTO dto, Cliente cliente) {
        this.cliente = cliente;
        this.marca = dto.getMarca();
        this.modelo = dto.getModelo();
        this.ano = dto.getAno();
        this.valor = dto.getValor();
        this.placa = dto.getPlaca();
        this.maximoDesconto = dto.getMaximoDesconto();
        this.vendido = dto.getVendido();
        this.valorVenda = dto.getValorVenda();
    }

}
