package br.com.exercicio5.Exercicio5.Prova.dto;

import br.com.exercicio5.Exercicio5.Prova.entities.Clientes;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private List<TarefasDTO> tarefas = new ArrayList<>();

    public ClientesDTO(Clientes entity){
        id = entity.getId();
        nome = entity.getNome();
        tarefas = entity.getTarefas().stream().map(tarefa -> new TarefasDTO(tarefa)).collect(Collectors.toList());
    }
}
