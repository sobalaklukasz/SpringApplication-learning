package com.example.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */

@Entity(name = "users")
@Table
public class UserImp implements User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name", nullable=false)
    private String name;

    public long getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
