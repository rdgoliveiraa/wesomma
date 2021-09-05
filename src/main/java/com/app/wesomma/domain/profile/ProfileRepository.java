package com.app.wesomma.domain.profile;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	Profile findById(Integer id);

    void deleteById(Integer id);
}
