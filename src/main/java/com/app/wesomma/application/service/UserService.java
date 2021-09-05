package com.app.wesomma.application.service;

import com.app.wesomma.domain.account.Account;
import com.app.wesomma.domain.account.AccountRepository;
import com.app.wesomma.domain.budget.Budget;
import com.app.wesomma.domain.budget.BudgetRepository;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    GroupRepository groupRepository;

    public User createUser(User user) {
        String passwordEncode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(passwordEncode);
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        List<Account> accounts = accountRepository.getByUser(user);
        accountRepository.deleteAll(accounts);
        List<Budget> budgets = budgetRepository.findAllByUser(user);
        budgetRepository.deleteAll(budgets);
        List<Family> family = groupRepository.findAllByLeader(user);
        groupRepository.deleteAll(family);
        userRepository.deleteById(user.getId());
    }
}
