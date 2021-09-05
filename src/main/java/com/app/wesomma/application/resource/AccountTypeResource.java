package com.app.wesomma.application.resource;

import com.app.wesomma.domain.account.AccountType;
import com.app.wesomma.domain.account.AccountTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class AccountTypeResource {

    private static Logger logger = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @GetMapping("/accounttypes")
    public List<AccountType> findAll(){
        logger.info("Iniciando findAll");
        return accountTypeRepository.findAll();
    }

    @GetMapping("/accounttype/{id}")
    public AccountType findById(@PathVariable(value = "id") Integer id) {
        logger.info("Iniciando findById id: " + id);
        return accountTypeRepository.findById(id);
    }

    @PostMapping("/accounttype")
    public AccountType save(@RequestBody AccountType accountType) {
        logger.info("Iniciando save");
        return accountTypeRepository.save(accountType);
    }

    @DeleteMapping("/accounttype")
    public void delete(@RequestBody AccountType accountType) {
        logger.info("Iniciando delete");
        accountTypeRepository.delete(accountType);
    }

    @PutMapping("/accounttype")
    public AccountType update(@RequestBody AccountType accountType) {
        logger.info("Iniciando update");
        return accountTypeRepository.save(accountType);
    }
}
