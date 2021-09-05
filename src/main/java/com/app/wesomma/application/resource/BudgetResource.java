package com.app.wesomma.application.resource;

import com.app.wesomma.application.service.BudgetService;
import com.app.wesomma.application.util.BudgetUtil;
import com.app.wesomma.domain.budget.*;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.income.IncomeRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class BudgetResource {

    private static Logger logger = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BudgetCategoryRepository budgetCategoryRepository;

    @Autowired
    BudgetService budgetService;

    @GetMapping("/budgets")
    public List<Budget> findAll(){
        logger.info("Iniciando findAll");
        return budgetRepository.findAll();
    }

    @GetMapping("/budgets/{open}")
    public List<Budget> findAllOpen(@PathVariable(value = "open") boolean open) {
        logger.info("Iniciando findAllOpen open: " + open);
        return budgetRepository.open(open);
    }

    @GetMapping("/budgets/{open}/{person_id}")
    public List<BudgetDTO> findAllOpenById(@PathVariable(value = "open") boolean open, @PathVariable(value = "person_id") Long personId) {
        logger.info("Iniciando findAllOpenById personId: " + personId);
        return BudgetUtil.parseList(budgetService.findOpenById(personId));
    }

    @GetMapping("/budgets/group/{open}/{group_id}")
    public List<BudgetDTO> findAllOpenByGroup(@PathVariable(value = "open") boolean open, @PathVariable(value = "group_id") Integer groupId) {
        logger.info("Iniciando findAllOpenByGroup groupId: " + groupId);
        List<Budget> budgets = budgetService.findOpenByGroup(groupId);
        return BudgetUtil.parseList(budgets);
    }

    @GetMapping("/budget/{person_id}")
    public List<BudgetDTO> findByPerson(@PathVariable(value = "person_id") Long personId) {
        logger.info("Iniciando findByPerson personId: " + personId);
        Optional<User> user = userRepository.findById(personId);

        return BudgetUtil.parseList(budgetRepository.findAllByUser(user.orElse(new User())));
    }

    @GetMapping("/budgets/group/{group_id}")
    public List<BudgetDTO> findByGroup(@PathVariable(value = "group_id") Integer groupId) {
        logger.info("Iniciando findByGroup personId: " + groupId);
        return BudgetUtil.parseList(budgetRepository.findAllByFamilyId(groupId));
    }

    @PostMapping("/budget")
    public BudgetDTO save(@RequestBody Budget budget) {
        logger.info("Iniciando save personId: ");
        if(budget.getFamily() != null) {
            Optional<Family> family = groupRepository.findById(budget.getFamily().getId());
            budget.setFamily(family.orElse(new Family()));
            groupRepository.save(budget.getFamily());
        }

        if(budget.getIncomes() != null) {
            for (int i = 0; i <= budget.getIncomes().size(); i++) {
                incomeRepository.save(budget.getIncomes().get(i));
            }
        }
        Budget returnedBudget = budgetRepository.save(budget);

        for(BudgetCategory budgetCategory : returnedBudget.getBudgetCategories()) {
            budgetCategory.setBudget(returnedBudget);
            budgetCategoryRepository.save(budgetCategory);
        }

        return BudgetUtil.parse(returnedBudget);
    }

    @DeleteMapping("/budget/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        logger.info("Iniciando delete id: " + id);
        Budget budget = budgetRepository.findById(id);
        List<BudgetCategory> budgetCategories = budgetCategoryRepository.findByBudget(budget);
        for(BudgetCategory budgetCategory : budgetCategories) {
            budgetCategoryRepository.delete(budgetCategory);
        }
        budgetRepository.delete(budget);
    }

    @PutMapping("/budget")
    public BudgetDTO update(@RequestBody Budget budget) {
        logger.info("Iniciando update");
        if(budget.getFamily() != null) {
            Optional<Family> family = groupRepository.findById(budget.getFamily().getId());
            budget.setFamily(family.orElse(new Family()));
            groupRepository.save(budget.getFamily());
        }

        if(budget.getIncomes() != null) {
            for (int i = 0; i <= budget.getIncomes().size() ; i++) {
                incomeRepository.save(budget.getIncomes().get(i));
            }
        }

        List<BudgetCategory> budgetCategories = budgetCategoryRepository.findByBudget(budget);
        budget.getBudgetCategories().removeAll(budget.getBudgetCategories());
        budget.getBudgetCategories().addAll(budgetCategories);


        return BudgetUtil.parse(budgetRepository.save(budget));
    }
}
