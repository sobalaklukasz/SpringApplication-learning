package com.features;

import org.apache.log4j.Logger;

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


//        Uncomment what you want to test :)

//        TestDefaultKeyword.test();
//        Streams.test();
//        Predicates.test();
//        Reflections.test();
//        Functions.test();

    }
}