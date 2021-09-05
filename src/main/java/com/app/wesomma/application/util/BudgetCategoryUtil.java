package com.app.wesomma.application.util;


import com.app.wesomma.domain.budget.BudgetCategory;
import com.app.wesomma.domain.budget.BudgetCategoryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BudgetCategoryUtil {

    private BudgetCategoryUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static BudgetCategoryDTO parse(BudgetCategory budgetCategory){
        return new BudgetCategoryDTO(budgetCategory);
    }

    public static List<BudgetCategoryDTO> parseList(List<BudgetCategory> budgetCategories) {
        return budgetCategories.stream().map(BudgetCategoryDTO::new).collect(Collectors.toList());
    }
}
