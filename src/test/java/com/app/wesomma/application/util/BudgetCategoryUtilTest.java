package com.app.wesomma.application.util;

import com.app.wesomma.domain.budget.BudgetCategory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BudgetCategoryUtilTest {


    @Test
    public void deveRetornarUmBudgetCategoryComConteudo() {
        List<BudgetCategory> budgetCategoriesList = new ArrayList<>();
        BudgetCategory budgetCategory = new BudgetCategory();
        budgetCategory.setId(1);

        budgetCategoriesList.add(budgetCategory);

        assertEquals(Integer.valueOf(1), BudgetCategoryUtil.parseList(budgetCategoriesList).get(0).getId());
    }

    @Test
    public void deveRetornarUmaListaDeBudgetCategoryDTO() {
        List<BudgetCategory> budgetCategoriesList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            BudgetCategory budgetCategory = new BudgetCategory();
            budgetCategory.setId(1);
            budgetCategoriesList.add(budgetCategory);
        }

        assertEquals(3, BudgetCategoryUtil.parseList(budgetCategoriesList).size());
    }



}