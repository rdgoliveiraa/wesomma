package com.app.wesomma.application.resource;

import com.app.wesomma.application.util.GroupUtil;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupDTO;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class GroupResource {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/groups")
    public List<GroupDTO> findAll(){
        return GroupUtil.parseList(groupRepository.findAll());
    }

    @GetMapping("/group/{id}")
    public Family findById(@PathVariable(value = "id") Long id) {
        return groupRepository.findById(id).orElse(new Family());
    }

    @GetMapping("/groups/{person_id}")
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<GroupDTO> findAllByUser(@PathVariable(value = "person_id") Long user_id) {

        Optional<User> user = userRepository.findById(user_id);

        List<Family> families = new ArrayList<>();
        if(user.isPresent()) {
            families = groupRepository.findAllById(user.get().getFamily().getId());
        }
        return GroupUtil.parseList(families);
    }

    @PostMapping("/group")
    public GroupDTO save(@RequestBody Family family) {
        List<User> addPeople = new ArrayList<>();
        List<User> removePeople = new ArrayList<>();
        for(User user : family.getUser()) {
            Optional<User> personExist = userRepository.findById(user.getId());
            if(personExist.isPresent()) {
                removePeople.add(user);
                addPeople.add(personExist.get());
            }
        }
        family.getUser().removeAll(removePeople);
        family.getUser().addAll(addPeople);
        return GroupUtil.parseFamilyToGroupDTO(groupRepository.save(family));
    }

    @DeleteMapping("/group/{id}")
    public void delete(@PathVariable(value="id") Long id) {
        Optional<Family> family = groupRepository.findById(id);
        groupRepository.delete(family.orElse(new Family()));
    }

    @PutMapping("/group")
    public GroupDTO update(@RequestBody Family family) {
        List<User> people = userRepository.findByFamily(family);
        family.getLeader().setFamily(family);
        family.setPeople(people);
        Family familySaved = groupRepository.save(family);
        GroupDTO groupDTO = GroupUtil.parseFamilyToGroupDTO(familySaved);
        family.getLeader().setFamily(family);
        return groupDTO;
    }
}
