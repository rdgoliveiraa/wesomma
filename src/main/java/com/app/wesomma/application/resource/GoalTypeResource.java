package com.app.wesomma.application.resource;

import com.app.wesomma.domain.goal.GoalType;
import com.app.wesomma.domain.goal.GoalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class GoalTypeResource {

    @Autowired
    GoalTypeRepository goalTypeRepository;

    @GetMapping("/goaltypes")
    public List<GoalType> findAll(){
        return goalTypeRepository.findAll();
    }

    @GetMapping("/goaltype/{id}")
    public GoalType findById(@PathVariable(value = "id") Integer id) {
        return goalTypeRepository.findById(id);
    }

    @PostMapping("/goaltype")
    public GoalType save(@RequestBody GoalType goalType) {

        return goalTypeRepository.save(goalType); }

    @DeleteMapping("/goaltype")
    public void delete(@RequestBody GoalType goalType) { goalTypeRepository.delete(goalType);}

    @PutMapping("/goaltype")
    public GoalType update(@RequestBody GoalType goalType) {
        return goalTypeRepository.save(goalType);
    }
}
