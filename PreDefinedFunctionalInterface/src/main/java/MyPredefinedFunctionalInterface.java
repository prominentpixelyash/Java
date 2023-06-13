import java.util.BitSet;
import java.util.Map;
import java.util.function.*;

public class MyPredefinedFunctionalInterface {

    public void myPredicate(){
        //created predicate for test number is greater than 100
        Predicate<Integer> p=num->num>100;

        System.out.println("Predicate for test number is greater than 100->"+p.test(10));
        System.out.println("Predicate for test number is greater than 100->"+p.test(101));
        System.out.println("Predicate for test number is greater than 100->"+p.test(20));
        System.out.println("Predicate for test number is greater than 100->"+p.test(25));
        System.out.println("Predicate for test number is greater than 100->"+p.test(151));
    }


    public void mySupplier(){

        Supplier<Double> s=()->3.14;

        System.out.println("Supplier is supplying the value of pie->"+s.get());

    }

    public void myConsumer(){

        Consumer<String> c=str-> System.out.println(str);

        c.accept("Welcome to predefined functional interface");

    }


    public void myFunction(){
        Function<Integer,Integer> f=a->a*a;

        System.out.println("Function is doing the square of apply number->"+f.apply(4));
        System.out.println("Function is doing the square of apply number->"+f.apply(5));
        System.out.println("Function is doing the square of apply number->"+f.apply(6));
        System.out.println("Function is doing the square of apply number->"+f.apply(7));
        System.out.println("Function is doing the square of apply number->"+f.apply(8));

    }


    public void myBiPredicate(){
        BiPredicate<Integer,Integer> byPredicate=(n1,n2)->n1==n2;
        System.out.println("BiPredicate out->"+byPredicate.test(20,30));
        System.out.println("BiPredicate out->"+byPredicate.test(21,21));
    }


    public void myIntPredicate(){
        IntPredicate intPredicate=num->num==21;
        System.out.println("IntPredicate output->"+intPredicate.test(10));
        System.out.println("IntPredicate output->"+intPredicate.test(21));
    }

    public void myDoublePredicate(){
        DoublePredicate doublePredicate= n->n%5==0;
        System.out.println("DoublePredicate output->"+doublePredicate.test(5.5));
        System.out.println("DoublePredicate output->"+doublePredicate.test(10.0));
    }

    public void myLongPredicate(){
        LongPredicate myLongPredicate=n->n%2==0;
        System.out.println("LongPredicate output->"+myLongPredicate.test(1000000000));
        System.out.println("LongPredicate output->"+myLongPredicate.test(1000000001));
    }


    public void myBiConsumer(){
        BiConsumer<String,Integer> myBiconsumer=(name, marks)-> System.out.println("Student name is "+name+" and marks is "+marks);
        myBiconsumer.accept("Yash",800);
    }

    public void myBiFunction(){
        BiFunction<Integer,Integer,String> myBiFunction=(n1,n2)->(n1+n2)==51?"Good Numbers":"Bad Numbers";
        System.out.println("BiFunction output->"+myBiFunction.apply(20,30));
        System.out.println("BiFunction output->"+myBiFunction.apply(21,30));
    }


    public static void main(String[] args) {

        MyPredefinedFunctionalInterface myPredefinedFunction=new MyPredefinedFunctionalInterface();
        myPredefinedFunction.myPredicate();
        myPredefinedFunction.mySupplier();
        myPredefinedFunction.myConsumer();
        myPredefinedFunction.myFunction();
        myPredefinedFunction.myBiPredicate();
        myPredefinedFunction.myIntPredicate();
        myPredefinedFunction.myDoublePredicate();
        myPredefinedFunction.myLongPredicate();
        myPredefinedFunction.myBiConsumer();
        myPredefinedFunction.myBiFunction();


    }
}
