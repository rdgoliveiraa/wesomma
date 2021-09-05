package com.app.wesomma.domain.income;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    Income findById(Integer id);
}
