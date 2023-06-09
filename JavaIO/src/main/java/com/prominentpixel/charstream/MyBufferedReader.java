package com.prominentpixel.charstream;

import java.io.BufferedReader;
import java.io.FileReader;

public class MyBufferedReader {
    public static void main(String[] args) throws  Exception {

        BufferedReader br=new BufferedReader(new FileReader("Day-3.txt"));

        if(br.ready()){
            String line;

            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        }

        //mark and reset method
//        System.out.println((char)br.read());
//        System.out.println((char)br.read());
//        System.out.println((char)br.read());
//        System.out.println((char)br.read());
//
//        br.mark(1);
//
//        System.out.println((char)br.read());
//
//        br.reset();
//
//        System.out.println((char)br.read());
//        System.out.println((char)br.read());
//        System.out.println((char)br.read());
//        System.out.println((char)br.read());

    }
}
