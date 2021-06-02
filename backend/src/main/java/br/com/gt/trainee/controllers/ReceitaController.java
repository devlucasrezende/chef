package br.com.gt.trainee.controllers;


import br.com.gt.trainee.models.Receitas;
import br.com.gt.trainee.repositories.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReceitaController {

    @Autowired
    private ReceitasRepository repository;

    @GetMapping("/receitas")
    public ResponseEntity<List<Receitas>> findAll() {
        try {
            List<Receitas> list = repository.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/receitas/{id}")
    public ResponseEntity<Receitas> findById(@PathVariable Long id) {

        Optional<Receitas> receita = repository.findById(id);
        if(receita.isPresent()) {
            return new ResponseEntity<>(receita.get(),HttpStatus.OK);
    }  else{
            return new ResponseEntity("Não encontrado",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/receitas")
    //@RequestBody - Significa que tá esperando alguma coisa
    public ResponseEntity<List<Receitas>> addReceita(@RequestBody Receitas receitas) {
        try {
            Receitas receitas1 = repository.save(new Receitas(receitas.getId(), receitas.getNome(), receitas.getDescricao(), receitas.getTempoDePreparo(), receitas.getRendimento()));
            return new ResponseEntity(receitas1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/receitas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }










}

