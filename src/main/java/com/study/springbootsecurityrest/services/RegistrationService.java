package com.study.springbootsecurityrest.services;

import com.study.springbootsecurityrest.models.Person;
import com.study.springbootsecurityrest.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        if(person.getUsername()=="admin"){person.setRole("ROLE_ADMIN");}
        person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }
    @Transactional
    public void registerAdmin(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_ADMIN");
        peopleRepository.save(person);
    }
}
