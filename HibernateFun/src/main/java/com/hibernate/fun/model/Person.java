package com.hibernate.fun.model;

import com.hibernate.fun.domain.DaoModel;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Hosh on 2017-04-26.
 */
@Entity(name = "persons")
@Table
public class Person implements DaoModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    Integer id;

    @Column(name="person_name", nullable=false)
    String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name="person_pets")
    List<Pet> pets;


    @Override
    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<Pet> getPets()
    {
        return pets;
    }

    public Person(String name)
    {
        this.name = name;
    }

    public Person(String name, List<Pet> pets)
    {
        this.name = name;
        this.pets = pets;
    }

    public Person()
    {
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pets=" + pets +
                '}';
    }

    @Override
    public <T extends DaoModel> void cloneFromObject(T object)
    {
        Person givenObject = (Person)object;
        this.name = givenObject.getName();
        this.pets = givenObject.getPets();
    }
}
