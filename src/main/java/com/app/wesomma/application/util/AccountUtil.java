package com.app.wesomma.application.util;


import com.app.wesomma.application.resource.AccountResource;
import com.app.wesomma.domain.account.Account;
import com.app.wesomma.domain.account.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AccountUtil {

    private static Logger logger = LoggerFactory.getLogger(AccountResource.class);

    private AccountUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static AccountDTO parse(Account account){
        return new AccountDTO(account);
    }

    public static List<AccountDTO> parseList(List<Account> accounts) {
        logger.info("Realizando parse de accounts");
        return accounts.stream().map(AccountDTO::new).collect(Collectors.toList());
    }
}
