package com.example.stream;

import com.example.pojo.Student;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author LinYongJin
 * @date 2019/12/15 14:58
 */
public class Test8 {

    public static void main(String[] args) {
        Student s1 = new Student("lisi", 12);
        Student s2 = new Student("zhangsan", 23);
        Student s3 = new Student("wangwu", 12);
        Student s4 = new Student("zhangsan", 11);
        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        //根据名字进行分类
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(collect);
        System.out.println("---------------------");
        //根据名字进行分类求数量
        Map<String, Long> collect1 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(collect1);
        System.out.println("---------------------");
        //求平均值
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingInt(Student::getAge))));
        System.out.println("---------------------");
        //分区
        System.out.println(students.stream().collect(Collectors.partitioningBy(stu -> stu.getAge() > 20)));
        System.out.println("---------------------");
        //分区求数量
        System.out.println(students.stream().collect(Collectors.partitioningBy(stu -> stu.getAge() > 20, Collectors.counting())));
        System.out.println("---------------------");
        //分区求平均值
        System.out.println(students.stream().collect(Collectors.partitioningBy(stu -> stu.getAge() > 20, Collectors.averagingInt(Student::getAge))));
    }
}
