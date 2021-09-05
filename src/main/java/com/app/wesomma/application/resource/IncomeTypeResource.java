package com.app.wesomma.application.resource;

import com.app.wesomma.domain.income.IncomeType;
import com.app.wesomma.domain.income.IncomeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class IncomeTypeResource {

    @Autowired
    IncomeTypeRepository incomeTypeRepository;

    @GetMapping("/incometypes")
    public List<IncomeType> findAll(){
        return incomeTypeRepository.findAll();
    }

    @GetMapping("/incometype/{id}")
    public IncomeType findById(@PathVariable(value = "id") Integer id) {
        return incomeTypeRepository.findById(id);
    }

    @PostMapping("/incometype")
    public IncomeType save(@RequestBody IncomeType tiporenda) {

        return incomeTypeRepository.save(tiporenda);
    }

    @DeleteMapping("/incometype")
    public void delete(@RequestBody IncomeType incomeType) {
        incomeTypeRepository.delete(incomeType);
    }

    @PutMapping("/incometype")
    public IncomeType update(@RequestBody IncomeType incomeType) {
        return incomeTypeRepository.save(incomeType);
    }
}
