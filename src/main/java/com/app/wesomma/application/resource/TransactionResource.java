package com.app.wesomma.application.resource;


import com.app.wesomma.application.util.TransactionUtil;
import com.app.wesomma.domain.account.Account;
import com.app.wesomma.domain.account.AccountRepository;
import com.app.wesomma.domain.budget.*;
import com.app.wesomma.domain.category.CategoryRepository;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import com.app.wesomma.domain.transaction.Transaction;
import com.app.wesomma.domain.transaction.TransactionDTO;
import com.app.wesomma.domain.transaction.TransactionRepository;
import com.app.wesomma.domain.transaction.TypeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class TransactionResource {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TypeTransactionRepository typeTransactionRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BudgetCategoryRepository budgetCategoryRepository;

    @GetMapping("/transactions")
    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    @GetMapping("/transaction/{id}")
    public TransactionDTO findById(@PathVariable(value = "id") Integer id) {
        return TransactionUtil.parse(transactionRepository.findById(id));
    }

    @GetMapping("/transactions/{person_id}")
    public List<TransactionDTO> findByPerson(@PathVariable(value = "person_id") Long personId) {
        User user = new User();
        user.setId(personId);
        //List<Account> accountList = accountRepository.findAllByPersonId(personId);
        List<Account> accountList = new ArrayList<>();
        List<Transaction> transactionList = new ArrayList<>();
        if(accountList != null) {
            for(Account account : accountList) {
                transactionList.addAll(transactionRepository.findByAccount(account));
            }
        }
        return TransactionUtil.parseList(transactionList);
    }

    @GetMapping("/transactions/group/{group_id}")
    public List<TransactionDTO> findByGroup(@PathVariable(value = "group_id") Long groupId) {
        Family group = new Family(groupId);
        List<User> userList = userRepository.findByFamily(group);

        List<Account> accountList = new ArrayList<>();
        for(User user : userList) {
            accountList.addAll(accountRepository.getByUser(user));
        }

        List<Transaction> transactionList = new ArrayList<>();

        for(Account account : accountList) {
            transactionList.addAll(transactionRepository.findByAccount(account));
        }

        return TransactionUtil.parseList(transactionList);
    }

    /*
    @PostMapping("/transaction")
    public TransactionDTO save(@RequestBody Transaction transaction) {

        Account account = updateAccoutBalance(transaction, 2);

        typeTransactionRepository.save(transaction.getTypeTransaction());
        categoryRepository.save(transaction.getCategory());
        accountRepository.save(account);

        Optional<User> user = userRepository.findById(account.getUser().getId());
        Family family = groupRepository.findById(user.get().getFamily().getId());


        updateBudgetValueRealized(transaction, family);

        return TransactionUtil.parse(transactionRepository.save(transaction));
    }
*/
    private void updateBudgetValueRealized(Transaction transaction, Family family) {
        Budget budget = budgetRepository.findByFamily(family);
        if(budget != null) {
            if(2 == transaction.getTypeTransaction().getId()) {
                boolean validateBudget = false;
                int intBudget= 0;
                for (int i =0; i < budget.getBudgetCategories().size(); i++) {
                    if (budget.getBudgetCategories().get(i).getCategory().getDescription().equals(transaction.getCategory().getDescription())) {
                        validateBudget = true;
                        intBudget = i;
                        break;
                    }
                }
                if(validateBudget == true) {
                    updateBudgetCategory(transaction, budget, intBudget);
                } else {
                    createBudgetCategory(transaction, budget);
                }
            }
            budgetRepository.save(budget);
        }
    }

    private void createBudgetCategory(Transaction transaction, Budget budget) {
        BudgetCategory budgetCategory = new BudgetCategory();
        budgetCategory.setBudget(budget);
        budgetCategory.setCategory(transaction.getCategory());
        budgetCategory.setExpectedValue(0.00);
        budgetCategory.setRealizedValue(transaction.getValue());
        budgetCategory.setTypeBudget(new TypeBudget(2, "SAÍDA"));
        budgetCategoryRepository.save(budgetCategory);
        budget.setRealizedValue(budget.getRealizedValue() + transaction.getValue());
    }

    private void updateBudgetCategory(Transaction transaction, Budget budget, int i) {
        budget.getBudgetCategories().get(i).setRealizedValue(budget.getBudgetCategories().get(i).getRealizedValue() + transaction.getValue());
        budgetCategoryRepository.save(budget.getBudgetCategories().get(i));
        budget.setRealizedValue(budget.getRealizedValue() + transaction.getValue());
    }

    /*
    private Account updateAccoutBalance(@RequestBody Transaction transaction, int value) {
        Account account = accountRepository.findById(transaction.getAccount().getId());
        if (value == transaction.getTypeTransaction().getId()) {
            account.setBalance(account.getBalance() - transaction.getValue());
        } else {
            account.setBalance(account.getBalance() + transaction.getValue());
        }
        return account;
    }
*/
    @DeleteMapping("/transaction/{id}")
    public void delete(@PathVariable(value="id") Integer id) {
     /*   Transaction transaction = transactionRepository.findById(id);

        Account account = accountRepository.findById(transaction.getAccount().getId());
        if(1 == transaction.getTypeTransaction().getId()) {
            account.setBalance(account.getBalance() - transaction.getValue());
        } else {
            account.setBalance(account.getBalance() + transaction.getValue());
        }

        typeTransactionRepository.save(transaction.getTypeTransaction());
        categoryRepository.save(transaction.getCategory());
        accountRepository.save(account);

        Optional<User> user = userRepository.findById(account.getUser().getId());
        Family family = groupRepository.findById(user.get().getFamily().getId());

        Budget budget = budgetRepository.findByFamily(family);
        if(1 == transaction.getTypeTransaction().getId()) {
            for (BudgetCategory budgetCategory :budget.getBudgetCategories()) {
                if(budgetCategory.getCategory().equals(transaction.getCategory())) {
                    budget.getBudgetCategories().get(0).setRealizedValue(budget.getBudgetCategories().get(0).getRealizedValue() - transaction.getValue());
                }
            }
        }

        accountRepository.save(account);

        transactionRepository.deleteById(id);*/
    }

    @PutMapping("/transaction")
    public TransactionDTO update(@RequestBody Transaction transaction) {
        return TransactionUtil.parse(transactionRepository.save(transaction));
    }
}
