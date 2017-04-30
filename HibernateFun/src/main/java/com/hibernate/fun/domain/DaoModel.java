package com.hibernate.fun.domain;

/**
 * Created by Hosh on 2017-04-30.
 */
public interface DaoModel
{

    /**
     * Id is primary key for object
     * @return
     */
    Integer getId();

    /**
    * Clone all variables from given object
     * @param Object Object which variables will be cloned to current object
     * @param <T> class of new object
     */
    <T extends DaoModel> void cloneFromObject(T object);
}
