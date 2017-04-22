package com.features.defaultKeyword;

/**
 * Created by Hosh on 2017-04-16.
 */

/**
 * Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the default keyword.
 * @see CalculatorInterface
 */

public class TestDefaultKeyword
{
    public static void test()
    {
        int a = 3;
        int b = 4;






//        Normal Implementation
        CalculatorInterface calculatorNormalImp = new CalculatorInterface()
        {
            public int add(int a, int b)
            {
                return a+b;
            }

            public int sub(int a, int b)
            {
                return b-a;
            }
        };
        System.out.println(String.format("Normal implementation: add %s and %s = %s ",a,b,calculatorNormalImp.add(3,4)));
        System.out.println(String.format("Normal implementation: sub %s and %s = %s ",a,b,calculatorNormalImp.sub(3,4)));






//        Implementation which keeps default methods
        CalculatorInterface calculatorWithoutDefaultOverride = new CalculatorInterface()
        {
            public int add(int a, int b)
            {
                return a+b;
            }
        };
        System.out.println(String.format("Without default override implementation: add %s and %s = %s ",a,b,calculatorWithoutDefaultOverride.add(3,4)));
        System.out.println(String.format("Without default override implementation: sub %s and %s = %s ",a,b,calculatorWithoutDefaultOverride.sub(3,4)));
    }
}
