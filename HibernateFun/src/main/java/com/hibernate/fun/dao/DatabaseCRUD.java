package com.hibernate.fun.dao;

import com.hibernate.fun.domain.DaoModel;
import com.hibernate.fun.domain.DatabaseQueryException;
import com.hibernate.fun.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Hosh on 2017-04-30.
 */
abstract class DatabaseCRUD
{
    protected <E> void create(E object) throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.save(object);
            session.getTransaction().commit();
            session.close();
        } catch (Throwable t)
        {
            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }

    public <E> List<E> read(Class<E> classType) throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            @SuppressWarnings("unchecked")
            List<E> list = session.createQuery("FROM " + classType.getTypeName()).list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Throwable t)
        {
            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }

    public <T extends DaoModel> void update(Integer oldObjectId, T newObject) throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            @SuppressWarnings("unchecked")
            T currentObject = session.get((Class<T>) newObject.getClass(), oldObjectId);
            currentObject.cloneFromObject(newObject);
            session.getTransaction().commit();
            session.close();
        } catch (Throwable t)
        {
            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }

    public <E> void delete(E object) throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.delete(object);
            session.getTransaction().commit();
            session.close();
        } catch (Throwable t)
        {
            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }
}
