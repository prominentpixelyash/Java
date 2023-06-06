package com.prominentpixel.runtimeexception;

public class MyArrayIsFullGeneratorSolution {

    public static void main(String[] args) {

        int[] array=new int[11];

        try {
            if(array.length>10){
                throw new MyArrayIsFullException("Array size is greater than 10");
            }
            else{
                System.out.println("Array length is "+array.length);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
