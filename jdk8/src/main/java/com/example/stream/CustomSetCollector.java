package com.example.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author LinYongJin
 * @date 2019/12/27 21:44
 */
public class CustomSetCollector<T> implements Collector<T, Set<T>, Set<T>> {

    /**
     * 生成中间容器
     *
     * @return
     */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("CustomSetCollector.supplier");
        return HashSet::new;
    }

    /**
     * 将元素添加到结果容器中
     *
     * @return
     */
    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        //这里若是声明HashSet::add将报错,因为在类中的泛型是Set类型,那么在supplier()中可以返回任何一个Set的实现类
        //如果在supplier()中返回的是TreeSet,但是在本方法中却是HashSet::add,那么这两个类的类型就不一致
        System.out.println("CustomSetCollector.accumulator");
        return Set::add;
    }

    /**
     * 将并行流执行的多个线程执行的结果给合并起来
     *
     * @return
     */
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("CustomSetCollector.combiner");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    /**
     * 将所有的结果合并到一起,返回一个最终的结果类型,如果结果容器和中间的结果容器类型一致那么finisher可以不用实现
     * 如果类型不一致就实现finisher
     * @return
     */
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("CustomSetCollector.finisher");
        //如果中间容器与结果容器类型一致就将输入直接返回
        return Function.identity();
    }

    /**
     * 返回一个集合包含着收集器的特性
     * IDENTITY_FINISH: 说明中间容器和结果容器类型一致或者直接将中间容器的类型强制转换成结果容器的类型是可以转换成功的, 才可以配置这个属性, 因为在JDK8中如果配置了这个属性JDK会将A直接强转成R
     *                  JDK12中就是直接将容器返回
     * UNORDERED:       收集操作并不承诺保留这个所遇到的输入元素的顺序
     * CONCURRENT:      这个收集器是一个并发的, 结果容器可以支持accumulator()被多个线程并发的被调用, 结果容器必须保证是线程安全的
     *                  如果并不是无序的, 只能并发的运用在无序的数据源上
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("CustomSetCollector.characteristics");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

}
