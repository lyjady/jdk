package com.example.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author LinYongJin
 * @date 2019/12/10 21:30
 */
public class Test5 {

    public static void main(String[] args) {
        //找出流中大于2的元素,然后将每个元素乘2,然后忽略掉流中的前两个元素,然后在取出流中的前两个元素,然后求和
        Stream<Integer> stream = Stream.of(1, 3, 5, 7, 9, 11);
        //skip切一刀留后面,limit切一刀留前面
        int sum = stream.filter(num -> num > 2).mapToInt(num -> num * 2).skip(2).limit(2).sum();
        System.out.println(sum);
        System.out.println("----------------------------");
        //IntSummaryStatistics对流中的元素进行统计操作
        Stream<Integer> stream2 = Stream.of(1, 3, 5, 7, 9, 11);
        IntSummaryStatistics intSummaryStatistics = stream2.mapToInt(num -> num * num).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println("----------------------------");
        //每次使用的操作都会生成新的流,下面的写法会出现异常
        //因为filter还在操作流的话distinct不能对流进行操作
        Stream<Integer> stream3 = Stream.of(1, 3, 5, 7, 9, 11);
//        System.out.println(stream3);
//        System.out.println(stream3.filter(num -> num > 2));
//        System.out.println(stream3.distinct());
        System.out.println("----------------------------");
        //如果不加forEach这样的终止操作的话,是不会打印call method的
        //因为流的一种模式是惰性的,只有当遇到终止操作的时候才会执行
        //流中是将要执行的方法封装在内部,遇到终止方法的时候遍历元素,对元素进行相应的操作,所以流其实是只遍历一遍
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(num -> {
            System.out.println("call map method");
            return num + 2;
        }).filter(num -> {
            System.out.println("call filter method");
            return num > 0;
        }).forEach(System.out::println);
        System.out.println("----------------------------");
        //在jdk1.8中如果将distinct在limit之前调用的话程序不会停止
        //因为distinct是去重,由iterate生成的元素先经过distinct处理再经过limit处理再打印
        //前面打印了0,1第三次生成0的话会被去重去掉,第四次生成1的话也会被去掉,不会执行到limit
        //limit是iterate结束的信号,limit没有被执行那么iterate没有收到结束的信号将会一直执行,所以程序不会停止
        IntStream.iterate(0, num -> (1 + num) % 2).distinct().limit(2).forEach(System.out::println);

    }
}
