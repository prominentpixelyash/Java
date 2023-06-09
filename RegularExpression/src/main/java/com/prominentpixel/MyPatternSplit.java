package com.prominentpixel;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternSplit {

    public static void main(String[] args) {

        //with 'a' split
        System.out.println("with 'a' split");
        Pattern p= Pattern.compile("a");
        String[] s= p.split("Java World with data exchange");

        System.out.println("String Array->"+ Arrays.toString(s));

        for (String s1:s){
            System.out.println(s1);
        }


        //with space split
        System.out.println("with space split");
        Pattern p1= Pattern.compile("\\s");
        String[] s1= p1.split("Java World with data exchange");

        System.out.println("String Array->"+ Arrays.toString(s1));

        for (String s2:s1){
            System.out.println(s2);
        }


        // with . split
        System.out.println("with . split");
        Pattern p2=Pattern.compile("\\.");
        String[] s2=p2.split("www.prominentpixel.com");

        System.out.println("String Array->"+ Arrays.toString(s2));

        for (String s3:s2){
            System.out.println(s3);
        }


    }

}
