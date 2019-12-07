package com.example.lambda;

import java.util.function.Function;

/**
 * @author LinYongJin
 * @date 2019/11/28 21:09
 */
public class Test5 {

    public static void main(String[] args) {
        System.out.println(new Test5().compose(5, value -> value + 2, value -> value * value));
        System.out.println(new Test5().angThen(5, value -> value + 2, value -> value * value));
    }

    private Integer compose(Integer a, Function<Integer, Integer> function, Function<Integer, Integer> function2) {
        //返回的是一个有apply实现的function对象,实现就是先执行function2的apply方法,把输出的结果作为参数给function的apply方法
        return function.compose(function2).apply(a);
    }

    private Integer angThen(Integer a, Function<Integer, Integer> function, Function<Integer, Integer> function2) {
        return function.andThen(function2).apply(a);
    }
}
