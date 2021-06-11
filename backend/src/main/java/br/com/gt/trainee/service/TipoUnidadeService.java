package br.com.gt.trainee.service;


import br.com.gt.trainee.models.TipoUnidade;
import br.com.gt.trainee.repositories.TipoUnidadeRepository;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoUnidadeService {

    @Autowired
    private TipoUnidadeRepository tipoUnidadeRepository;

    @Transactional(readOnly = true)
    public List<TipoUnidade> findAll(){
        return this.tipoUnidadeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TipoUnidade findById(Long id){
        return tipoUnidadeRepository.findById(id).orElse(null);
    }

    public void deleteBydId(Long id){
        tipoUnidadeRepository.deleteById(id);
    }

    public TipoUnidade save(TipoUnidade tipoUnidade){
        return tipoUnidadeRepository.save(tipoUnidade);
    }

}
