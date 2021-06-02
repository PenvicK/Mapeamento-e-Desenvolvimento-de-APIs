package br.com.exercicio5.Exercicio5.Prova.entities;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tarefas")
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tarefa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    public Tarefas(Tarefas entity) {
        id = entity.getId();
        tarefa = entity.getTarefa();
        cliente = entity.getCliente();
    }
}
