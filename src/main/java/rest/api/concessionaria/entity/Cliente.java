package rest.api.concessionaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rest.api.concessionaria.model.ClienteDTO;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String email;

    public Cliente(ClienteDTO dto) {
        this.nome = dto.getNome();
        this.telefone = dto.getTelefone();
        this.cpf = dto.getCpf();
        this.email = dto.getEmail();
    }

}
