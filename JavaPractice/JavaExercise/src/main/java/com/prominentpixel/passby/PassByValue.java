package com.prominentpixel.passby;

public class PassByValue {

    int x=21;

    public void passByValue(int x){
        x++;
    }

    public void passByValue(PassByValue pbv){
        pbv.x++;
    }

    public static void main(String[] args) {
        PassByValue pbv=new PassByValue();
        System.out.println("Before passing x value "+pbv.x);
        pbv.passByValue(pbv.x);
        System.out.println("After passing x value "+pbv.x);
        pbv.passByValue(pbv);
        System.out.println("After passing pbv value "+pbv.x);
    }
}
