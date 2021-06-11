package br.com.gt.trainee.service;


import br.com.gt.trainee.models.Peoples;
import br.com.gt.trainee.repositories.PeoplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeoplesRepository peoplesRepository;

    @Transactional(readOnly = true)
    public List<Peoples> findAll(){
        return peoplesRepository.findAll();
    }

    @Transactional(readOnly = true)
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
