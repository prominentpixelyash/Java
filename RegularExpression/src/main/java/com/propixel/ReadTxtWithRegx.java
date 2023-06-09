package com.propixel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTxtWithRegx {

    public static void main(String[] args) throws IOException {

        Writer w=new FileWriter("txtNum.txt");

        w.write("There were 2 people ahead of me, and 22 behind me. The queues for other advisors had 10 and 12 people.");

        w.flush();

        w.close();

        Pattern p=Pattern.compile("[0-9]+");


        BufferedReader br=new BufferedReader(new FileReader("txtNum.txt"));

        String line;

        List<Integer> listOfNumberInTxt=new ArrayList<>();

        while ((line=br.readLine())!=null){

            String[] words=line.split(" ");

            for (String str:words){

                Matcher m=p.matcher(str);

                if (m.find() && m.group().equals(str)){
                    listOfNumberInTxt.add(Integer.parseInt(m.group()));
                }

            }

        }

        System.out.println(listOfNumberInTxt);

    }

}
