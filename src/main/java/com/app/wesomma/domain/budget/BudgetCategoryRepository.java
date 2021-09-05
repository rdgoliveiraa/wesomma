package com.app.wesomma.domain.budget;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetCategoryRepository extends JpaRepository<BudgetCategory, Long> {
    BudgetCategory findById(Integer id);

    List<BudgetCategory> findByBudget(Budget budget);
}
