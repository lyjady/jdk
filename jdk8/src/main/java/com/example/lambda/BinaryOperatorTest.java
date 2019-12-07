package com.example.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author LinYongJin
 * @date 2019/12/2 21:47
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest binaryOperator = new BinaryOperatorTest();
        int computer = binaryOperator.computer(3, 5, (a, b) -> a * b);
        System.out.println(computer);
        System.out.println("----------------------------");
        System.out.println(binaryOperator.comparator("Sam", "Rose", Comparator.comparingInt(String::length)));
        System.out.println("----------------------------");
        System.out.println(binaryOperator.comparator("Sam", "Rose", Comparator.comparingInt(s -> s.charAt(0))));
    }

    public int computer(int a, int b, BinaryOperator<Integer> operator) {
        return operator.apply(a, b);
    }

    public String comparator(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
