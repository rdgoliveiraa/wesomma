package com.app.wesomma.domain.income;


import com.app.wesomma.domain.person.User;

public class IncomeDTO implements Comparable<IncomeDTO> {

    private Integer id;

    private Double value;

    private Boolean fix;

    private IncomeType incomeType;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getFix() {
        return fix;
    }

    public void setFix(Boolean fix) {
        this.fix = fix;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    public User getUser() {
        return user;
    }

    public void setPessoa(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(IncomeDTO incomeDTO) {
        if (this.id != null && this.id > incomeDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < incomeDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
