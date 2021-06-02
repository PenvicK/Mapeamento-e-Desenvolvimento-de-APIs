package br.com.exercicio5.Exercicio5.Prova.services;

import br.com.exercicio5.Exercicio5.Prova.dto.ClientesDTO;
import br.com.exercicio5.Exercicio5.Prova.entities.Clientes;
import br.com.exercicio5.Exercicio5.Prova.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientesService {

    @Autowired
    private ClienteRepository repository;

    // FIND ALL
    public List<ClientesDTO> findAll() {
        List<Clientes> result = repository.findAll();
        return result.stream().map(clientes -> new ClientesDTO(clientes)).collect(Collectors.toList());
    }

    // FIND BY ID
    public Clientes findById(Long id) {
        Optional<Clientes> result = repository.findById(id);
        return result.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not found"));
    }

    // INSERT CLIENTES
    public Clientes saveClientes(Clientes dto){
        repository.save(dto);
        return dto;
    }

    // EDIT CLIENTES
    public Clientes editClientes(Long id, Clientes entity){
        Clientes obj = findById(id);
        obj.setNome(entity.getNome());
        obj.setTarefas(entity.getTarefas());

        repository.save(obj);
        return obj;
    }

    // DELETE CLIENTES BY ID
    public void deleteByID(Long id){
        repository.delete(findById(id));
    }
}
