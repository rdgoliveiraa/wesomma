package com.app.wesomma.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAccountRepository extends JpaRepository<AccountType, Long> {
    AccountType findById(Integer id);
}
