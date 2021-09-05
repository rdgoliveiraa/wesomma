package com.app.wesomma.application.service;

import com.app.wesomma.domain.budget.Budget;
import com.app.wesomma.domain.budget.BudgetCategory;
import com.app.wesomma.domain.budget.BudgetCategoryRepository;
import com.app.wesomma.domain.budget.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetCategoryService {

    @Autowired
    BudgetCategoryRepository budgetCategoryRepository;

    @Autowired
    BudgetRepository budgetRepository;

    public BudgetCategory rollbackBudgetCategoryValues(Integer id) {
        BudgetCategory budgetCategory = budgetCategoryRepository.findById(id);
        Budget budget = budgetCategory.getBudget();

        budget.setRealizedValue(budget.getRealizedValue() - budgetCategory.getRealizedValue());
        budget.setRealizedValue(budget.getExpectedValue() - budgetCategory.getExpectedValue());

        budgetRepository.save(budget);
        return budgetCategory;
    }
}
