package com.peoplemanager.peoplemanager.services;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import com.peoplemanager.peoplemanager.domain.Feedback;
import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.CollaboratorRepository;
import com.peoplemanager.peoplemanager.repositories.FeedbackRepository;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CollaboratorRepository collaboratorRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    public void instaciaDB() {




        Collaborator c1 = new Collaborator(null, "Vítoria", "vitoria@gmail.com", "Rep", null);
        Collaborator c2 = new Collaborator(null, "Adison", "adison@gmail.com", "Rep", null);


        Feedback f1 = new Feedback(null, "otimo colaborador", Instant.parse("2023-01-20T19:53:07Z"), c1);
        Feedback f2 = new Feedback(null, "Modelo a seguir", Instant.parse("2023-08-20T17:50:01Z"), c1);


        collaboratorRepository.saveAll(Arrays.asList(c1, c2));
        feedbackRepository.saveAll(Arrays.asList(f1, f2));
    }

}
