package com.prominentpixel.charstream;

import java.io.FileReader;

public class MyFileReader {

    public static void main(String[] args) throws Exception{

        FileReader fr=new FileReader("message.txt");

        int ch;

        while ((ch=fr.read())!=-1){
            System.out.print((char) ch);
        }

        System.out.println();

        char[] arr={'p','o','m','p','x'};

        fr.read(arr);

        System.out.println(arr);

        fr.close();


    }

}
