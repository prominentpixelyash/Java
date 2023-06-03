package org.prominentpixel;

import java.util.function.Predicate;

public class MyPredicate {

    public void myTest(){
        java.util.function.Predicate<Integer> p1= i->i%2==0;
        System.out.println(p1.test(50));
        System.out.println(p1.test(51));
    }

    public void myNegate(){
        Predicate<Integer> p2=i->i<10;
        Predicate<Integer> p3=i->i>20;

        boolean result1=p2.negate().test(15);
        System.out.println("result1 "+result1);

        boolean result2=p2.negate().test(15);
        System.out.println("result2 "+result2);
    }


    public void myOr(){
        Predicate<String> p4=str->str.length()>10;

        Predicate<String> containsA=s->s.contains("A");

        boolean result3=p4.or(containsA).test("ProminentPixel");

        System.out.println("result3 "+result3);
    }


    public void myAnd(){
        Predicate<String> p4=str->str.length()>10;

        Predicate<String> p5=str->str.equals("prominentpixel");

        String str="prominentpixel";

        boolean result4=p4.and(p5).test(str);

        System.out.println("result4 "+result4);
    }

    public void myIsEquals(){

        Predicate<String> p6=Predicate.isEqual("prominentpixel");

        System.out.println("result5 "+p6.test("hello"));

    }



    public static void main(String[] args) {

        MyPredicate mypredicate=new MyPredicate();
        mypredicate.myTest();
        mypredicate.myNegate();
        mypredicate.myOr();
        mypredicate.myAnd();
        mypredicate.myIsEquals();

    }
}
