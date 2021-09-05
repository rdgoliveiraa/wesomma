package com.app.wesomma.application.resource;

import com.app.wesomma.application.form.AccountForm;
import com.app.wesomma.application.service.AccountService;
import com.app.wesomma.application.util.AccountUtil;
import com.app.wesomma.domain.account.Account;
import com.app.wesomma.domain.account.AccountDTO;
import com.app.wesomma.domain.account.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Transactional
@RestController
@RequestMapping(value="/api/account")
@CrossOrigin(origins = "*")
public class AccountResource {

    private static Logger logger = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

/*
    @GetMapping
    public ResponseEntity<AccountDTO> detailById(@PathVariable Long id) {
        logger.info("Iniciando findById id: " + id);
        Optional<Account> optional = Optional.ofNullable(accountRepository.findById(id));
        return optional.map(value -> ResponseEntity.ok(new AccountDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
*/
    @RequestMapping(value="/person/{person_id}", method = RequestMethod.GET)
    public Page<AccountDTO> listAllByPerson(@RequestParam Integer personId,
                                            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pagination){
        logger.info("Iniciando listAllByPerson personId: " + personId);

        Page<Account> accounts = accountRepository.findAllByUserId(personId, pagination);
        return AccountDTO.converter(accounts);
    }

    @RequestMapping(value="/accounts/group/{group_id}", method = RequestMethod.GET)
    public ResponseEntity<List<AccountDTO>> findAllByGroup(@PathVariable Long group_id){
        logger.info("Iniciando findAllByGroup groupId: " + group_id);
        List<Account> accounts = accountService.getAccounts(group_id);

        return ResponseEntity.ok(AccountUtil.parseList(accounts));
    }

    @RequestMapping(value="/account/totalbalance/{group_id}", method = RequestMethod.GET)
    public ResponseEntity<Double> getTotalSumAccount(@PathVariable(value = "group_id") Long id) {
        logger.info("Iniciando getTotalSumAccount groupId: " + id);
        return ResponseEntity.ok(accountService.totalSumAccount(id));
    }

    @PostMapping
    public ResponseEntity<AccountDTO> register(@RequestBody @Valid AccountForm accountForm, UriComponentsBuilder uriBuilder) {
        Account account = accountForm.converter();
        accountService.save(account);

        URI uri = uriBuilder.path("/account/{id}").buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(uri).body(AccountUtil.parse(accountRepository.save(account)));
    }
/*
    @DeleteMapping
    public ResponseEntity<?> remove(@PathVariable(value="id") Long id) {
        Optional<Account> optional = Optional.ofNullable(accountRepository.findById(id));
        if (optional.isPresent()) {
            accountRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<AccountDTO> update(@PathVariable Long id, @RequestBody @Valid AccountForm accountForm) {
        Optional<Account> optional = Optional.ofNullable(accountRepository.findById(id));
        return optional.map(value -> ResponseEntity.ok(new AccountDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }*/
}
