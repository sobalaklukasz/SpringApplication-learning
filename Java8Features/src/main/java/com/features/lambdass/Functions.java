package com.features.lambdass;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Hosh on 2017-04-22.
 */
public class Functions
{
    public static void function()
    {
        List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);

        BiFunction<List<Integer>, Function<Integer, Boolean>, List<Integer>> filterList = (integers, integerBooleanFunction) ->
                integers.stream()
                        .filter(integerBooleanFunction::apply)
                        .collect(Collectors.toList());


        Function<Integer, Boolean> positive = (integer) -> (integer > 0);
        filterList.apply(integerList, positive).forEach(System.out::println);
    }

    public static void test()
    {
        function();
    }
}
