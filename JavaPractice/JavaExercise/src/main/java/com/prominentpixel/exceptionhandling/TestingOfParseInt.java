package com.prominentpixel.exceptionhandling;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestingOfParseInt {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter value in string to parse it in int");
        String intValue=scanner.next();
        try {
            int result=Integer.parseInt(intValue);
            if(result>65000){
                try {
                    throw new MyIntParseException("Invalid ElasticSearch port configuration");
                } catch (MyIntParseException e) {
                    e.printStackTrace();
                }
            }
            else
            System.out.println("String to int value is successfully done");
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }
    }
}
