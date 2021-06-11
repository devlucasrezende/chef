package br.com.gt.trainee.service;


import br.com.gt.trainee.models.Ingrediente;
import br.com.gt.trainee.repositories.IngredienteRepository;
import br.com.gt.trainee.repositories.TipoUnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Transactional(readOnly = true)
    public List<Ingrediente> findAll(){
        return ingredienteRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Ingrediente findById(Long id){
        return ingredienteRepository.findById(id).orElse(null);
    }

    public Ingrediente save (Ingrediente ingrediente){
        return ingredienteRepository.save(ingrediente);
    }

    public void delete (Long id){
        ingredienteRepository.deleteById(id);
    }

}
