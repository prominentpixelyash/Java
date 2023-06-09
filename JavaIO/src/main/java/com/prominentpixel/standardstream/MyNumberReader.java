package com.prominentpixel.standardstream;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class MyNumberReader {

    public static void main(String[] args) throws Exception {

        LineNumberReader lnr=new LineNumberReader(new FileReader("Day-3.txt"));

        lnr.skip(4);

        if(lnr.ready()){
            String line;

            while ((line=lnr.readLine())!=null){
                System.out.println(line);
                System.out.println(lnr.getLineNumber());
            }

        }



    }

}
