package com.prominentpixel.standardstream;

import java.io.CharArrayReader;

public class MyCharArrayRead {

    public static void main(String[] args) throws Exception {

        char[] charArray={'H','e','l','l','o','J','a','v','a'};

        CharArrayReader car=new CharArrayReader(charArray);

        int ch;

        while ((ch=car.read())!=-1){
            System.out.print((char) ch);
        }

    }

}
