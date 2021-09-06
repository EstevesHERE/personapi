package com.digitalinnovatione.personapi.services;

import com.digitalinnovatione.personapi.controller.MessageResponseDTO;
import com.digitalinnovatione.personapi.dto.request.PersonDTO;
import com.digitalinnovatione.personapi.entities.Person;
import com.digitalinnovatione.personapi.exception.PersonNotFoundException;
import com.digitalinnovatione.personapi.mapper.PersonMapper;
import com.digitalinnovatione.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public MessageResponseDTO createPerson(Person personDTO){

        Person personTosave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personTosave);
        return  MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();

    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDto(person);
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());

    }

    public MessageResponseDTO update(Long id, Person personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }



}
