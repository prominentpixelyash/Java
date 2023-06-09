package com.prominentpixel.bytestream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class MyBufferedOutputStream {

    public static void main(String[] args) throws  Exception {

        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(".\\bytestream.txt"));

        byte[] b={65,66,67,68,69,70};

        bos.write(b);

        for (int i=71;i<91;i++){
            bos.write(i);
        }

        bos.close();

    }
}
