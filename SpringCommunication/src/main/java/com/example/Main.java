package com.example;

import com.example.Utils.HibernateUtil;
import com.example.model.UserImp;
import com.example.producer.Publisher;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.charset.Charset;

/**
 * Created by Lukasz Sobalak on <lukasz.sobalak@mitron.com.
 */

class Main
{
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        logger.debug(String.format("Starting application build: %s [Java:(%s %s) OS:(%s %s %s) encoding:%s]",
                Main.class,
                System.getProperty("java.vendor"),
                System.getProperty("java.version"),
                System.getProperty("os.arch"),
                System.getProperty("os.name"),
                System.getProperty("os.version"),
                Charset.defaultCharset()));

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});

        //test
        Publisher publisher = applicationContext.getBean("producer", Publisher.class);
        UserImp user = new UserImp();
        user.setName("Brajanek");
        publisher.createRequest(user);
        publisher.readRequest();

        HibernateUtil.shutdown();

    }
}
