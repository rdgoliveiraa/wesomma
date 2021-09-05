package com.app.wesomma.application.form;

import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.profile.Profile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class UserForm {

    @NotNull
    @NotEmpty
    @Length(max = 15)
    private String name;

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String lastName;

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 8, max = 80)
    private String password;

    @NotNull
    @NotEmpty
    private List<Profile> profiles;

    private Family family;

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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public User converter() {
        User user = new User();
        user.setName(this.name);
        user.setLastName(this.lastName);
        user.setProfiles(this.profiles);
        user.setFamily(this.family);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
