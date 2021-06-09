package br.com.gt.trainee.service;


import br.com.gt.trainee.models.Peoples;
import br.com.gt.trainee.repositories.PeoplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeoplesRepository peoplesRepository;

    public List<Peoples> findAll(){
        return peoplesRepository.findAll();
    }

    public Peoples findById(Long id){
        return this.peoplesRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        peoplesRepository.deleteById(id);
    }

    public Peoples save(Peoples peoples) {
        return peoplesRepository.save(peoples);
    }


}
