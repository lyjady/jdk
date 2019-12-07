package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author LinYongJin
 * @date 2019/12/7 15:56
 */
public class Test1 {

    public static void main(String[] args) {
        //构建stream的方式
        Stream stream = Stream.of(1, 2, 3, 4);

        String[] strs = {"1", "2", "3", "4"};
        Stream ints1 = Stream.of(strs);

        Stream stream1 = Arrays.stream(strs);

        List<String> list = Arrays.asList("1", "2");
        Stream<String> stream2 = list.stream();

        IntStream.range(3, 5).forEach(System.out::println);
        IntStream.rangeClosed(3, 5).forEach(System.out::println);
    }
}
