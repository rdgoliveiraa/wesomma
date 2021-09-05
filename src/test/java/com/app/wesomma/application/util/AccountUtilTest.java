package com.app.wesomma.application.util;

import com.app.wesomma.domain.account.Account;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountUtilTest {


    @Test
    public void deveRetornarUmaContaComConteudo() {
        List<Account> accountList = new ArrayList<>();
        Account account = new Account(1, "agencia", "number", "name", 0.0, null, null, null);
        accountList.add(account);

        assertEquals("agencia", AccountUtil.parseList(accountList).get(0).getAgency());
    }

    @Test
    public void deveRetornarUmaListaDeAccountDTO() {
        List<Account> accountList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Account account = new Account(i, "agencia", "number", "name", 0.0, null, null, null);
            accountList.add(account);
        }

        assertEquals(3, AccountUtil.parseList(accountList).size());
    }



}