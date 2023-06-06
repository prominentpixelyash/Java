package com.prominentpixel.readfiles;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MyFileReader {
    public static void main(String[] args) {

        try {
            BufferedReader br=new BufferedReader(new FileReader("C:\\read.txt"));
            String line;
            while(((line= br.readLine())!=null)){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
