package com.prominentpixel.extras;

import java.util.Arrays;

public class MyWindows {

    public double[] myAvgWindow(int[] numbers){

        double[] avgOfWindows=new double[numbers.length];

        int sumOfWindow=0;

        for (int i=0;i<numbers.length;i++){
            sumOfWindow+=numbers[i];
            avgOfWindows[i]=sumOfWindow/(i+1.0);
        }

        return avgOfWindows;

    }

    public int[] maxOfEachWindow(int[] numbers){

        int lengthOfMaxOfEachWindow=numbers.length/2;

        int[] maxOfEachWindow=new int[lengthOfMaxOfEachWindow];

        for(int i=numbers.length-1;i>=1;i=i-2){
            lengthOfMaxOfEachWindow--;
            if(numbers[i]>numbers[i-1]){
                maxOfEachWindow[lengthOfMaxOfEachWindow]=numbers[i];
            }
            else{
                maxOfEachWindow[lengthOfMaxOfEachWindow]=numbers[i-1];
            }
        }
        return maxOfEachWindow;
    }


    public void minOfWindows(int[] numbers){
        int left=0;
        int right=numbers.length-1;
        int mid=left+((right-left)/2);
        left=mid-1;
        right=mid+1;

        while(left>=0 && right<numbers.length){
            int miniValue=minInRange(numbers,left,right);
            System.out.println("Minimum value in range of "+left+" to "+right+" is "+miniValue);
            left--;
            right++;
        }

    }

    public int minInRange(int[] numbers,int left,int right){
        int minValue=Integer.MAX_VALUE;

        for(int i=left;i<=right;i++){
            if(minValue>numbers[i]){
                minValue=numbers[i];
            }
        }
        return minValue;
    }


    public static void main(String[] args) {

        int[] numbers={1,2,3,4,5,6,7,8,9,10};

        MyWindows myWindows=new MyWindows();

        double[] avgOfWindows=myWindows.myAvgWindow(numbers);

        System.out.println(Arrays.toString(avgOfWindows));

        int[] maxOfEachWindows=myWindows.maxOfEachWindow(numbers);

        System.out.println(Arrays.toString(maxOfEachWindows));

        myWindows.minOfWindows(numbers);

    }

}
