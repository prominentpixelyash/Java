package com.prominentpixel.bytestream;

import java.io.FileInputStream;

public class MyFileInputStream {

    public static void main(String[] args) throws Exception{

        FileInputStream fis=new FileInputStream(".\\message.txt");

        System.out.println(fis.getChannel());

        System.out.println(fis.getFD());

        System.out.println(fis.available());

        int ch;

        while ((ch=fis.read())!=-1){
            System.out.print((char)ch);
        }

        fis.close();

    }

}
