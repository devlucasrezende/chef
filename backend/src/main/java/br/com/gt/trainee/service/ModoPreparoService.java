package br.com.gt.trainee.service;


import br.com.gt.trainee.models.ModoPreparo;
import br.com.gt.trainee.repositories.ModoPreparoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModoPreparoService {

    @Autowired
    private ModoPreparoRepository modoPreparoRepository;

    @Transactional(readOnly = true)
    public List<ModoPreparo> findAll() {
        return this.modoPreparoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ModoPreparo findById(Long id) {
        return this.modoPreparoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        this.modoPreparoRepository.deleteById(id);
    }

    public ModoPreparo save(ModoPreparo modoPreparo) {
        return modoPreparoRepository.save(modoPreparo);
    }

}

