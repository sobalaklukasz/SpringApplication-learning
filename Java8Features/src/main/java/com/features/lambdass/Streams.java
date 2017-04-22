package com.features.lambdass;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Hosh on 2017-04-22.
 */

public class Streams
{
    public static void stream()
    {
        List<Integer> numbers = Arrays.asList(1,6,4,8,3,5,7,9,3,6,9,12,1,46,885,32);

        Function<Integer, Boolean> isEven = (integer) -> (integer % 2 == 0);
        numbers.stream()
                .filter(isEven::apply)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .forEach(System.out::println);
    }


    public static void test()
    {
        stream();
    }



}
