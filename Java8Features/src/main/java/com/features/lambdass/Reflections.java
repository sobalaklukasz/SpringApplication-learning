package com.features.lambdass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Hosh on 2017-04-22.
 */
public class Reflections
{
    private static boolean lock = true;
    private static void reflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {

        System.out.println("sup...");
        Reflections reflections = new Reflections();

        Method testMethod = reflections.getClass().getMethod("test", null);
        if (lock)
        {
            lock = false;
            testMethod.invoke(reflections.getClass());
        }
    }


    public static void test()
    {
        try
        {
            reflection();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}
