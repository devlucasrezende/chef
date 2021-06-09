package br.com.gt.trainee.controllers;

import br.com.gt.trainee.models.Peoples;
import br.com.gt.trainee.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/peoples")
    public List<Peoples> findAll() {
        return peopleService.findAll();
    }

    @GetMapping("/peoples/{id}")
    public Peoples findById(@PathVariable Long id) {
        return peopleService.findById(id);
    }

    @PostMapping("/peoples")
    public Peoples addPeoples(@Valid @RequestBody Peoples peoples) {
        return peopleService.save(peoples);
    }

    @DeleteMapping("/peoples/{id}")
    public void delete(@PathVariable Long id) {
        peopleService.deleteById(id);
    }

}
