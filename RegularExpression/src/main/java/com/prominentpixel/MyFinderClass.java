package com.prominentpixel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFinderClass {

    public static void main(String[] args) {

        //with \s for only space

        System.out.println("with \\s for only space");

        Pattern p=Pattern.compile("\\s");

        Matcher m=p.matcher("a1@b2 Ac3d#");

        while (m.find()){
            System.out.println("Starting index "+m.start()+"----"+"Matches pattern "+m.group());
        }



        //with \\S for except space

        System.out.println("with \\S for except space");

        Pattern p1=Pattern.compile("[\\S]");
        Matcher m1=p1.matcher("a1@b2 Ac3d#");

        while (m1.find()){
            System.out.println("Starting index "+m1.start()+"----"+"Matches pattern "+m1.group());
        }



        //with \\d for digit

        System.out.println("with \\d for digit");

        Pattern p2=Pattern.compile("[\\d]");
        Matcher m2=p2.matcher("a1@b2 Ac3d#");

        while (m2.find()){
            System.out.println("Starting index "+m2.start()+"----"+"Matches pattern "+m2.group());
        }


        //with \\D for no digit

        System.out.println("with \\D for no digit");

        Pattern p3=Pattern.compile(".");
        Matcher m3=p3.matcher("a1@b2 Ac3d#");

        while (m3.find()){
            System.out.println("Starting index "+m3.start()+"----"+"Matches pattern "+m3.group());
        }

    }
}
