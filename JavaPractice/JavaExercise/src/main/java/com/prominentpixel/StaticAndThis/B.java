package com.prominentpixel.StaticAndThis;

public class B extends A{

    int x=101;

    static int y=201;

    public void classBMethod(){
        System.out.println("This keyword is used to get the value of x "+this.x);
        System.out.println("Parent class value of x using super keyword "+super.x);
        System.out.println("Non static method can call it's class non-static variable directly "+y);
        System.out.println("Using this keyword call static variable " +this.y);
    }

    public static void main(String[] args) {
        B b=new B();
        b.classBMethod();
    }

}
