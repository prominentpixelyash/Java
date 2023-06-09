package com.prominentpixel.bytestream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class MyOutputStream {

    public static void main(String[] args) throws Exception {

        OutputStream output=new FileOutputStream(".\\outputstream.txt");

        byte[] b={65,66,67,68,69,70};

        output.write(b);

        output.flush();

        for (int i=71;i<91;i++){
            output.write(i);
        }

        output.flush();

    }

}
