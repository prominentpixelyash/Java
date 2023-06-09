package com.prominentpixel.secondpackage;

import com.prominentpixel.firstpackage.SecondClass;

public class ThirdClass extends SecondClass{

    public static void main(String[] args) {

        ThirdClass tc=new ThirdClass();
        tc.printClassName();

        int operation=tc.secondClassVariable+110;

        System.out.println("Variable inside second package inside third class "+operation);

    }

}
