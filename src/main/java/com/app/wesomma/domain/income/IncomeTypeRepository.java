package com.app.wesomma.domain.income;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeTypeRepository extends JpaRepository<IncomeType, Long> {
    IncomeType findById(Integer id);
}
