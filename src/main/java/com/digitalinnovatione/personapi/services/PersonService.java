package com.digitalinnovatione.personapi.services;

import com.digitalinnovatione.personapi.controller.MessageResponseDTO;
import com.digitalinnovatione.personapi.entities.Person;
import com.digitalinnovatione.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return  MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();

    }


}
