package com.example;

import com.example.pojo.Student;

import java.util.*;

/**
 * @author LinYongJin
 * @date 2019/12/2 22:08
 */
public class OptionalTest {

    public static void main(String[] args) {
        //Optional类是一个容器里面放一个值,这个类可以对里面的value值进行Null指针判断
        //构建一个Optional实例,调用of方法是必须传入一个不为空的值否则会抛出空指针异常
        Optional<String> optionalOf = Optional.of("Str");

        //构建一个Optional实例,调用empty方法时会构建一个value为null的Optional实例
        Optional<String> optionalEmpty = Optional.empty();

        //构建一个Optional实例,调用ofNullable方法会判断传入的值如果值为空调用empty方法,不为空调用of方法
        Optional<String[]> optionalNullable = Optional.ofNullable(args);

        //如果value为空那么会放回orElse的参数,如果不为空则返回value
        System.out.println(optionalOf.orElse("other"));
        System.out.println(optionalEmpty.orElse("other"));

        System.out.println("--------------------------------");

        //如果value为空那么会执行Supplier里面的get方法,如果不为空则返回value
        System.out.println(optionalOf.orElseGet(() -> "orElseGet"));
        System.out.println(optionalEmpty.orElseGet(() -> "orElseGet"));

        System.out.println("--------------------------------");

        //如果value为空那么ifPresent判断为false就不会执行Consumer的accept方法,如果不为空则判断为true会执行Consumer的accept方法
        //在日常的开发中通常会写if (null != object) { ... } 那么使用了Optional接口之后可以简写成optional.ifPresent(Consumer的accept的实现)
        optionalOf.ifPresent(System.out::println);
        optionalEmpty.ifPresent(System.out::println);

        System.out.println("--------------------------------");

        //在实际的业务中可能会返回一个集合但是如果集合为空一般不返回null而是返回一个空的集合
        //如果按照以前的写法需要if(null != list) return list else return new ArrayList<>();
        //如果使用了Optional这个接口那么可以进行函数式的编写
        System.out.println(getStudentIds());
    }

    public static List<Integer> getStudentIds() {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5);
        Student student = new Student();
//        student.setIds(ids);
        Optional<Student> optional = Optional.of(student);
        return optional.map(Student::getIds).orElseGet(ArrayList::new);
    }
}
