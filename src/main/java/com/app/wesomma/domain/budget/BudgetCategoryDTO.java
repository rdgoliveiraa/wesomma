package com.app.wesomma.domain.budget;


import com.app.wesomma.domain.category.Category;

public class BudgetCategoryDTO implements Comparable<BudgetCategoryDTO> {

    public BudgetCategoryDTO(BudgetCategory budgetCategory) {
        this.id = budgetCategory.getId();
        this.expectedValue = budgetCategory.getExpectedValue();
        this.realizedValue = budgetCategory.getRealizedValue();
        this.category = budgetCategory.getCategory();

    }

    private Integer id;

    private Double expectedValue;

    private Double realizedValue;

    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(Double expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public int compareTo(BudgetCategoryDTO budgetDTO) {
        if (this.id != null && this.id > budgetDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < budgetDTO.getId()) {
            return 1;
        }
        return 0;
    }

    public Double getRealizedValue() {
        return realizedValue;
    }

    public void setRealizedValue(Double realizedValue) {
        this.realizedValue = realizedValue;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
