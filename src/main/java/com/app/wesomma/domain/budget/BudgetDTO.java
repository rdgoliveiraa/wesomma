package com.app.wesomma.domain.budget;


import com.app.wesomma.application.util.BudgetCategoryUtil;
import com.app.wesomma.application.util.GroupUtil;
import com.app.wesomma.application.util.UserUtil;
import com.app.wesomma.domain.group.GroupDTO;
import com.app.wesomma.domain.person.UserDTO;

import java.util.Date;
import java.util.List;

public class BudgetDTO implements Comparable<BudgetDTO> {

    public BudgetDTO(Budget budget) {
        this.id = budget.getId();
        this.name = budget.getName();
        this.expectedValue = budget.getExpectedValue();
        this.realizedValue = budget.getRealizedValue();
        this.reminder = budget.getReminder();
        this.open = budget.isOpen();
        this.period = budget.getPeriod();
        this.groupDTO = GroupUtil.parseFamilyToGroupDTO(budget.getFamily());
        this.userDTO = UserUtil.parse(budget.getUser(), false);
        this.budgetCategoriesDtos = BudgetCategoryUtil.parseList(budget.getBudgetCategories());

    }

    private Integer id;

    private String name;

    private Double expectedValue;

    private Double realizedValue;

    private Boolean reminder;

    private Boolean open;

    private Date period;

    private GroupDTO groupDTO;

    private UserDTO userDTO;

    private List<BudgetCategoryDTO> budgetCategoriesDtos;

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

    public Boolean getReminder() {
        return reminder;
    }

    public void setReminder(Boolean reminder) {
        this.reminder = reminder;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    @Override
    public int compareTo(BudgetDTO budgetDTO) {
        if (this.id != null && this.id > budgetDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < budgetDTO.getId()) {
            return 1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRealizedValue() {
        return realizedValue;
    }

    public void setRealizedValue(Double realizedValue) {
        this.realizedValue = realizedValue;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }

    public void setGroupDTO(GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUser(UserDTO personDTO) {
        this.userDTO = personDTO;
    }

    public List<BudgetCategoryDTO> getBudgetCategoriesDTO() {
        return budgetCategoriesDtos;
    }

    public void setBudgetCategoryDTO(List<BudgetCategoryDTO> budgetCategoriesDtos) {
        this.budgetCategoriesDtos = budgetCategoriesDtos;
    }
}
