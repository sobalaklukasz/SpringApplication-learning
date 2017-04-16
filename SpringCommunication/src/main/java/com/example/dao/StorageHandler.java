package com.example.dao;

import com.example.domain.DatabaseQueryException;
import com.example.model.User;

import java.util.List;

/**
 * Created by Hosh on 2017-04-15.
 */
public interface StorageHandler
{
    void Create(User user) throws DatabaseQueryException;
    List<User> Read() throws DatabaseQueryException;
    void Update(User oldUser, User newUser) throws DatabaseQueryException;
    void Delete(User user) throws DatabaseQueryException;
}
