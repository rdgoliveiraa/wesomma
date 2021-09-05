package com.app.wesomma.application.resource;


import com.app.wesomma.domain.profile.Profile;
import com.app.wesomma.domain.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class ProfileResource {

	@Autowired
	ProfileRepository profileRepository;
	
	@GetMapping("/profiles")
	public List<Profile> findAll(){
		return profileRepository.findAll();
	}
	
	@GetMapping("/profile/{id}")
	public Profile findById(@PathVariable(value = "id") Integer id) {
		return profileRepository.findById(id);
	}
	
	@PostMapping("/profile")
	public Profile save(@RequestBody Profile profile) {
		return profileRepository.save(profile);
	}
	
	@DeleteMapping("/profile/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		profileRepository.deleteById(id);
	}
	
	@PutMapping("/profile")
	public Profile update(@RequestBody Profile profile) {
		return profileRepository.save(profile);
	}
	
}
