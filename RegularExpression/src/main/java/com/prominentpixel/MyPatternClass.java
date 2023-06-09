package com.prominentpixel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternClass {
    public static void main(String[] args) {

        Pattern p=Pattern.compile("ab");
        Matcher m=p.matcher("ababbaab");

        int numberOfMatch=0;

        while (m.find()){
            numberOfMatch++;
            System.out.println("Starting index "+m.start()+"------"+"Ending index "+m.end()+"------"+m.group());
        }

        System.out.println("Total number of match in with matcher string "+numberOfMatch);

    }
}
