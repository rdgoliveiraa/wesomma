package com.app.wesomma.domain.account;


import com.app.wesomma.application.util.UserUtil;
import com.app.wesomma.domain.institution.Institution;
import com.app.wesomma.domain.person.UserDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public class AccountDTO implements Comparable<AccountDTO> {
    private Integer id;

    private String name;

    private String agency;

    private String number;

    private Institution institution;

    private AccountType accountType;

    private Double balance;

    private UserDTO user;

    public UserDTO getPerson() {
        return user;
    }

    public void setPerson(UserDTO user) {
        this.user = user;
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.agency = account.getAgency();
        this.number = account.getNumber();
        this.institution = account.getInstitution();
        this.balance = account.getBalance();
        if(account.getUser() != null) {
            this.user = UserUtil.parse(account.getUser(), false);
        }
        this.accountType = account.getAccountType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return  name; }

    public void setName(String name) { this.name = name; }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Institution getInstitution() { return institution; }

    public void setInstitution(Institution institution) { this.institution = institution; }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public int compareTo(AccountDTO accountDTO) {
        if (this.balance != null && this.balance > accountDTO.getBalance()) {
            return -1;
        } else if(this.balance != null && this.balance < accountDTO.getBalance()) {
            return 1;
        }
        return 0;
    }

    public static Page<AccountDTO> converter(Page<Account> accounts) {
        return accounts.map(AccountDTO::new);
    }
}
