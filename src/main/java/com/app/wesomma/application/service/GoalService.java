package com.app.wesomma.application.service;

import com.app.wesomma.domain.goal.Goal;
import com.app.wesomma.domain.goal.GoalRepository;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.person.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GoalRepository goalRepository;

    public List<Goal> findByGroup(Long groupId) {
        Optional<Family> family = groupRepository.findById(groupId);
        List<Goal> goals = new ArrayList<>();
        for(User user : family.get().getUser()) {
            goals.addAll(goalRepository.findAllByUser(user));
        }
        return goals;
    }
}
