package br.com.gt.trainee.controllers;

import br.com.gt.trainee.models.ModoPreparo;
import br.com.gt.trainee.service.ModoPreparoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ModoPreparoController {

    @Autowired
    private ModoPreparoService modoPreparoService;

    @GetMapping("/modoPreparo")
    public List<ModoPreparo> findAll() {
        return modoPreparoService.findAll();
    }

    @GetMapping("/modoPreparo/{id}")
    public ModoPreparo findById(@PathVariable Long id) {
        return modoPreparoService.findById(id);
    }

    @PostMapping("/modoPreparo")
    public ModoPreparo addModoPreparo (@Valid @RequestBody ModoPreparo modoPreparo) {
        return modoPreparoService.save(modoPreparo);
    }

    @DeleteMapping("/modoPreparo/{id}")
    public void delete(@PathVariable Long id){
        modoPreparoService.deleteById(id);
    }










}

