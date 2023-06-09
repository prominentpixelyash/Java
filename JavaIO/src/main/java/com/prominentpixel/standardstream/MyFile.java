package com.prominentpixel.standardstream;

import java.io.File;

public class MyFile {

    public static void main(String[] args) throws Exception{

        File f=new File("Day-3.txt");

        System.out.println(f.isFile());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getName());
        System.out.println(f.compareTo(new File("abc.txt")));
        System.out.println(f.exists());
        System.out.println(f.length());

    }

}
