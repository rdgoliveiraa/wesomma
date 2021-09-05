package com.app.wesomma.application.resource;

import com.app.wesomma.application.util.UserUtil;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserDTO;
import com.app.wesomma.domain.person.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class LoginResource {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public UserDTO login(@RequestBody User user) {
        User userValidate = userRepository.findByEmail(user.getEmail());
        if(userValidate != null && user.getPassword().equals(userValidate.getPassword())) {
            return UserUtil.parse(userRepository.findByEmail(user.getEmail()), true);
        }
        return null;
    }
}
