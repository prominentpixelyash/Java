package org.prominentpixel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {

    public void myConstructor(){

        //Zero-Arg constructor
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(5);
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);


        List<Integer> list=Arrays.asList(1,2,3,4,5,6);

        LinkedList<Integer> ll1=new LinkedList<>(list);

        System.out.println("with collection constructor"+ll1);

    }

    public void myAdd(){

        LinkedList<Integer> ll=new LinkedList<>();

        System.out.println("before add method "+ll);

        ll.add(5);
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);

        System.out.println("After add method"+ll);


        ll.add(5,30);

        System.out.println("after add(index,elements) "+ll);

        LinkedList<Integer> ll1=new LinkedList<>();
        ll1.add(35);
        ll1.add(40);
        ll1.add(45);
        ll1.add(50);
        ll1.add(55);


        System.out.println("before addAll method "+ll);

        ll.addAll(ll1);

        System.out.println("After addAll method "+ll);

        ll.addFirst(0);
        ll.addLast(60);

        System.out.println("After addFirst and addLast "+ll);

    }


    public void myGet(){

        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(5);
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);


        System.out.println("get method output "+ll.get(4));

        System.out.println("getFirst method output "+ll.getFirst());

        System.out.println("getLast method output "+ll.getLast());


    }


    public void myOffer(){
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(5);
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);

        ll.offer(30);

        System.out.println("offer method output "+ll);

        ll.offerFirst(0);

        System.out.println("offerFirst method output "+ll);

        ll.offerLast(35);

        System.out.println("offerLast method output "+ll);

    }


    public void myPeek(){
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(5);
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);

        System.out.println("peek method output "+ll.peek());

        System.out.println("peekFirst method output "+ll.peekFirst());

        System.out.println("peekLast method output "+ll.peekLast());

    }


    public void myPoll(){
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(5);
        ll.add(10);
        ll.add(15);
        ll.add(20);
        ll.add(25);

        ll.poll();

        System.out.println("poll method output "+ll);

        ll.pollFirst();

        System.out.println("pollFirst method output "+ll);

        ll.pollLast();

        System.out.println("pollLast method output "+ll);

    }

    public void myPush(){

        LinkedList<Integer> ll=new LinkedList<>();

        System.out.println("before push method "+ll);

        ll.push(5);
        ll.push(10);
        ll.push(15);
        ll.push(20);
        ll.push(25);

        System.out.println("After push method "+ll);
    }

    public void myPop(){

        LinkedList<Integer> ll=new LinkedList<>();

        ll.push(5);
        ll.push(10);
        ll.push(15);
        ll.push(20);
        ll.push(25);

        System.out.println("before pop method "+ll);

        ll.pop();

        System.out.println("after pop method "+ll);

    }

    public static void main(String[] args) {

        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.myConstructor();
        myLinkedList.myAdd();
        myLinkedList.myGet();
        myLinkedList.myOffer();
        myLinkedList.myPeek();
        myLinkedList.myPoll();
        myLinkedList.myPush();
        myLinkedList.myPop();
    }

}
