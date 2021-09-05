package com.app.wesomma.domain.budget;

import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.person.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Budget findById(Integer id);

    List<Budget> open(boolean open);

    Budget findByFamily(Family family);

    List<Budget> findAllByFamilyId(Integer id);

    List<Budget> findAllByUser(User user);
}
