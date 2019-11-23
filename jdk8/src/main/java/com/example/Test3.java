package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author LinYongJin
 * @date 2019/11/23 19:51
 */
public class Test3 {

    public static void main(String[] args) {
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply("java"));

        FunctionInterface<Integer, String> fi = i -> String.valueOf(i * i);
        System.out.println(fi.method(5));

//        List<String> names = Arrays.asList("zhangsan", "lisi", "zhaoliu", "wangwu");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return t1.compareTo(s);
//            }
//        });
//        System.out.println(names);

        List<String> names = Arrays.asList("zhangsan", "lisi", "zhaoliu", "wangwu");
        Collections.sort(names, (s1, s2) -> s2.compareTo(s1));
        System.out.println(names);
    }


}
