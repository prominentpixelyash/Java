package com.prominentpixel.datastructure;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class MyLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> uniqueNumberWithInsertionOrder=new LinkedHashSet<>();

        uniqueNumberWithInsertionOrder.add(5);
        uniqueNumberWithInsertionOrder.add(5);
        uniqueNumberWithInsertionOrder.add(5);
        uniqueNumberWithInsertionOrder.add(5);
        uniqueNumberWithInsertionOrder.add(7);
        uniqueNumberWithInsertionOrder.add(54);
        uniqueNumberWithInsertionOrder.add(65);
        uniqueNumberWithInsertionOrder.add(65);
        uniqueNumberWithInsertionOrder.add(72);
        uniqueNumberWithInsertionOrder.add(72);
        uniqueNumberWithInsertionOrder.add(95);
        uniqueNumberWithInsertionOrder.add(95);
        uniqueNumberWithInsertionOrder.add(100);
        uniqueNumberWithInsertionOrder.add(101);

        System.out.println(uniqueNumberWithInsertionOrder);


    }
}
