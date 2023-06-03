package org.prominentpixel;

import java.util.HashSet;

public class MyHashSet {

    public void myAdd(){

        HashSet<Integer> hs=new HashSet<>();

        System.out.println("before add elements "+hs);

        hs.add(5);
        hs.add(10);
        hs.add(15);
        hs.add(20);
        hs.add(25);
        hs.add(25);
        hs.add(25);
        hs.add(25);
        hs.add(25);


        System.out.println("after add elements "+hs);

    }


    public void myClear(){
        HashSet<Integer> hs=new HashSet<>();

        hs.add(5);
        hs.add(10);
        hs.add(15);
        hs.add(20);
        hs.add(25);
        hs.add(25);

        System.out.println("before clear method "+hs);

        hs.clear();

        System.out.println("after clear method "+hs);
    }


    public void myContains(){
        HashSet<Integer> hs=new HashSet<>();

        hs.add(5);
        hs.add(10);
        hs.add(15);
        hs.add(20);
        hs.add(25);

        System.out.println("contains method output "+hs.contains(15));
        System.out.println("contains method output "+hs.contains(50));
    }


    public void myRemove(){
        HashSet<Integer> hs=new HashSet<>();

        hs.add(5);
        hs.add(10);
        hs.add(15);
        hs.add(25);
        hs.add(25);
        hs.add(80);
        hs.add(85);
        hs.add(80);

        System.out.println("before remove method "+hs);

        hs.remove(25);

        System.out.println("after remove method "+hs);
    }

    public static void main(String[] args) {

        MyHashSet hs=new MyHashSet();
        hs.myAdd();
        hs.myContains();
        hs.myRemove();

    }

}
