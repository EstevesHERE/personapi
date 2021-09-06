package com.digitalinnovatione.personapi.mapper;

import com.digitalinnovatione.personapi.dto.request.PersonDTO;
import com.digitalinnovatione.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-YYYY")
    Person toModel(Person personDTO);

    PersonDTO toDto(Person person);
}
