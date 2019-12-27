package com.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author LinYongJin
 * @date 2019/12/27 22:08
 */
public class Test12 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello", "welcome");
        //当配置了IDENTITY_FINISH的时候不会执行finisher(), 取消了IDENTITY_FINISH配置就会执行finisher()
        //collector.characteristics().contains(Characteristics.IDENTITY_FINISH) ? container : collector.finisher().apply(container);
        Set<String> collect = list.stream().collect(new CustomSetCollector<>());
        System.out.println(collect);
    }
}
