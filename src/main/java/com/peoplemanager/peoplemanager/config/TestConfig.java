package com.peoplemanager.peoplemanager.config;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.CollaboratorRepository;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public void run(String... args) throws Exception {


        User u1 = new User(null, "camila@gmail.com", "12345678", "Camila");
        User u2 = new User(null, "vitor@gmail.com", "123456789", "Vitor");

        Collaborator c1 = new Collaborator(null, "Vítoria", "vitoria@gmail.com", "Rep", u1);
        Collaborator c2 = new Collaborator(null, "Adison", "adison@gmail.com", "Rep", u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        collaboratorRepository.saveAll(Arrays.asList(c1, c2));
    }
}
