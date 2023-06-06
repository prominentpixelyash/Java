package com.prominentpixel.threading;

public class OddThread extends Thread{

    @Override
    public void run(){

        for (int i=1;i<1000;i++){
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }

    }

}
