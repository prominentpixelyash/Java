package org.prominentpixel;

public class MySupplier {

    public void myget(){
        java.util.function.Supplier<Double> s1=()->Math.random();
        System.out.println("Random number "+s1.get());


        java.util.function.Supplier<Double> s2=()->3.14;
        System.out.println("Value of Pia is "+s2.get());
    }

    public static void main(String[] args) {

        MySupplier mysupplier=new MySupplier();
        mysupplier.myget();

    }
}
