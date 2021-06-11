package br.com.gt.trainee.service;

import br.com.gt.trainee.models.Category;
import br.com.gt.trainee.repositories.CategoryRepository;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }


    public void deleteById (Long id) {
        this.categoryRepository.deleteById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }


}
