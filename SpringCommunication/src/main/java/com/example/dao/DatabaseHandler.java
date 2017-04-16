package com.example.dao;

import com.example.domain.DatabaseQueryException;
import com.example.Utils.HibernateUtil;
import com.example.model.User;
import com.example.model.UserImp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */

@Repository
public class DatabaseHandler implements StorageHandler
{
    public void Create(User user) throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Throwable t)
        {
            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }

    public List<User> Read() throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
        try
        {
            @SuppressWarnings("unchecked")
            List<User> list = session.createQuery("FROM users").list();
//            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Throwable t)
        {
//            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }

    public void Update(User oldUser, User newUser) throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
//            magic
            UserImp oldUserImp = session.get(UserImp.class, oldUser.getId());
            oldUserImp.setName(((UserImp)newUser).getName());
            session.getTransaction().commit();
            session.close();
        } catch (Throwable t)
        {
            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }

    public void Delete(User user) throws DatabaseQueryException
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (Throwable t)
        {
            transaction.rollback();
            throw new DatabaseQueryException(t);
        }
    }

    public User getUserById(long id) throws DatabaseQueryException
    {
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            try
            {
                User user = session.get(UserImp.class, id);
                session.getTransaction().commit();
                session.close();
                return user;
            } catch (Throwable t)
            {
                transaction.rollback();
                throw new DatabaseQueryException(t);
            }
        }
    }
}
