package com.prominentpixel.runtimeexception;

public class MyArrayIsFullGenerator {

    public static void main(String[] args) throws MyArrayIsFullException {

        int[] array=new int[11];

        if(array.length>10){
            throw new MyArrayIsFullException("Array size is greater than 10");
        }
        else{
            System.out.println("Array length is "+array.length);
        }

    }

}
