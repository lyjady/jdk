package com.example.lambda;

/**
 * @author LinYongJin
 * @date 2019/11/18 21:12
 * 这个接口中定了一个抽象方法,一个从Object中继承方法和一个默认方法。但是函数式接口注解没有报错。
 * 因为子类只要实现一个本接口的方法就行了(function方法)
 */
@FunctionalInterface
public interface CustomerFunctionalInterface {

    void function();

    String toString();

    default void accept() {
        System.out.println("this is default method");
    }
}
