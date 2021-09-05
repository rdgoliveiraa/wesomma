package com.app.wesomma.application.util;


import com.app.wesomma.domain.goal.Goal;
import com.app.wesomma.domain.goal.GoalDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GoalUtil {

    private GoalUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static GoalDTO parse(Goal goal){
        return new GoalDTO(goal);
    }

    public static List<GoalDTO> parseList(List<Goal> goals) {
        return goals.stream().map(GoalDTO::new).collect(Collectors.toList());
    }
}
