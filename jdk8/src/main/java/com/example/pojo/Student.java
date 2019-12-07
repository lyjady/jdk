package com.example.pojo;

import java.util.List;

/**
 * @author LinYongJin
 * @date 2019/12/2 21:39
 */
public class Student {

    private String name;

    private int age;

    private List<Integer> ids;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public static int computerAge(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }

    public int computerName(Student s2) {
        return this.getName().length() - s2.getName().length();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ids=" + ids +
                '}';
    }
}
