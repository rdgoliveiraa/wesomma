package com.app.wesomma.domain.goal;


import com.app.wesomma.application.util.UserUtil;
import com.app.wesomma.domain.person.UserDTO;

public class GoalDTO implements Comparable<GoalDTO> {

    public GoalDTO(Goal goal) {
        this.id = goal.getId();
        this.goalType = goal.getGoalType();
        this.totalValue = goal.getTotalValue();
        this.currentValue = goal.getCurrentValue();
        this.description= goal.getDescription();
        this.user = UserUtil.parse(goal.getPerson(), false);
    }

    private Integer id;

    private GoalType goalType;

    private Double totalValue;

    private Double currentValue;

    private String description;

    private UserDTO user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public int compareTo(GoalDTO goalDTO) {
        if (this.id != null && this.id > goalDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < goalDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
