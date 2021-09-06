package com.digitalinnovatione.personapi.exception;

public class PersonNotFoundException extends  Exception{

    public PersonNotFoundException(Long id) {
        super(String.format("Person with ID %s not found!", id));
    }
}
