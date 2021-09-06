package com.digitalinnovatione.personapi.controller;

import com.digitalinnovatione.personapi.entities.Person;
import com.digitalinnovatione.personapi.repository.PersonRepository;
import com.digitalinnovatione.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }




}
