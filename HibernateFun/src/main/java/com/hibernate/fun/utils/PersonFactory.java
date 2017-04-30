package com.hibernate.fun.utils;

import com.hibernate.fun.model.Person;
import com.hibernate.fun.model.Pet;

import java.util.List;

/**
 * Created by Hosh on 2017-04-26.
 */
public class PersonFactory
{
    public static Person createPerson(String name, List<Pet> pets)
    {
        return new Person(name, pets);
    }

    public static Person createPerson(String name)
    {
        return new Person(name);
    }
}
