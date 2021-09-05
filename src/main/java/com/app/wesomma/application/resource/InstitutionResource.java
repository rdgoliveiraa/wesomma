package com.app.wesomma.application.resource;

import com.app.wesomma.domain.institution.Institution;
import com.app.wesomma.domain.institution.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class InstitutionResource {

    @Autowired
    InstitutionRepository institutionRepository;

    @GetMapping("/institutions")
    public List<Institution> findAll(){
        return institutionRepository.findAll();
    }

    @GetMapping("/institution/{id}")
    public Institution findById(@PathVariable(value = "id") Integer id) {
        return institutionRepository.findById(id);
    }

    @PostMapping("/institution")
    public Institution save(@RequestBody Institution institution) {
        return institutionRepository.save(institution);
    }

    @DeleteMapping("/institution")
    public void delete(@RequestBody Institution institution) {
        institutionRepository.delete(institution);
    }

    @PutMapping("/institution")
    public Institution update(@RequestBody Institution institution) {
        return institutionRepository.save(institution);
    }

}
