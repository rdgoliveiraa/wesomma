package com.app.wesomma.domain.goal;

import com.app.wesomma.domain.person.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    Goal findById(Integer id);

    void deleteById(Integer id);

    List<Goal> findAllByUserId(Integer id);

    List<Goal> findAllByUser(User user);
}
