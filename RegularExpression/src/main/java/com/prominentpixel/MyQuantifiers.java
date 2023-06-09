package com.prominentpixel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyQuantifiers {

    public static void main(String[] args) {

        System.out.println("with a occurrence");

        Pattern p=Pattern.compile("a");

        Matcher m=p.matcher("abaabaaab");

        while (m.find()){
            System.out.println("Starting index "+m.start()+"----"+"Matches pattern "+m.group());
        }




        System.out.println("with a+ occurrence");

        Pattern p1=Pattern.compile("a+");

        Matcher m1=p1.matcher("abaabaaab");

        while (m1.find()){
            System.out.println("Starting index "+m1.start()+"----"+"Matches pattern "+m1.group());
        }




        System.out.println("with a* occurrence");

        Pattern p2=Pattern.compile("a*");

        Matcher m2=p2.matcher("abaabaaab");

        while (m2.find()){
            System.out.println("Starting index "+m2.start()+"----"+"Matches pattern "+m2.group());
        }



        System.out.println("with a? occurrence");

        Pattern p3=Pattern.compile("a?");

        Matcher m3=p3.matcher("abaabaaab");

        while (m3.find()){
            System.out.println("Starting index "+m3.start()+"----"+"Matches pattern "+m3.group());
        }


    }
}
