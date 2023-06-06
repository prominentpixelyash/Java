package com.prominentpixel.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorFrameWork {

    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        try {
            System.out.println(executorService.submit(new MyNumbers()).get());
            System.out.println(executorService.submit(new MyNumberOperation()).get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

}
