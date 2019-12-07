package com.example.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author LinYongJin
 * @date 2019/11/28 21:21
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println(new Test6().computer(3, 5, (a, b) -> a * b));
        System.out.println(new Test6().andThen(3, 4, (a, b) -> a * b, item -> item * item));
    }

    private Integer computer(Integer a, Integer b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    private Integer andThen(Integer a, Integer b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
