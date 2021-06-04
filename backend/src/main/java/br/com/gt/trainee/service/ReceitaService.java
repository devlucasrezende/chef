package br.com.gt.trainee.service;

import br.com.gt.trainee.models.Receitas;
import br.com.gt.trainee.repositories.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitasRepository repository;


    public List<Receitas> findAll(){
        return repository.findAll();
    }

    public Receitas findById(Long id){
        Optional<Receitas> obj = repository.findById(id);
        return obj.get();

    }
    public void delete (Long id){
        repository.deleteById(id);
    }

}
