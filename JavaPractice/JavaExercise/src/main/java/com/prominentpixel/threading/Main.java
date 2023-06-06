package com.prominentpixel.threading;

public class Main {
    public static void main(String[] args) {

        OddThread oddthread=new OddThread();
        EvenThread eventhread=new EvenThread();

        Thread runEvenThread=new Thread(eventhread);

        oddthread.start();
        runEvenThread.start();
    }
}
