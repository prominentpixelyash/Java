package com.prominentpixel.charstream;

import java.io.FileWriter;

public class MyFileWriter {

    public static void main(String[] args) throws Exception {

        FileWriter fw=new FileWriter("filewriter.txt");

        fw.write("Hello ProminentPixel");

        fw.close();

    }
}
