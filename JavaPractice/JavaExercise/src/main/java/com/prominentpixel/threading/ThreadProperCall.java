package com.prominentpixel.threading;

public class ThreadProperCall {

    public static void main(String[] args) {

        OddThread oddthread=new OddThread();

        oddthread.start();

        try {
            oddthread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        EvenThread evenThread=new EvenThread();

        Thread runEvenThread=new Thread(evenThread);

        runEvenThread.start();

        try {
            runEvenThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
