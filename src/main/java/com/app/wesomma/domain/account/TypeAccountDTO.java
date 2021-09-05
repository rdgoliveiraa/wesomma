package com.app.wesomma.domain.account;

public class TypeAccountDTO implements Comparable<TypeAccountDTO> {

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
    public int compareTo(TypeAccountDTO typeAccountDTO) {
        if (this.id != null && this.id > typeAccountDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < typeAccountDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
