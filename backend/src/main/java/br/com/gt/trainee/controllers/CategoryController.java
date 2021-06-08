package br.com.gt.trainee.controllers;


import br.com.gt.trainee.models.Category;
import br.com.gt.trainee.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> findAll(){
        try{
            List<Category> list = repository.findAll();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Optional<Category> category = repository.findById(id);
        if(category.isPresent()) {
            return new ResponseEntity(category.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/category")
    public ResponseEntity<List<Category>> addCategory(@RequestBody Category category){
        try {
            Category category1 = repository.save(new Category(category.getId(), category.getName()));
            return new ResponseEntity(category1, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "category/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
