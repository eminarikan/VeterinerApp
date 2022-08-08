package dev.tttm.veterinerapp;

import dev.tttm.veterinerapp.models.User;
import dev.tttm.veterinerapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DatabaseSeeder(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findAll().size() == 0){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("pass"));
            admin.setRole(Constant.ADMIN);

            User owner = new User();
            owner.setUsername("user");
            owner.setPassword(passwordEncoder.encode("pass"));
            owner.setRole(Constant.USER);

            userRepository.save(admin);
            userRepository.save(owner);
        }
    }
}
