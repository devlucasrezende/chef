package br.com.gt.trainee.controllers;


import br.com.gt.trainee.models.Ingrediente;
import br.com.gt.trainee.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping(value = "/ingredientes")
    public List<Ingrediente> findAll(){
        return ingredienteService.findAll();
    }

    @GetMapping(value = "/ingredientes/{id}")
    public Ingrediente findById(@PathVariable Long id){
        return ingredienteService.findById(id);
    }

    @PostMapping(value = "/ingredientes")
    public Ingrediente save (@Valid @RequestBody Ingrediente ingrediente){
        return ingredienteService.save(ingrediente);
    }

    @DeleteMapping(value = "/ingredientes/{id}")
    public void deleteById (@PathVariable Long id){
        ingredienteService.delete(id);
    }


}
