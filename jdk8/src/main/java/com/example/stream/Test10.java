package com.example.stream;

import java.util.*;

/**
 * @author LinYongJin
 * @date 2019/12/23 21:33
 */
public class Test10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");
        //Comparator.comparingInt()这个方法底层也是返回了comparator这个接口的compare这个方法的实现,根据编写者实现的ToIntFunction
        //将要比较的参数传给方法,在方法底层进行实现compare方法根据编写指定的属性进行比较
        Collections.sort(list, Comparator.comparingInt(str -> str.length()));
        System.out.println(list);
        System.out.println("---------------------------------");
        //反序
        //此时要显示的指定str的类型为String类型
        //因为ToIntFunction的参数类型是<? super T>是String即String的父类型
        //这个ToIntFunction是在comparingInt中的,然后有调用了reversed()
        //经过多层的调用,编译器无法识别出ToIntFunction的泛型类型,所以根据方法声明的类型<? super String>将其认证为Object
        //上面能够识别出来是因为深度不够,编译器能够识别出来类型
        Collections.sort(list, Comparator.comparingInt((String str) -> str.length()).reversed());
        System.out.println(list);
        System.out.println("---------------------------------");
    }
}
