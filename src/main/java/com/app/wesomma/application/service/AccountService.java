package com.app.wesomma.application.service;

import com.app.wesomma.domain.account.Account;
import com.app.wesomma.domain.account.AccountRepository;
import com.app.wesomma.domain.account.AccountType;
import com.app.wesomma.domain.account.AccountTypeRepository;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.institution.Institution;
import com.app.wesomma.domain.institution.InstitutionRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private static Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    UserRepository personRepository;

    public List<Account> getAccounts(Long group_id) {
        logger.info("Iniciando getAccounts group_id: " + group_id);

        logger.info("Buscando familia");
        Optional<Family> family = groupRepository.findById(group_id);
        List<Account> accounts =  new ArrayList<>();
        for(User user : family.get().getUser()) {
            logger.info("Varrendo pessoas");
            accounts.addAll(accountRepository.getByUser(user));
        }
        return accounts;
    }

    public Double totalSumAccount(Long id) {
        logger.info("Iniciando totalSumAccount");
        Double total = 0.0;
        if(id == 0) {
            logger.info("Validacao de id entrou em condição de erro, retornando valor 0.0");
            return total;
        }

        Optional<Family> family = groupRepository.findById(id);

        for(User user : family.get().getUser()) {
            List<Account> accounts = accountRepository.getByUser(user);
            for(Account account : accounts) {
                total = total + account.getBalance();
            }
        }
        return total;
    }

    public void save(Account account) {
        logger.info("Iniciando saveA");
        User user = personRepository.findByEmail(account.getUser().getEmail());
        account.setUser(user);
        accountTypeRepository.save(account.getAccountType());
        if(account.getInstitution() != null) {
            institutionRepository.save(account.getInstitution());
        }
    }

    public User createAccount(User user) {
        List<Account> accounts = accountRepository.getByUser(user);
        if (accounts.isEmpty()) {
            AccountType accountType = accountTypeRepository.findByDescription("Dinheiro");
            Institution institution = institutionRepository.findByDescription("Carteira");
            Account account = new Account(null,null, null, "Dinheiro " + user.getName(), 0.00, institution, accountType, user);
            accountRepository.save(account);
        }
        return user;
    }
}
