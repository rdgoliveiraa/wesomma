package com.app.wesomma.domain.person;

import com.app.wesomma.application.util.GroupUtil;
import com.app.wesomma.domain.group.GroupDTO;
import com.app.wesomma.domain.profile.Profile;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserDTO implements Comparable<UserDTO> {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastName;

    private List<Profile> profiles;

    private Boolean active;

    private GroupDTO groupDTO;

    private boolean createFamily;

    public UserDTO(User user, boolean createPerson) {

    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.profiles = user.getProfiles();
        if(user.getActive() != null) {
            this.active = user.getActive();
        }
        if(user.getFamily() != null) {
            this.groupDTO = GroupUtil.parseFamilyToGroupDTO(user.getFamily());
        }
    }

    public static Page<UserDTO> converter(Page<User> users) {
        return users.map(UserDTO::new);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Profile> getProfile() {
        return profiles;
    }

    public void setProfile(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }

    public void setGroupDTO(GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public boolean isCreateFamily() {
        return createFamily;
    }

    public void setCreateFamily(boolean createFamily) {
        this.createFamily = createFamily;
    }

    @Override
    public int compareTo(UserDTO userDTO) {
        if (this.id != null && this.id > userDTO.getId()) {
            return -1;
        } else if(this.id != null && this.id < userDTO.getId()) {
            return 1;
        }
        return 0;
    }
}
