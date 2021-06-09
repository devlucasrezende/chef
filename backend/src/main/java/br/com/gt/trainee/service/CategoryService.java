package br.com.gt.trainee.service;

import br.com.gt.trainee.models.Category;
import br.com.gt.trainee.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

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
