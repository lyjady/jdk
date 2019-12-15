package com.example.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author LinYongJin
 * @date 2019/12/15 14:45
 */
public class Test7 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "hello hello", "hello world world");
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        System.out.println("------------");
        List<String> list2 = Arrays.asList("hi", "hello");
        List<String> list3 = Arrays.asList("zhangsan", "li", "wangwu");
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).forEach(System.out::println);
    }
}
