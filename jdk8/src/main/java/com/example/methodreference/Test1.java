package com.example.methodreference;

import com.example.pojo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author LinYongJin
 * @date 2019/12/7 15:28
 */
public class Test1 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("zhangsan", 12), new Student("lisi", 14));

        System.out.println("静态方法应用(类名::静态方法名)");
        students.sort((s1, s2) -> Student.computerAge(s1, s2));
        students.forEach(System.out::println);
        System.out.println("使用方法引用改写");
        students.sort(Student::computerAge);
        students.forEach(System.out::println);

        System.out.println("实例方法引用(实例名::实例方法)");
        StudentComparator comparator = new StudentComparator();
        students.sort((s1, s2) -> comparator.computerName(s1, s2));
        students.forEach(System.out::println);
        System.out.println("使用方法引用改写");
        students.sort(comparator::computerName);
        students.forEach(System.out::println);

        System.out.println("使用类名::实例方法");
        students.sort((s1, s2) -> s1.computerName(s2));
        students.forEach(System.out::println);
        System.out.println("使用方法引用改写");
        students.sort(Student::computerName);
        students.forEach(System.out::println);

        //构造方法引用编译器会根据上下文来判断调用哪个构造方法的重载
        System.out.println("使用类名::new(实例方法引用)");
        Test1 test = new Test1();
        System.out.println(test.getString1("getString1", String::new));
        System.out.println(test.getString2("getString2", String::new));
}

    public String getString1(String str, Supplier<String> supplier) {
        return supplier.get() + str;
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }
}
