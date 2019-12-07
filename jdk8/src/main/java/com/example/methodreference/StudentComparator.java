package com.example.methodreference;

import com.example.pojo.Student;

/**
 * @author LinYongJin
 * @date 2019/12/7 15:36
 */
public class StudentComparator {

    public int computerName(Student s1, Student s2) {
        return s1.getName().length() - s2.getName().length();
    }
}
