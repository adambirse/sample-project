package com.birse.person;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonResourcePersonMapper {

    PersonResource sourceToDestination(Person source);

    Person destinationToSource(PersonResource destination);

    Iterable<PersonResource> sourceToDestination(Iterable<Person> people);

    Iterable<Person> DestinationToSource(Iterable<PersonResource> people);
}