package com.prominentpixel.threading;

import java.util.concurrent.Callable;

public class MyNumberOperation implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum2=0;

        for (int i=11;i<21;i++){
            System.out.println(Thread.currentThread().getName());
            sum2+=i;
        }
        return  sum2;
    }
}
