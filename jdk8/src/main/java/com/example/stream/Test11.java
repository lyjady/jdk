package com.example.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/12/27 21:14
 */
public class Test11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "helloworld");
        //thenComparing()能进行二级比较,JDK提供了很多和comparingInt一样细粒度更高的方法,避免了自动装箱和自动拆箱之间的性能损耗
//        list.sort(Comparator.comparingInt(String::length).thenComparingInt(s -> s.charAt(0)).reversed());
        //reversed()是将整个结果进行反转, 如果只要反转当前比较的结果的话可以使用重载的方法调用方法必须是comparing
        list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.comparing((String s1) -> s1.charAt(0), Comparator.reverseOrder())));
        System.out.println(list);
    }
}
