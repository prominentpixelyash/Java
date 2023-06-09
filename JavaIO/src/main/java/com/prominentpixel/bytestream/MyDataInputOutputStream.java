package com.prominentpixel.bytestream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyDataInputOutputStream {

    public static void main(String[] args) throws Exception {

        DataOutputStream dos=new DataOutputStream(new FileOutputStream(".\\datatype.txt"));

        dos.writeByte(65);
        dos.writeChar('G');
        dos.writeDouble(25.25);
        dos.writeInt(51);
        dos.writeBoolean(true);

        dos.flush();

        dos.close();

        DataInputStream dis=new DataInputStream(new FileInputStream(".\\datatype.txt"));

        System.out.println((char) dis.readByte());
        System.out.println(dis.readChar());
        System.out.println(dis.readDouble());
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());

        dis.close();

    }

}
