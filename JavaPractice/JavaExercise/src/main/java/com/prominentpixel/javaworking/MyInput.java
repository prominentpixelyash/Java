package com.prominentpixel.javaworking;

import java.util.Scanner;

public class MyInput {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName=scanner.next();
        System.out.println("Enter middle name");
        String middleName=scanner.next();
        System.out.println("Enter surname");
        String surName=scanner.next();

        System.out.println(firstName+" "+middleName+" "+surName);

    }
}