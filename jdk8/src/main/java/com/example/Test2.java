package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/11/23 19:38
 */
public class Test2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "javascript", "python", "golang", "erlang");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
