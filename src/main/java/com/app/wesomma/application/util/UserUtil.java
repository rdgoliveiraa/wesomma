package com.app.wesomma.application.util;


import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserDTO;
import com.app.wesomma.domain.transaction.TransactionDTO;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private UserUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static UserDTO parse(User user, boolean createPerson) {
        return new UserDTO(user, createPerson);
    }

    public static UserDTO parse(User user) {
        return new UserDTO(user);
    }

    public static List<UserDTO> parseList(List<User> people, boolean createPerson) {
        List<UserDTO> personsDTO = new ArrayList<>();
        for (User user: people) {
            UserDTO userDTO = new UserDTO(user, createPerson);
            personsDTO.add(userDTO);
        }
        return personsDTO;
    }

    public static List<User> parseListPersonDTOToPerson(List<UserDTO> usersDTO) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO: usersDTO) {
            User person = new User(userDTO);
            users.add(person);
        }
        return users;
    }
}
