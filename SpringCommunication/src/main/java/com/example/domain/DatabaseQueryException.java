package com.example.domain;

/**
 * Created by Hosh on 2017-04-15.
 */
public class DatabaseQueryException extends Exception
{
    public DatabaseQueryException(Throwable throwable)
    {
        super(throwable);
    }
}
