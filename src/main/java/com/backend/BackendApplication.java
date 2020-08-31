package com.backend;

import com.backend.Entities.User;
import com.backend.Repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BackendApplication  {

    /*
    @Autowired
    private UserRepository userRepository;
     */

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    /*
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        User u1 = new User(faker.idNumber().toString(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),faker.internet().avatar());
        User u2 = new User(faker.idNumber().toString(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),faker.internet().avatar());
        User u3 = new User(faker.idNumber().toString(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),faker.internet().avatar());
        User u4 = new User(faker.idNumber().toString(), faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),faker.internet().avatar());

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        userRepository.save(u4);

        System.out.println("***********************");
        List<User> users = userRepository.findAll();

        for (User u : users)
        {
            System.out.println(u.toString());
        }

    }

     */

}
