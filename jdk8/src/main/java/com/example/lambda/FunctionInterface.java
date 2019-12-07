package com.example.lambda;

/**
 * @author LinYongJin
 * @date 2019/11/23 19:38
 */
@FunctionalInterface
public interface FunctionInterface<T, R> {

    R method(T arg);
}

@FunctionalInterface
interface FunctionInterface2 {

    void method2();
}
