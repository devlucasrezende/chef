package br.com.gt.trainee.controllers;


import br.com.gt.trainee.models.Peoples;
import br.com.gt.trainee.models.Receitas;
import br.com.gt.trainee.repositories.PeoplesRepository;
import br.com.gt.trainee.repositories.PeoplesRepository;
import br.com.gt.trainee.repositories.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PeopleController {

    @Autowired
    private PeoplesRepository repository;

    @GetMapping("/peoples")
    public ResponseEntity<List<Peoples>> findAll() {
        try {
            List<Peoples> list = repository.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/peoples/{id}")
    public ResponseEntity<Peoples> findById(@PathVariable Long id) {

        Optional<Peoples> peoples = repository.findById(id);
        if(peoples.isPresent()) {
            return new ResponseEntity(peoples.get(),HttpStatus.OK);
        }  else{
            return new ResponseEntity("Não encontrado",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/peoples")

    public ResponseEntity<List<Peoples>> addPeoples(@RequestBody Peoples peoples) {
        try {
            Peoples peoples1 = repository.save(new Peoples(peoples.getId(), peoples.getName(), peoples.getAboutMe(), peoples.getFavouriteFood(), peoples.getAge()));
            return new ResponseEntity(peoples1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/peoples/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    }
