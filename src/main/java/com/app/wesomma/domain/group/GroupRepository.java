package com.app.wesomma.domain.group;

import com.app.wesomma.domain.person.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Family, Long> {

    void deleteById(Long id);

    List<Family> findAllByLeader(User leader);

    List<Family> findAllById(Long id);
}
