package com.prominentpixel.secondpackage;

import com.prominentpixel.firstpackage.FirstClass;
import com.prominentpixel.firstpackage.SecondClass;

public class TestPackages {

    public static void main(String[] args) {

        FirstClass fc=new FirstClass();

        fc.printClassName();

        int operation=fc.firstClassVariable+50;

        System.out.println("Variable in second package in test class "+operation);

    }
}
