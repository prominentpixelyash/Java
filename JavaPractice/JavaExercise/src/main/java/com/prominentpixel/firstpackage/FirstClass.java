package com.prominentpixel.firstpackage;

public class FirstClass {

    public int firstClassVariable=501;

    public void printClassName(){
        System.out.println("Inside first class.........");
    }

    public static void main(String[] args) {
        FirstClass fc=new FirstClass();
        System.out.println("Variable inside first class"+fc.firstClassVariable);
    }

}
