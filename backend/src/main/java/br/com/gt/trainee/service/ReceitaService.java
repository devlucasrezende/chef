package br.com.gt.trainee.service;

import br.com.gt.trainee.models.Category;
import br.com.gt.trainee.models.Receita;
import br.com.gt.trainee.repositories.CategoryRepository;
import br.com.gt.trainee.repositories.ReceitasRepository;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional //O Spring vai gerenciar qualquer transação que ocorrer dentro da classe, mantendo apensas uma transação em aberto. Não salvar pela metade
public class ReceitaService {

    @Autowired
    private ReceitasRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true) //transação só para leitura tornando a transação mais performática
    public List<Receita> findAll(){
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Receita findById(Long id){
       return this.repository.findById(id).orElse(null);
    }

    public void delete (Long id){
        this.repository.deleteById(id);
    }


    public Receita save(Receita receita) {
        return this.repository.save(receita);
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
