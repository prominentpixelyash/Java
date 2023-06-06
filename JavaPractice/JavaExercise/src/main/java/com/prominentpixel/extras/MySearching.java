package com.prominentpixel.extras;

import java.util.Arrays;
import java.util.HashMap;

public class MySearching {

    public int myHashing(int[] numbers,int x){

        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            hashMap.put(numbers[i],i);
        }

        if(hashMap.containsKey(x)){
            return hashMap.get(x);
        }
        return -1;
    }

    public int myBinarySearch(int[] numbers,int x){

        int left=0;
        int right=numbers.length-1;

        while(left<=right){
            int mid=left+((right-left)/2);
            if(numbers[mid]==x){
                return mid;
            }
            else if(numbers[mid]<x){
                left=mid+1;
            }
            else if(numbers[mid]>x){
                right=mid-1;
            }
        }

        return -1;
    }

    public int myLinearSearch(int[] numbers,int x){

        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers={10,12,16,18,19,66,57,52,86,77,34,69,99};

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        int x=66;

        MySearching mySearching=new MySearching();
        int result1=mySearching.myLinearSearch(numbers,x);

        if(result1==-1){
            System.out.println("No such number is found in array");
        }
        else{
            System.out.println("Number is found on index number "+result1);
        }


        int result2=mySearching.myBinarySearch(numbers,x);

        if(result2==-1){
            System.out.println("No such number is found in array");
        }
        else{
            System.out.println("Number is found on index number "+result2);
        }

        int result3=mySearching.myHashing(numbers,x);

        if(result3==-1){
            System.out.println("No such number is found in array");
        }
        else{
            System.out.println("Number is found on index number "+result3);
        }

    }
}
