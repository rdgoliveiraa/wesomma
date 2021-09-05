package com.app.wesomma.application.resource;

import com.app.wesomma.domain.account.AccountType;
import com.app.wesomma.domain.account.TypeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class TypeAccountResource {

    @Autowired
    TypeAccountRepository typeAccountRepository;

    @GetMapping("/typeaccounts")
    public List<AccountType> findAll(){
        return typeAccountRepository.findAll();
    }

    @GetMapping("/typeaccount/{id}")
    public AccountType findById(@PathVariable(value = "id") Integer id) {
        return typeAccountRepository.findById(id);
    }

    @PostMapping("/typeaccount")
    public AccountType save(@RequestBody AccountType accountType) { return typeAccountRepository.save(accountType); }

    @DeleteMapping("/typeaccount")
    public void delete(@RequestBody AccountType accountType) { typeAccountRepository.delete(accountType); }

    @PutMapping("/typeaccount")
    public AccountType update(@RequestBody AccountType accountType) {
        return typeAccountRepository.save(accountType);
    }
}
