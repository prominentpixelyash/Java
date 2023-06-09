package com.prominentpixel.bytestream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MyBufferedInputStream {

    public static void main(String[] args) throws Exception {

        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(".\\message.txt"));

        System.out.println(bis.available());

        int ch;

        while ((ch=bis.read())!=-1){
            System.out.print((char)ch);
        }

    }

}
