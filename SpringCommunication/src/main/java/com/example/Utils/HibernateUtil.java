package com.example.Utils;

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
//                    DOES NOT WORK ON HIBERNATE 5
//                    Configuration configuration = new Configuration().configure();
//                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//                    return configuration.buildSessionFactory(builder.build());

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