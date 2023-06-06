package com.prominentpixel.datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountUniquePair {

    public static void main(String[] args) {
        int[] numbers={10,10,11,11,11,15,15,17,18,19,20,21};

        int uniqueCount=0;

        HashSet<Integer> uniqueNumberInArray=new HashSet<>();

        for (Integer number:numbers){
            uniqueNumberInArray.add(number);
        }

        List<Integer> uniqueListOfNumber=new ArrayList<>(uniqueNumberInArray);

        for (int i=0;i<uniqueListOfNumber.size()-1;i++){
            for (int j=i+1;j<uniqueListOfNumber.size();j++){
                uniqueCount++;
            }
        }

        System.out.println(uniqueListOfNumber);

        System.out.println(uniqueCount);

    }
}
