package com.features.defaultKeyword;

/**
 * Created by Hosh on 2017-04-16.
 */
public interface CalculatorInterface
{
    int add(int a, int b);

    default int sub(int a, int b)
    {
        return a-b;
    };

}
