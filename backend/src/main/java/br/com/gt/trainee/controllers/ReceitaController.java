package br.com.gt.trainee.controllers;

import br.com.gt.trainee.models.Receita;
import br.com.gt.trainee.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/receitas")
    public List<Receita> findAll() {
        return receitaService.findAll();
    }

    @GetMapping("/receitas/{id}")
    public Receita findById(@PathVariable Long id) {
        return receitaService.findById(id);
    }

    @PostMapping("/receitas")
    public Receita addReceita(@Valid @RequestBody Receita receita) {
        return receitaService.save(receita);
    }

    @DeleteMapping("/receitas/{id}")
    public void delete(@PathVariable Long id){
        receitaService.deleteById(id);
    }


}

