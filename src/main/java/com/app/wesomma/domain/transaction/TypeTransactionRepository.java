package com.app.wesomma.domain.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeTransactionRepository extends JpaRepository<TypeTransaction, Long> {
    TypeTransaction findById(Integer id);
}
