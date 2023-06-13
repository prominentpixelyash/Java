package com.prominentpixel;

@FunctionalInterface
public interface MySum {
    public  int sum(int a,int b);

    default void printInterfaceName(){
        System.out.println("Inside MySum Interface.........");
    }

    public static void pintStaticData(){
        System.out.println("MySum Interface inside of static method..........");
    }

}
