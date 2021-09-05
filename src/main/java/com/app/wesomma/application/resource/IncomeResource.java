package com.app.wesomma.application.resource;

import com.app.wesomma.domain.income.Income;
import com.app.wesomma.domain.income.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class IncomeResource {

    @Autowired
    IncomeRepository incomeRepository;

    @GetMapping("/incomies")
    public List<Income> findAll(){
        return incomeRepository.findAll();
    }

    @GetMapping("/income/{id}")
    public Income findById(@PathVariable(value = "id") Integer id) {
        return incomeRepository.findById(id);
    }

    @PostMapping("/income")
    public Income save(@RequestBody Income income) { return incomeRepository.save(income); }

    @DeleteMapping("/income")
    public void delete(@RequestBody Income income) {
        incomeRepository.delete(income);
    }

    @PutMapping("/income")
    public Income update(@RequestBody Income income) {
        return incomeRepository.save(income);
    }
}
