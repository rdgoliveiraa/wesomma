package com.app.wesomma.domain.transaction;

import com.app.wesomma.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findById(Integer id);

    void deleteById(Integer id);

    List<Transaction> findByAccount(Account account);

}
