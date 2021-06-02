package br.com.exercicio5.Exercicio5.Prova.services;

import br.com.exercicio5.Exercicio5.Prova.dto.TarefasDTO;
import br.com.exercicio5.Exercicio5.Prova.entities.Tarefas;
import br.com.exercicio5.Exercicio5.Prova.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefasService {

    @Autowired
    private TarefaRepository repository;

    // FIND ALL
    public List<TarefasDTO> findAll() {
        List<Tarefas> result = repository.findAll();
        return result.stream().map(tarefas -> new TarefasDTO(tarefas)).collect(Collectors.toList());
    }

    // FIND BY ID
    public Tarefas findById(Long id) {
        Optional<Tarefas> result = repository.findById(id);
        return result.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task not found"));
    }

    // INSERT TAREFAS
    public Tarefas saveTarefas(Tarefas dto){
        repository.save(dto);
        return dto;
    }

    // EDIT TAREFAS
    public Tarefas editTarefas(Long id, Tarefas entity){
        Tarefas obj = findById(id);
        obj.setTarefa(entity.getTarefa());
        obj.setCliente(entity.getCliente());

        repository.save(obj);
        return obj;
    }

    // DELETE TAREFAS BY ID
    public void deleteByID(Long id){
        repository.delete(findById(id));
    }
}
