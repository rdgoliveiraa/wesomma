package com.app.wesomma.domain.person;

import com.app.wesomma.domain.group.Family;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByFamily(Family family);

    Page<User> findAllByFamilyId(Long familyId, Pageable pagination);
}
