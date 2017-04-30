package com.hibernate.fun.domain;

import com.hibernate.fun.model.Person;
import com.hibernate.fun.model.Pet;

import java.util.List;

/**
 * Created by Hosh on 2017-04-26.
 */
public interface DaoInterface
{
    void addPerson(Person person) throws DatabaseQueryException;
    void addPet(Pet pet) throws DatabaseQueryException;

    List<Person> getPersons() throws DatabaseQueryException;
    List getPets() throws DatabaseQueryException;

    void updatePet(Integer oldPetId, Pet newPet) throws DatabaseQueryException;
}
