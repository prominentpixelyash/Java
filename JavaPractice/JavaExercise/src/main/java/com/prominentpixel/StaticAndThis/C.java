package com.prominentpixel.StaticAndThis;

public class C {

    int x=51;

    static int y=101;

    public static void usingVariableInMethod(){

        C c=new C();

        System.out.println("Inside class c variable x "+c.x);

        System.out.println("Inside clas c variable y "+y);

        C.y+=50;

        System.out.println("Inside clas c variable y "+C.y);

    }

    public static void main(String[] args) {
        usingVariableInMethod();
    }

}
