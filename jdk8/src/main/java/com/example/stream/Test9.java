package com.example.stream;

import com.example.pojo.Student;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LinYongJin
 * @date 2019/12/23 21:04
 */
public class Test9 {

    public static void main(String[] args) {
        Student s1 = new Student("lisi", 12);
        Student s2 = new Student("zhangsan", 23);
        Student s3 = new Student("wangwu", 12);
        Student s4 = new Student("zhangsan", 11);
        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        //求最小值
        students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getAge))).ifPresent(System.out::println);
        System.out.println("----------------------");
        //求平均数
        System.out.println(students.stream().collect(Collectors.averagingInt(Student::getAge)));
        System.out.println("----------------------");
        IntSummaryStatistics statistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(statistics);
        System.out.println("----------------------");
        System.out.println(students.stream().filter(student -> student.getAge() < 20).count());
        System.out.println("----------------------");
        //join将集合内的元素拼接到一起
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining()));
        System.out.println("----------------------");
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(", ")));
        System.out.println("----------------------");
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(", ", "<begin> ", " <end>")));
        System.out.println("----------------------");
        System.out.println((int) students.stream().flatMap(Stream::of).count());
        System.out.println("----------------------");
        //一层分组
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getName)));
        System.out.println("----------------------");
        //二层分组
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getAge))));
        System.out.println("----------------------");
        //一层分区
        System.out.println(students.stream().collect(Collectors.partitioningBy(student -> student.getAge() > 20)));
        //二层分区
        System.out.println("----------------------");
        System.out.println(students.stream().collect(Collectors.partitioningBy(student -> student.getAge() > 20, Collectors.partitioningBy(student -> student.getName().length() > 3))));
        System.out.println("----------------------");
        //分组分区
        System.out.println(students.stream().collect(Collectors.partitioningBy(student -> student.getAge() > 20, Collectors.groupingBy(Student::getName))));
    }
}
