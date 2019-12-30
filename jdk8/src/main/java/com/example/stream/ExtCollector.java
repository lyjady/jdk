package com.example.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author LinYongJin
 * @date 2019/12/30 15:15
 */
public class ExtCollector<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("ExtCollector.supplier");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("ExtCollector.accumulator");
        return (set, item) -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName() + ", Set: " + set);
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("ExtCollector.combiner");
        return (right, left) -> {
            System.out.println("容器合并");
            right.addAll(left);
            return right;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("ExtCollector.finisher");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.forEach(item -> {
                map.put(item, item);
            });
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("ExtCollector.characteristics");
        //如果给Characteristics加上IDENTITY_FINISH属性会出现ClassCastException,因为加了这个属性说明了,中间容器类型与结果容器类型一致会进行不检查的类型转换,那如果实际上不同的话就会出现类型转换异常
        //加上CONCURRENT这个属性就说明了就算是并行流中间容器也只有一个,那这样就不会执行combiner(),因为这个方法是将中间容器进行合并的.
        //combiner()这个方法执行的条件是在并行流的情况下没有CONCURRENT这个属性
        //并且在加上CONCURRENT这个属性并且在并行流的情况下修改中间容器并且迭代容器会抛出异常
        //并行流 + 加Characteristics.CONCURRENT = 不执行combiner()
        //并行流 + 不加Characteristics.CONCURRENT = 执行combiner()
        //UNORDERED说明中间容器无序
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "Java", "JavaScript", "Java");
        Map<String, String> collect = list.stream().parallel().collect(new ExtCollector<>());
        System.out.println(collect);
    }
}
