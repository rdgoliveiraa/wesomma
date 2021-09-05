package com.app.wesomma.domain.repetition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepetitionRepository extends JpaRepository<TypeRepetition, Long> {
    TypeRepetition findById(Integer id);
}
