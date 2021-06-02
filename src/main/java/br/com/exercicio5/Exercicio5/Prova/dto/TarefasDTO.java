package br.com.exercicio5.Exercicio5.Prova.dto;

import br.com.exercicio5.Exercicio5.Prova.entities.Tarefas;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefasDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tarefa;
    private ClientesDTO clienteDTO;

    public TarefasDTO(Tarefas entity){
        id = entity.getId();
        tarefa = entity.getTarefa();
        clienteDTO = new ClientesDTO(entity.getCliente());
    }
}
