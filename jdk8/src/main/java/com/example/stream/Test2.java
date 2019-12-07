package com.example.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/12/7 16:04
 */
public class Test2 {

    public static void main(String[] args) {
        //使用stream对集合的元素进行 x2再累加
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer reduce = list.stream().map(num -> num * 2).reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
