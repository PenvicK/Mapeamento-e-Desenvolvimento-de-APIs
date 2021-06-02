package br.com.exercicio5.Exercicio5.Prova.controllers;

import br.com.exercicio5.Exercicio5.Prova.dto.TarefasDTO;
import br.com.exercicio5.Exercicio5.Prova.entities.Tarefas;
import br.com.exercicio5.Exercicio5.Prova.services.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService service;

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> findAll(){
        List<TarefasDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Tarefas> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TarefasDTO> save(@RequestBody TarefasDTO entity){
        TarefasDTO obj = service.saveTarefas(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Tarefas> edit(@PathVariable Long id, @RequestBody Tarefas update){
        return ResponseEntity.ok(service.editTarefas(id, update));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.ok("Tarefa " + id + " deletada!");
    }
}
