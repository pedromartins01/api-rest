package rest.api.concessionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rest.api.concessionaria.entity.Cliente;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteBuscarDTO {

    private UUID id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;

    public ClienteBuscarDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }

}
