package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/11/18 21:16
 */
public class Test1 {

    public void test1(CustomerFunctionalInterface customerFunctionalInterface) {
        System.out.println(1);
        customerFunctionalInterface.function();
        System.out.println(2);
    }

    public static void main(String[] args) {
        //lambda表达式来创造函数式接口的实例
        new Test1().test1(() -> System.out.println("customer functional interface"));
        System.out.println("------------");
        CustomerFunctionalInterface functionalInterface = () -> System.out.println("customer functional interface");
        new Test1().test1(functionalInterface);
        System.out.println(functionalInterface.getClass());
        System.out.println(functionalInterface.getClass().getSuperclass());
        System.out.println(functionalInterface.getClass().getInterfaces()[0]);
        System.out.println("------遍历集合------");
        List<Integer> numbers = Arrays.asList(1, 2, 3 ,4 ,5 ,6 ,7, 8);
        numbers.forEach(number -> System.out.println(number));
        System.out.println("------方法引用创建函数式接口的实例------");
        numbers.forEach(System.out::println);
    }
}
