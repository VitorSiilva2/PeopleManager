package com.peoplemanager.peoplemanager.config;

import com.peoplemanager.peoplemanager.domain.Collaborator;
import com.peoplemanager.peoplemanager.domain.Feedback;
import com.peoplemanager.peoplemanager.domain.User;
import com.peoplemanager.peoplemanager.repositories.CollaboratorRepository;
import com.peoplemanager.peoplemanager.repositories.FeedbackRepository;
import com.peoplemanager.peoplemanager.repositories.UserRepository;
import com.peoplemanager.peoplemanager.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("$spring.jpa.hibernate.ddl-auto")
    private String ddl;

    @Bean
    public boolean instanciaDB() {
        if(ddl.equals("create")) {
            this.dbService.instaciaDB();
        }

        return false;
    }


}
