package com.app.wesomma.application.resource;

import com.app.wesomma.domain.budget.TypeBudget;
import com.app.wesomma.domain.budget.TypeBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class TypeBudgetResource {

    @Autowired
    TypeBudgetRepository typeBudgetRepository;

    @GetMapping("/typebudgets")
    public List<TypeBudget> findAll(){
        return typeBudgetRepository.findAll();
    }

    @GetMapping("/typebudget/{id}")
    public TypeBudget findById(@PathVariable(value = "id") Integer id) {
        return typeBudgetRepository.findById(id);
    }

    @PostMapping("/typebudget")
    public TypeBudget save(@RequestBody TypeBudget typeBudget) { return typeBudgetRepository.save(typeBudget); }

    @DeleteMapping("/typebudget")
    public void delete(@RequestBody TypeBudget typeBudget) { typeBudgetRepository.delete(typeBudget); }

    @PutMapping("/typebudget")
    public TypeBudget update(@RequestBody TypeBudget typeBudget) {
        return typeBudgetRepository.save(typeBudget);
    }
}
