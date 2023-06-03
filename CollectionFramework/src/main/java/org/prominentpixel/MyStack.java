package org.prominentpixel;

import java.util.Stack;

public class MyStack {

    public void myPush(){
        Stack<Integer> s=new Stack<>();

        System.out.println("before push method "+s);

        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20);
        s.push(25);

        System.out.println("after push method "+s);

    }

    public void myPop(){
        Stack<Integer> s=new Stack<>();

        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20);
        s.push(25);

        System.out.println("before pop method "+s);

        System.out.println("pop value "+s.pop());

        System.out.println("after pop method "+s);
    }


    public void myPeek(){

        Stack<Integer> s=new Stack<>();

        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20);
        s.push(25);

        System.out.println("peek value "+s.peek());


    }


    public void myEmpty(){

        Stack<Integer> s=new Stack<>();

        System.out.println("stack is empty or not "+s.empty());

        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20);
        s.push(25);

        System.out.println("stack is empty or not "+s.empty());

    }


    public void mySearch(){

        Stack<Integer> s=new Stack<>();

        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20);
        s.push(25);

        System.out.println("search value available or not "+s.search(75));

        System.out.println("search value available or not "+s.search(10));

    }

    public static void main(String[] args) {

        MyStack s=new MyStack();
        s.myPush();
        s.myPop();
        s.myPeek();
        s.myEmpty();
        s.mySearch();
    }
}
