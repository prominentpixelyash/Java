package com.prominentpixel.bytestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyInputStream {

    public static void main(String[] args) throws IOException {

        InputStream input=null;

        try {
            input =new FileInputStream("E:\\Yash Rajput\\Translate Data\\Day-3.txt");


            // Read() Method - Reading character and printing it
            // Reading one character at a time
            System.out.println("Char - "+(char)input.read());
            System.out.println("Char - "+(char)input.read());


            input.mark(6);

            input.skip(1);

            System.out.println("Char - "+(char)input.read());
            System.out.println("Char - "+(char)input.read());

            if(input.markSupported()){
                input.reset();
                System.out.println("Char - "+(char)input.read());
                System.out.println("Char - "+(char)input.read());
            }
            else {
                System.out.println("Reset method doesn't support");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (input!=null){
                input.close();
            }
        }
    }

}
