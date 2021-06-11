package br.com.gt.trainee.controllers;

import br.com.gt.trainee.models.TipoUnidade;
import br.com.gt.trainee.service.TipoUnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TipoUnidadeController {

    @Autowired
    private TipoUnidadeService tipoUnidadeService;

    @GetMapping(value = "/tipounidade")
    public List<TipoUnidade> findAll(){
        return tipoUnidadeService.findAll();
    }

    @GetMapping(value = "/tipounidade/{id}")
    public TipoUnidade findById(@PathVariable Long id){
        return tipoUnidadeService.findById(id);
    }

    @PostMapping(value = "/tipounidade")
    public TipoUnidade save (@Valid @RequestBody TipoUnidade tipoUnidade){
        return tipoUnidadeService.save(tipoUnidade);
    }

    @DeleteMapping(value = "/tipounidade/{id}")
    public void delete(@PathVariable Long id){
        tipoUnidadeService.deleteBydId(id);
    }
}
