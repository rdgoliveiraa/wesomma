package com.app.wesomma.domain.group;


import com.app.wesomma.application.util.UserUtil;
import com.app.wesomma.domain.person.UserDTO;

import java.util.List;

public class GroupDTO implements Comparable<GroupDTO> {
    public GroupDTO() {}

    public GroupDTO(Family family, boolean createPerson) {
        this.createPerson = createPerson;
            this.id = family.getId();
        this.name = family.getName();
        this.people = UserUtil.parseList(family.getUser(), false);
        this.leader = UserUtil.parse(family.getLeader(), false);
    }

    public GroupDTO(Family family) {
        this.id = family.getId();
        this.name = family.getName();
        this.people = UserUtil.parseList(family.getUser(), false);
        this.leader = UserUtil.parse(family.getLeader(), false);
    }


    private Long id;

    private String name;

    private List<UserDTO> people;

    private UserDTO leader;

    private boolean createPerson;


    public List<UserDTO> getPeople() {
        return people;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeople(List<UserDTO> people) {
        this.people = people;
    }

    public UserDTO getLeader() {
        return leader;
    }

    public void setLeader(UserDTO leader) {
        this.leader = leader;
    }

    public boolean isCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(boolean createPerson) {
        this.createPerson = createPerson;
    }

    @Override
    public int compareTo(GroupDTO groupDTO) {
        if (this.id != null && this.id > groupDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < groupDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
