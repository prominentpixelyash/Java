package org.prominentpixel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStreamApi {

    public void myAllMatch(){

        List<Integer> l= Arrays.asList(1,3,5,7,9,11,13,15);
        System.out.println("allMatch result "+l.stream().allMatch(i->i%2==1));

    }


    public void myAnyMatch(){

        List<Integer> l= Arrays.asList(1,3,5,7,9,11,13,16);
        System.out.println("anyMatch result 1 "+l.stream().anyMatch(i->i%2==0));
        System.out.println("anyMatch result 2 "+l.stream().anyMatch(i->i>20));

    }

    public void myMap(){
        List<Integer> l=Arrays.asList(1,2,3,4,5);
        List<Integer> square=l.stream().map(i->i*i).collect(Collectors.toList());
        for(Integer sq:square){
            System.out.println("Square of "+Math.sqrt(sq*1.0)+"-"+sq);
        }
    }


    public void myFilter(){
        List<Integer> l=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        l.stream().filter(i->i%2==0).forEach(i-> System.out.print(i+" "));
        System.out.println();
    }


    public void mySorted(){
        List<Integer> l=Arrays.asList(2,1,4,3,6,5,8,7,10,9);
        List<Integer> sortedList=l.stream().sorted().collect(Collectors.toList());
        for(Integer num:sortedList) {
            System.out.print(num + " ");
        }
        System.out.println();

        List<Integer> revSorted=l.stream().sorted((num1,num2)-> num1>num2?-1:(num1<num2)?+1:0).collect(Collectors.toList());

        for(Integer num:revSorted) {
            System.out.print(num + " ");
        }
        System.out.println();

    }


    public void myForEach(){
        List<Integer> l=Arrays.asList(1,2,3,4,5);
        l.stream().forEach(i-> System.out.print(i+" "));
        System.out.println();
    }


    public void myCount(){
        List<Integer> l=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        long numOfElements=l.stream().count();
        System.out.println(numOfElements);
    }


    public void myDistinct(){
        List<Integer> l=Arrays.asList(1,2,3,2,5,6,3,8,9,1);
        List<Integer> distinctElements=l.stream().distinct().collect(Collectors.toList());
        for (Integer ele:distinctElements){
            System.out.print(ele+" ");
        }
        System.out.println();
    }


    public void myMinMax(){
        List<Integer> l=Arrays.asList(2,1,4,3,6,5,8,7,10,9);
        Optional<Integer> min = l.stream().min((num1, num2)->num1>num2?+1:num1<num2?-1:0);
        Optional<Integer> max = l.stream().max((num1, num2)->num1>num2?+1:num1<num2?-1:0);
        System.out.println(min.get());
        System.out.println(max.get());

        Optional<Integer> min1 = l.stream().min((n1, n2)->n1>n2?-1:n1<n2?+1:0);
        Optional<Integer> max2 = l.stream().max((n1, num2)->n1>num2?-1:n1<num2?+1:0);
        System.out.println(min1.get());
        System.out.println(max2.get());
    }


    public void myArray(){
        List<Integer> l=Arrays.asList(1,2,3,4,5,6);
        Integer[] arr=l.stream().toArray(Integer[]::new);
        for (Integer num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }


    public void myReduce(){
        List<Integer> l=Arrays.asList(1,2,3,4,5,6);
        int sumOfEvenNumber=l.stream().filter(i->i%2==0).reduce(0,(ans,i)->ans+i);
        System.out.println(sumOfEvenNumber);


        List<String> str=Arrays.asList("Node","Java","Cloud","Big Data","Search Engine");
        Optional<String> longestString=str.stream().reduce((s1,s2)->s1.length()>s2.length()?s1:s2);
        longestString.ifPresent(System.out::println);


        String[] companyData={"ProminentPixel","Office No 513/514","Sahjanand Circle","Mota Varachha","Surat"};
        Optional<String> comString=Arrays.stream(companyData).reduce((s1,s2)->s1+" "+s2);
        comString.ifPresent(System.out::println);

        int sumOfList=l.stream().reduce(0,(sum,num)->sum+num);
        System.out.println("Sum of list "+sumOfList);
    }


    public void mySkip(){
        List<Integer> l=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> skipList=l.stream().skip(4).collect(Collectors.toList());
        for (Integer num:skipList){
            System.out.print(num+" ");
        }
        System.out.println();
    }


    public void myLimit(){
        List<Integer> l=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> newList= l.stream().limit(2).collect(Collectors.toList());
        for(Integer num:newList){
            System.out.print(num+" ");
        }
        System.out.println();
    }


    public void myFlatMap(){
        Stream<List<String>> stream= Stream.of(
                Arrays.asList("Amit","Ravi"),
                Arrays.asList("Akash","Ravish"),
                Arrays.asList("Deepak","Vikram")
        );

        Stream<String> newStream=stream.flatMap(st->st.stream());

        newStream.forEach(str-> System.out.print(str+" "));

    }


    public static void main(String[] args) {

        MyStreamApi mystreamapi=new MyStreamApi();
        mystreamapi.myAllMatch();
        mystreamapi.myAnyMatch();
        mystreamapi.myMap();
        mystreamapi.myFilter();
        mystreamapi.mySorted();
        mystreamapi.myForEach();
        mystreamapi.myCount();
        mystreamapi.myDistinct();
        mystreamapi.myMinMax();
        mystreamapi.myArray();
        mystreamapi.myReduce();
        mystreamapi.mySkip();
        mystreamapi.myLimit();
        mystreamapi.myFlatMap();
    }
}
