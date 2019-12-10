package com.example.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LinYongJin
 * @date 2019/12/10 21:10
 */
public class Test4 {

    public static void main(String[] args) {
        //合并
        Stream<String> stream1 = Stream.of("Java", "Script");
        String str = stream1.collect(Collectors.joining());
        System.out.println(str);
        System.out.println("------------------------");
        //Stream中的map是将集合中的元素映射成一个新的元素,flatMap是一种扁平化的映射,如果Stream中的"泛型"是集合
        //可以使用flatMap将集合中元素都取出来拼接成新的集合
        Stream<List<String>> streamList = Stream.of(Arrays.asList("Java", "Python"), Arrays.asList("GoLand ", "ErLand"));
        streamList.flatMap(Collection::stream).forEach(System.out::println);
        System.out.println("------------------------");
        //generate方法也能用来构建Stream参数是函数式接口Supplier
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);
        System.out.println("------------------------");
        //iterate方法也是用来构建Stream,将第一个参数作为输入输入到第二个参数中,第二个参数是函数式接口UnaryOperator,输出作为流中的元素
        //输出作为新的输入在输入到UnaryOperator中去。limit限制流中的元素个数。如果没有limit那么元素的个数将无限制
        Stream<Integer> stream2 = Stream.iterate(1, seed -> (seed + 1) * 2).limit(6);
        stream2.forEach(System.out::println);
    }
}
