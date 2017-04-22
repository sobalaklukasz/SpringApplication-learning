package com.features.lambdass;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Hosh on 2017-04-22.
 */
public class Predicates
{
    public static void predicate()
    {
        List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);

        BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filterList = (integers, integerPredicate) ->
                integers.stream()
                        .filter(integerPredicate)
                        .sorted()
                        .collect(Collectors.toList());


        Predicate<Integer> positive = i -> i > 0;
        filterList.apply(integerList, positive).forEach(System.out::println);
    }

    public static void test()
    {
        predicate();
    }
}
