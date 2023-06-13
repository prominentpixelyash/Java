package com.prominentpixel;

import java.util.Comparator;

public class MyLambdaExpression{

    public static void main(String[] args) {

        MySum mysum=(a,b)->a+b;
        System.out.println("Sum of two numbers "+mysum.sum(20,31));

    }
}
