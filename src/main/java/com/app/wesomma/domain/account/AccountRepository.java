package com.app.wesomma.domain.account;

import com.app.wesomma.domain.person.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findById(Long id);

    Page<Account> findAllByUserId(Integer id, Pageable pagination);

    void deleteById(Long id);

    List<Account> getByUser(User user);
}
