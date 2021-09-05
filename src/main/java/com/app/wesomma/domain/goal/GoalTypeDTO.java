package com.app.wesomma.domain.goal;

public class GoalTypeDTO implements Comparable<GoalTypeDTO> {

    private Integer id;

    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int compareTo(GoalTypeDTO goalTypeDTO) {
        if (this.id != null && this.id > goalTypeDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < goalTypeDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
