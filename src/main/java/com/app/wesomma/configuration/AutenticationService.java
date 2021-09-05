package com.app.wesomma.configuration;

import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByEmail(username));
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos!");
    }
}
