package com.prominentpixel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCharacterClass {

    public static void main(String[] args) {

        //example 1
        Pattern p=Pattern.compile("[a-z]");

        Matcher m=p.matcher("a1@b2Ac3d#");

        while (m.find()){
            System.out.println("Starting index "+m.start()+"----"+"Matches pattern "+m.group());
        }


        //example 2
        Pattern p1=Pattern.compile("[a-zA-Z0-9]");

        Matcher m1=p1.matcher("a1@b2Ac3d#");

        while (m1.find()){
            System.out.println("Starting index "+m1.start()+"----"+"Matches pattern "+m1.group());
        }


        //example 3
        Pattern p2=Pattern.compile("[a-d [h-l]]");

        Matcher m2=p2.matcher("abcdefghijklmnopqrstuvwxyz");

        while (m2.find()){
            System.out.println("Starting index "+m2.start()+"----"+"Matches pattern "+m2.group());
        }


    }

}
