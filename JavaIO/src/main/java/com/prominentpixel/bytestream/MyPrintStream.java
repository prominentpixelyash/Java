package com.prominentpixel.bytestream;

import java.io.PrintStream;

public class MyPrintStream {

    public static void main(String[] args) throws Exception {

        String message="Hello ProminentPixel";

        PrintStream printStream=new PrintStream(".\\message.txt");

        printStream.print(message);

        printStream.close();

    }

}
