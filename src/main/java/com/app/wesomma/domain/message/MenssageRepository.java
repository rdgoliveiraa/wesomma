package com.app.wesomma.domain.message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenssageRepository extends JpaRepository<Message, Long> {
    Message findById(Integer id);
}
