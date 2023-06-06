package com.prominentpixel.runtimeexception;

public class MyArrayIsFullException extends RuntimeException{

    public MyArrayIsFullException(){

    }
    public MyArrayIsFullException(String message){
        super(message);
    }

}
