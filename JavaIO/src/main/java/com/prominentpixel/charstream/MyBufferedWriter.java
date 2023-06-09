package com.prominentpixel.charstream;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MyBufferedWriter {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw=new BufferedWriter(new FileWriter("abc.txt"));

        bw.write(65);

        bw.write(66);

        bw.write(67);

        bw.write(68);

        bw.flush();

        bw.newLine();

        bw.write("Hello Prominent",6,9);

        bw.newLine();

        bw.write("Hello Java");

        bw.newLine();

        bw.write("Hello Surat");

        bw.close();

    }

}
