package com.prominentpixel.threading;

import java.util.concurrent.Callable;

public class MyNumbers implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        int sum1=0;

        for (int i=1;i<11;i++){
            System.out.println(Thread.currentThread().getName());
            sum1+=i;
        }
        return  sum1;
    }
}
