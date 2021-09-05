package com.app.wesomma.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
    AccountType findById(Integer id);

    AccountType findByDescription(String description);
}
