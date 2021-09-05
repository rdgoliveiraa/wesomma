package com.app.wesomma.domain.income;

public class TypeIncomeDTO implements Comparable<TypeIncomeDTO> {

    private Integer id;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(TypeIncomeDTO typeIncomeDTO) {
        if (this.id != null && this.id > typeIncomeDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < typeIncomeDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
