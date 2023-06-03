package org.prominentpixel;

import java.util.function.Function;

public class MyFunction {

    public void myApply(){
        java.util.function.Function<Integer,Integer> f1= i->i*i;
        System.out.println("Square of 5 is "+f1.apply(5));
        System.out.println("Square of 6 is "+f1.apply(6));
        System.out.println("Square of 7 is "+f1.apply(7));

        java.util.function.Function<Integer,String> f2= i-> i%2==0?"Even Number":"Odd Number";
        System.out.println( f2.apply(50));
        System.out.println( f2.apply(51));

    }

    public void MyAndThen(){

        Function<Integer,Double> half=i->i/2.0;
        System.out.println(half.andThen(i->3*i).apply(15));

    }


    public void MyCompose(){

        Function<Integer,Double> half=i->i/2.0;
        half=half.compose(i->i*3);
        System.out.println(half.apply(5));

    }
    
    
    public void MyIdentity(){

        Function<Integer,Integer> f=Function.identity();
        System.out.println(f.apply(20));

    }

    public static void main(String[] args) {

        MyFunction myfunction=new MyFunction();
        myfunction.myApply();
        myfunction.MyAndThen();
        myfunction.MyCompose();
        myfunction.MyIdentity();
    }
}
