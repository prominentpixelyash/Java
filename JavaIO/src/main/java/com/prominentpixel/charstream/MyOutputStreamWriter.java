package com.prominentpixel.charstream;

import java.io.Console;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MyOutputStreamWriter {

    public static void main(String[] args) throws  Exception{

        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("oswriter.txt"));

        osw.write('H');

        osw.write("Hello Prominent");

        char[] arr={'J','A','V','A'};

        osw.write(arr);

        osw.close();


    }

}
