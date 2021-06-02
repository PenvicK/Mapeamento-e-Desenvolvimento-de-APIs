package br.com.exercicio5.Exercicio5.Prova.controllers;

import br.com.exercicio5.Exercicio5.Prova.dto.ClientesDTO;
import br.com.exercicio5.Exercicio5.Prova.entities.Clientes;
import br.com.exercicio5.Exercicio5.Prova.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class ClientesController {

    @Autowired
    private ClientesService service;

    @GetMapping
    public ResponseEntity<List<ClientesDTO>> findAll(){
        List<ClientesDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Clientes> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Clientes> save(@RequestBody Clientes entity){
        Clientes obj = service.saveClientes(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Clientes> edit(@PathVariable Long id, @RequestBody Clientes update){
        return ResponseEntity.ok(service.editClientes(id, update));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteByID(id);
        return ResponseEntity.ok("Cliente " + id + " deletado!");
    }
}
