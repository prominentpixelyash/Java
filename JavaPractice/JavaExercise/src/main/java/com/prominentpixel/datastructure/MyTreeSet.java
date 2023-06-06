package com.prominentpixel.datastructure;

import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {

        TreeSet<Integer> treeset=new TreeSet<>((n1,n2)->n1>n2?-1:n1<n2?+1:0);

        treeset.add(50);
        treeset.add(2);
        treeset.add(1);
        treeset.add(95);
        treeset.add(65);
        treeset.add(55);

        System.out.println(treeset);


    }
}
