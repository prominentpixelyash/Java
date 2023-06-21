package com.prominentpixel;

import java.util.Arrays;
import java.util.List;

public class DebugDemo {

    // put here break point
    public void printMessage(List<String> message){

        for (int i=0;i<message.size();i++){
            System.out.print(message.get(i)+" ");
        }
        System.out.println();
        printNumbers(message.size());
        int sumOfMessageListSize=sumOfNumbers(message.size());
        System.out.println("Sum of message list size "+sumOfMessageListSize);

    }

    public void printNumbers(int n){

        for (int i=1;i<=n;i++){
            System.out.println("Number -> "+i);
        }

    }

    public int sumOfNumbers(int n){

        int sum=0;
        for (int i=0;i<=n;i++){
            sum+=i;
        }
        return sum;

    }


    // to here break point
    public void printMessageFromCompany(){

        System.out.println("Thanks for using debug tool of ProminentPixel");

    }

    public static void main(String[] args) {

        List<String> message= Arrays.asList("Hello","Java","We","are","trying","to","run","our","application","in","debug","mode");

        DebugDemo demo=new DebugDemo();
        demo.printMessage(message);
        demo.printMessageFromCompany();
    }

}
