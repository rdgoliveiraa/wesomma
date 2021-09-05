package com.app.wesomma.application.util;


import com.app.wesomma.domain.transaction.Transaction;
import com.app.wesomma.domain.transaction.TransactionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionUtil {

    private TransactionUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static TransactionDTO parse(Transaction transaction){
        return new TransactionDTO(transaction);
    }

    public static List<TransactionDTO> parseList(List<Transaction> transactions) {
        return transactions.stream().map(TransactionDTO::new).collect(Collectors.toList());
    }
}
