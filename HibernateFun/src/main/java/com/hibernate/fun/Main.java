package com.hibernate.fun;

import com.hibernate.fun.domain.AService;
import com.hibernate.fun.domain.DatabaseQueryException;
import com.hibernate.fun.utils.HibernateUtil;
import com.hibernate.fun.utils.PetFactory;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by Hosh on 2017-04-26.
 */

public class Main
{
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) ->
        {
            logger.error("Shieeeeet", e);
            HibernateUtil.shutdown();
        });

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

        AService aService = applicationContext.getBean(AService.class);

        try
        {
            aService.addPet("Zbigniew");
            aService.getPets().forEach(System.out::println);
            aService.addPerson("Prometeusz", Arrays.asList(
                    PetFactory.createPet("Damian"),
                    PetFactory.createPet("Stefan")));
            aService.getPersons().forEach(System.out::println);
            aService.getPets().forEach(System.out::println);
            aService.updatePet(1,PetFactory.createPet("Zbynio"));
            aService.getPets().forEach(System.out::println);

        } catch (DatabaseQueryException e)
        {
            logger.error("Fakap", e);
        }


        HibernateUtil.shutdown();
    }

}
