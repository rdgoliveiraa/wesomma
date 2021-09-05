package com.app.wesomma.application.resource;

import com.app.wesomma.application.service.GoalService;
import com.app.wesomma.application.util.GoalUtil;
import com.app.wesomma.domain.goal.Goal;
import com.app.wesomma.domain.goal.GoalDTO;
import com.app.wesomma.domain.goal.GoalRepository;
import com.app.wesomma.domain.goal.GoalTypeRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class GoalResource {

    @Autowired
    GoalRepository goalRepository;

    @Autowired
    GoalTypeRepository goalTypeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GoalService goalService;

    @GetMapping("/goals")
    public List<Goal> findAll(){
        return goalRepository.findAll();
    }

    @GetMapping("/goal/{id}")
    public Goal findById(@PathVariable(value = "id") Integer id) {
        return goalRepository.findById(id);
    }

    @GetMapping("/goals/{person_id}")
    public List<GoalDTO> findAllByPerson(@PathVariable (value ="person_id") Integer personId){
        return GoalUtil.parseList(goalRepository.findAllByUserId(personId));
    }

    @GetMapping("/goals/group/{group_id}")
    public List<GoalDTO> findAllByGroup(@PathVariable (value ="group_id") Long groupId){
        List<Goal> goals = goalService.findByGroup(groupId);
        return GoalUtil.parseList(goals);
    }

    @PostMapping("/goal")
    public GoalDTO save(@RequestBody Goal goal) {
        User person = userRepository.findByEmail(goal.getPerson().getEmail());
        goal.setPerson(person);
        goalTypeRepository.save(goal.getGoalType());
        Goal goalSaved = goalRepository.save(goal);
        return GoalUtil.parse(goalSaved);
    }

    @DeleteMapping("/goal/{id}")
    public void delete(@PathVariable(value="id") Integer id) {
        Goal goal = goalRepository.findById(id);
        goalRepository.delete(goal);
    }

    @PutMapping("/goal")
    public GoalDTO update(@RequestBody Goal goal) {
        return GoalUtil.parse(goalRepository.save(goal));
    }
}
