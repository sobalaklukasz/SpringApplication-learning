package com.hibernate.fun.domain;

import com.hibernate.fun.model.Person;
import com.hibernate.fun.model.Pet;

import java.util.List;

/**
 * Created by Hosh on 2017-04-30.
 */
public interface AService
{
    /**
     * Saves person and pets on storage
     * @param name does not have to be unique, can't be null
     * @param pets if pets are not already in storage they will be auto added
     */
    void addPerson(String name, List<Pet> pets) throws DatabaseQueryException;

    /**
     * Add person without pets
     * @param name
     */
    void addPerson(String name) throws DatabaseQueryException;

    /**
     * Saves pet in storage
     * @param name is not unique, can't be null
     */
    void addPet(String name) throws DatabaseQueryException;

    /**
     * Person contains list of pets or null
     * @return return list of person with their pets or null
     */
    List<Person> getPersons() throws DatabaseQueryException;

    /**
     * Pets are cute
     * @return return list of pets
     */
    List<Pet> getPets() throws DatabaseQueryException;

    void updatePet(Pet oldPet, Pet newPet) throws DatabaseQueryException;

    void updatePet(Integer oldPetId, Pet newPet) throws DatabaseQueryException;

}
