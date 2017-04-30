package com.hibernate.fun.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */
public class HibernateUtil
{
        private static SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory()
        {
            try
            {
                if (sessionFactory == null)
                {
                    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                    return sessionFactory;
                }
                return sessionFactory;
            } catch (Throwable ex)
            {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory()
        {
            return sessionFactory;
        }

        public static void shutdown()
        {
            getSessionFactory().close();
        }
}