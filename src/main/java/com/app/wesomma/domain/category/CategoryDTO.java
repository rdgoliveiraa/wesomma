package com.app.wesomma.domain.category;

public class CategoryDTO implements Comparable<CategoryDTO> {

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
    public int compareTo(CategoryDTO categoryDTO) {
        if (this.id != null && this.id > categoryDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < categoryDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
