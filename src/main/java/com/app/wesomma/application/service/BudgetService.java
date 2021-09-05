package com.app.wesomma.application.service;

import com.app.wesomma.domain.budget.Budget;
import com.app.wesomma.domain.budget.BudgetRepository;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    GroupRepository groupRepository;

    public List<Budget> findOpenById(Long personId) {
        Optional<User> user = userRepository.findById(personId);
        List<Budget> budgets = budgetRepository.findAllByUser(user.get());
        budgets.removeIf(budget -> Boolean.TRUE.equals(budget.isOpen()));
        return budgets;
    }

    public List<Budget> findOpenByGroup(Integer groupId) {
        if(groupId == 0) {
            List<Budget> budgets = new ArrayList<>();
        }

        List<Budget> budgets = budgetRepository.findAllByFamilyId(groupId);
        budgets.removeIf(budget -> Boolean.TRUE.equals(budget.isOpen()));
        return budgets;
    }

    public void createBudget(User user, Family family) {
        Budget budgetSaved = budgetRepository.findByFamily(user.getFamily());
        if(budgetSaved == null) {
            Budget budget = new Budget("Orçamento", 0.0, 0.0, true, family, user);
            budgetRepository.save(budget);
        }
    }

}
