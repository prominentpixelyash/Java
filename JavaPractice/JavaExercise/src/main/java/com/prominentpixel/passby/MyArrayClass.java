package com.prominentpixel.passby;

import java.util.Arrays;

public class MyArrayClass {

    public static void main(String[] args) {
        int[] number={11};

        System.out.println("Original Array ->"+ Arrays.toString(number));

        number[0]=21;

        System.out.println("Changed Array ->"+Arrays.toString(number));


    }

}
