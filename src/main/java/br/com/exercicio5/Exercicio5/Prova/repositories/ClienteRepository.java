package br.com.exercicio5.Exercicio5.Prova.repositories;

import br.com.exercicio5.Exercicio5.Prova.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {
}
