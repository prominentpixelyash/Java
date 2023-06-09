package com.prominentpixel.charstream;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MyInputStreamReader {

    public static void main(String[] args) throws Exception {

        InputStreamReader isr=new InputStreamReader(new FileInputStream("Day-3.txt"));

        int ch;

        while ((ch=isr.read())!=-1){
            System.out.print((char)ch);
        }

        System.out.println();

        System.out.println("Encoding used "+isr.getEncoding());

    }

}
