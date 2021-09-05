package com.app.wesomma.domain.institution;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Institution findById(Integer id);

    Institution findByDescription(String description);
}
