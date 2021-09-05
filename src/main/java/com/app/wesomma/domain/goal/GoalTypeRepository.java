package com.app.wesomma.domain.goal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalTypeRepository extends JpaRepository<GoalType, Long> {
    GoalType findById(Integer id);
}
