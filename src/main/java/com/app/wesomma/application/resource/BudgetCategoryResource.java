package com.app.wesomma.application.resource;

import com.app.wesomma.application.service.BudgetCategoryService;
import com.app.wesomma.application.util.BudgetCategoryUtil;
import com.app.wesomma.domain.budget.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class BudgetCategoryResource {

    private static Logger logger = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    BudgetCategoryRepository budgetCategoryRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    BudgetCategoryService budgetCategoryService;

    @GetMapping("/budgetCategories")
    public List<BudgetCategory> findAll(){
        logger.info("Iniciando findAll");
        return budgetCategoryRepository.findAll();
    }

    @GetMapping("/budgetCategory/{id}")
    public BudgetCategory findById(@PathVariable(value = "id") Integer id) {
        logger.info("Iniciando findById id: " + id);
        return budgetCategoryRepository.findById(id);
    }

    @GetMapping("/budgetCategories/{id}")
    public List<BudgetCategoryDTO> findAllByBudget(@PathVariable(value = "id") Integer id) {
        logger.info("Iniciando findAllByBudget id: " + id);
        Budget budget = budgetRepository.findById(id);
        return BudgetCategoryUtil.parseList(budgetCategoryRepository.findByBudget(budget));
    }

    @PostMapping("/budgetCategory")
    public BudgetCategory save(@RequestBody BudgetCategory budgetCategory) {
        logger.info("Iniciando save");
        return budgetCategoryRepository.save(budgetCategory);
    }

    @DeleteMapping("/budgetCategory/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        logger.info("Iniciando delete id: " + id);
        BudgetCategory budgetCategory = budgetCategoryService.rollbackBudgetCategoryValues(id);

        budgetCategoryRepository.delete(budgetCategory);
    }



    @PutMapping("/budgetCategory")
    public BudgetCategory update(@RequestBody BudgetCategory budgetCategory) {
        logger.info("Iniciando update");
        return budgetCategoryRepository.save(budgetCategory);
    }
}
