package rest.api.concessionaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID clienteId;

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

    @Column ()
    private Double valorVenda;
}
