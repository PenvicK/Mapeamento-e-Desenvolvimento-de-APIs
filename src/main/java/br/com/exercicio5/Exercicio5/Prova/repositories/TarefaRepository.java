package br.com.exercicio5.Exercicio5.Prova.repositories;

import br.com.exercicio5.Exercicio5.Prova.entities.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefas, Long> {
}
