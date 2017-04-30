package com.hibernate.fun.utils;

import com.hibernate.fun.model.Pet;

/**
 * Created by Hosh on 2017-04-26.
 */
public class PetFactory
{
    public static Pet createPet(String name)
    {
        return new Pet(name);
    }
}
