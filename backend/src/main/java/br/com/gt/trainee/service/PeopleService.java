package br.com.gt.trainee.service;

import br.com.gt.trainee.models.Peoples;
import br.com.gt.trainee.models.Receitas;
import br.com.gt.trainee.repositories.PeoplesRepository;
import br.com.gt.trainee.repositories.PeoplesRepository;
import br.com.gt.trainee.repositories.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeoplesRepository repository;


    public List<Peoples> findAll(){
        return repository.findAll();
    }

    public Peoples findById(Long id){
        Optional<Peoples> obj = repository.findById(id);
        return obj.get();

    }

    public void delete (Long id){
        repository.deleteById(id);
    }

}
