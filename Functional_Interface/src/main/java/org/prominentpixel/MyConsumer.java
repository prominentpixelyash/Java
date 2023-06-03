package org.prominentpixel;

import java.util.Arrays;
import java.util.List;

public class MyConsumer {

    public void  myAccept(){
        java.util.function.Consumer<String> c1= str->System.out.println(str);
        c1.accept("Hello ProminentPixel");

        java.util.function.Consumer<Integer> c2= i->System.out.println(i*2);
        c2.accept(513);
    }


    public void myAndThen(){
        List<Integer> l= Arrays.asList(1,2,3,4,5);

        java.util.function.Consumer<List<Integer>> c3= list->{
            for (int i=0;i<list.size();i++){
                list.set(i,2*list.get(i));
            }
        };

        java.util.function.Consumer<List<Integer>> c4= list->list.stream().forEach(i->System.out.print(i+" "));

        c3.andThen(c4).accept(l);
    }

    public static void main(String[] args) {

        MyConsumer myconsumer=new MyConsumer();
        myconsumer.myAccept();
        myconsumer.myAndThen();

    }
}
