package com.app.wesomma.application.form;

import com.app.wesomma.domain.account.Account;
import com.app.wesomma.domain.account.AccountType;
import com.app.wesomma.domain.institution.Institution;
import com.app.wesomma.domain.person.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountForm {

    @NotNull
    @NotEmpty
    @Length(max = 10)
    private String agency;

    @NotNull
    @NotEmpty
    @Length(max = 15)
    private String number;

    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String name;

    @NotNull
    @NotEmpty
    private Double balance;

    private Institution institution;

    private AccountType accountType;

    private User user;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account converter() {
        Account account = new Account();
        account.setAgency(this.agency);
        account.setNumber(this.number);
        account.setName(this.name);
        account.setBalance(this.balance);
        account.setInstitution(this.institution);
        account.setAccountType(this.accountType);
        return account;
    }
}
