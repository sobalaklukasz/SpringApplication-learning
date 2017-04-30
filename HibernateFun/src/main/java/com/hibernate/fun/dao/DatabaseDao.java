package com.hibernate.fun.dao;

import com.hibernate.fun.domain.DaoInterface;
import com.hibernate.fun.domain.DatabaseQueryException;
import com.hibernate.fun.model.Person;
import com.hibernate.fun.model.Pet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hosh on 2017-04-26.
 */
@Repository
class DatabaseDao extends DatabaseCRUD implements DaoInterface
{
    //    Good practice to use @Override on interface's implementation methods

    private final static Logger logger = Logger.getLogger(DatabaseDao.class);

    @Override
    public void addPerson(Person person) throws DatabaseQueryException
    {
        create(person);
    }

    @Override
    public void addPet(Pet pet) throws DatabaseQueryException
    {
        create(pet);
    }

    @Override
    public List<Person> getPersons() throws DatabaseQueryException
    {
        return read(Person.class);
    }

    @Override
    public List<Pet> getPets() throws DatabaseQueryException
    {
        return read(Pet.class);
    }

    @Override
    public void updatePet(Integer oldPetId, Pet newPet) throws DatabaseQueryException
    {
        update(oldPetId, newPet);
    }
}
