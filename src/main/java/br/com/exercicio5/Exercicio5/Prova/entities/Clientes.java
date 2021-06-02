package br.com.exercicio5.Exercicio5.Prova.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cliente")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Tarefas> tarefas = new ArrayList<>();

    public Clientes(Clientes entity){
        id = entity.getId();
        nome = entity.getNome();
        tarefas = entity.getTarefas().stream().map(tarefa -> new Tarefas(tarefa)).collect(Collectors.toList());
    }
}
