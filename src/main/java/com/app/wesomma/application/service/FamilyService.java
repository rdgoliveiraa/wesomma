package com.app.wesomma.application.service;

import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.person.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    @Autowired
    GroupRepository groupRepository;

    public Family createFamily(User user) {
        Family family = new Family();
        if (user.getFamily() == null) {
            family = new Family(null, user.getName().concat("'s"), null ,null);
            family = groupRepository.save(family);
            family.setLeader(user);
        }
        return family;
    }
}
