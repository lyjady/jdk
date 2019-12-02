package com.example;

import com.example.pojo.Student;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/**
 * @author LinYongJin
 * @date 2019/12/2 21:36
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());

        System.out.println("---------------------");

        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get());

        System.out.println("---------------------");
    }
}
