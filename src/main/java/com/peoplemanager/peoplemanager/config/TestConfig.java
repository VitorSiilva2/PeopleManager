package com.peoplemanager.peoplemanager.config;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import com.peoplemanager.peoplemanager.domain.Feedback;
import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.CollaboratorRepository;
import com.peoplemanager.peoplemanager.repositories.FeedbackRepository;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CollaboratorRepository collaboratorRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void run(String... args) throws Exception {


        User u1 = new User(null, "camila@gmail.com", "12345678", "Camila");
        User u2 = new User(null, "vitor@gmail.com", "123456789", "Vitor");

        Collaborator c1 = new Collaborator(null, "Vítoria", "vitoria@gmail.com", "Rep", u1);
        Collaborator c2 = new Collaborator(null, "Adison", "adison@gmail.com", "Rep", u1);


        Feedback f1 = new Feedback(null, "otimo colaborador", Instant.parse("2023-01-20T19:53:07Z"), c1);
        Feedback f2 = new Feedback(null, "Modelo a seguir", Instant.parse("2023-08-20T17:50:01Z"), c1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        collaboratorRepository.saveAll(Arrays.asList(c1, c2));
        feedbackRepository.saveAll(Arrays.asList(f1, f2));
    }
}
