package com.hibernate.fun.service;

import com.hibernate.fun.domain.AService;
import com.hibernate.fun.domain.DaoInterface;
import com.hibernate.fun.domain.DatabaseQueryException;
import com.hibernate.fun.model.Person;
import com.hibernate.fun.model.Pet;
import com.hibernate.fun.utils.PersonFactory;
import com.hibernate.fun.utils.PetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hosh on 2017-04-26.
 */

@Service
public class TheService implements AService
{
    @Autowired
    private DaoInterface daoInterface;

//    Good practice to use @Override on interface's implementation methods

    @Override
    public void addPerson(String name, List<Pet> pets) throws DatabaseQueryException
    {
        daoInterface.addPerson(PersonFactory.createPerson(name, pets));
    }

    @Override
    public void addPerson(String name) throws DatabaseQueryException
    {
        daoInterface.addPerson(PersonFactory.createPerson(name));
    }

    @Override
    public void addPet(String name) throws DatabaseQueryException
    {
        daoInterface.addPet(PetFactory.createPet(name));
    }

    @Override
    public List<Person> getPersons() throws DatabaseQueryException
    {
        return daoInterface.getPersons();
    }

    @Override
    public List<Pet> getPets() throws DatabaseQueryException
    {
        return daoInterface.getPets();
    }

    @Override
    public void updatePet(Pet oldPet, Pet newPet) throws DatabaseQueryException
    {
        daoInterface.updatePet(oldPet.getId(), newPet);
    }

    @Override
    public void updatePet(Integer oldPetId, Pet newPet) throws DatabaseQueryException
    {
        daoInterface.updatePet(oldPetId, newPet);
    }

}
