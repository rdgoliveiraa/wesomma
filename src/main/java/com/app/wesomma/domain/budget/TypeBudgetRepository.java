package com.app.wesomma.domain.budget;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeBudgetRepository extends JpaRepository<TypeBudget, Long> {
    TypeBudget findById(Integer id);
}
