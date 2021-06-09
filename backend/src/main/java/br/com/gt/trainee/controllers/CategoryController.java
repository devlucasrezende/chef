package br.com.gt.trainee.controllers;

import br.com.gt.trainee.models.Category;
import br.com.gt.trainee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/category")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/category/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping(value = "/category")
    public Category addCategory(@Valid @RequestBody Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping(value = "category/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
