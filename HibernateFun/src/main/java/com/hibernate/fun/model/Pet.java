package com.hibernate.fun.model;

import com.hibernate.fun.domain.DaoModel;

import javax.persistence.*;

/**
 * Created by Hosh on 2017-04-26.
 */
@Entity(name = "pets")
@Table
public class Pet implements DaoModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    Integer id;

    @Column(name="pet_name", nullable=false)
    String name;

    @Override
    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }


    public Pet(String name)
    {
        this.name = name;
    }

    public Pet()
    {
    }

    @Override
    public String toString()
    {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public <T extends DaoModel> void cloneFromObject(T object)
    {
        Pet givenObject = (Pet)object;
        this.name = givenObject.getName();
    }
}
