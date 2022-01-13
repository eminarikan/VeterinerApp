package dev.tttm.veterinerapp.services;

import dev.tttm.veterinerapp.models.MyUserDetails;
import dev.tttm.veterinerapp.models.User;
import dev.tttm.veterinerapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (username == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı!");
        }

        return new MyUserDetails(user);
    }
}
