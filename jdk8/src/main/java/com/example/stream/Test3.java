package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LinYongJin
 * @date 2019/12/7 16:16
 */
public class Test3 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");
        Stream<String> stream2 = Stream.of("hello", "world", "hello world");
        ArrayList<Object> arrayList = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(arrayList);
        LinkedList<Object> linkedList = stream2.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println(linkedList);
    }
}
