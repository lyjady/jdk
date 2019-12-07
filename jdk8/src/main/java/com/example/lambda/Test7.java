package com.example.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author LinYongJin
 * @date 2019/11/28 21:31
 */
public class Test7 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //filter中是Predicate的test方法实现,进行过滤.false就过滤掉。这是Predicate与stream结合起来使用
        List<Integer> collect = list.stream().filter(a -> a > 5).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("-------------------------------");
        Test7 t = new Test7();
        t.conditionFilter(list, integer -> integer % 2 == 0);
        System.out.println("-------------------------------");
        t.conditionAnd(list, integer -> integer > 5, integer -> integer % 2 == 0);
        System.out.println("-------------------------------");
        t.conditionOr(list, integer -> integer > 5, integer -> integer % 2 == 0);
        System.out.println("-------------------------------");
        t.conditionNegate(list, integer -> integer > 5);
        System.out.println("-------------------------------");
    }

    private void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(integer -> {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        });
    }

    private void conditionAnd(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        list.forEach(integer -> {
            if (predicate.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        });
    }

    private void conditionOr(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        list.forEach(integer -> {
            if (predicate.or(predicate2).test(integer)) {
                System.out.println(integer);
            }
        });
    }

    private void conditionNegate(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(integer -> {
            if (predicate.negate().test(integer)) {
                System.out.println(integer);
            }
        });
    }
}
