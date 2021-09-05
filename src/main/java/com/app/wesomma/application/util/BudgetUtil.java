package com.app.wesomma.application.util;


import com.app.wesomma.domain.budget.Budget;
import com.app.wesomma.domain.budget.BudgetDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BudgetUtil {

    private BudgetUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static BudgetDTO parse(Budget budget){
        return new BudgetDTO(budget);
    }

    public static List<BudgetDTO> parseList(List<Budget> budgets) {
        return budgets.stream().map(BudgetDTO::new).collect(Collectors.toList());
    }
}
