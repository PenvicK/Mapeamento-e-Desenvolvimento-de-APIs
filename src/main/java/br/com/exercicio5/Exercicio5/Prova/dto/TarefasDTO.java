package br.com.exercicio5.Exercicio5.Prova.dto;

import br.com.exercicio5.Exercicio5.Prova.entities.Clientes;
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
    private Clientes clienteDTO;

    public TarefasDTO(Tarefas entity){
        id = entity.getId();
        tarefa = entity.getTarefa();
        clienteDTO = entity.getCliente();
    }
}
