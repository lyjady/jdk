package com.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author LinYongJin
 * @date 2019/12/15 14:29
 */
public class Test6 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");
        long startTime = System.nanoTime();
        list.stream().sorted();
        long millis = TimeUnit.MICROSECONDS.toMillis(System.nanoTime() - startTime);
        System.out.println("花费了: " + millis + "毫秒");
    }
}
