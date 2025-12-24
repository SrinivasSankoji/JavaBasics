package com.jio.ngo.memoryleak;

import java.util.ArrayList;
import java.util.List;

public class StaticMemoryLeakDemo {

    static List<Integer> sum =new ArrayList<>();

    public void populateList(){
        for (int i = 0; i < 100; i++) {
            sum.add(i);
        }
        System.out.println("Sum is done");
    }

    public static void main(String[] args) {
        StaticMemoryLeakDemo staticMemoryLeakDemo=new StaticMemoryLeakDemo();
        staticMemoryLeakDemo.populateList();
        System.out.println("After populateList() execution is done");

    }
}
