package org.prominentpixel;

import java.util.*;

public class MyArrayList {

    public void arrayListConstructor(){

        //Zero-Arg Constructor
        ArrayList<String> arr1=new ArrayList<>();
        arr1.add("Hello");
        arr1.add("Java");

        System.out.println(arr1);


        //Parameterize constructor with initial capacity
        ArrayList<Integer> arr2=new ArrayList<>(5);
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);

        System.out.println(arr2);


        //Parameterize constructor with collection parameter
        Set<String> set=new HashSet<>();
        set.add("Hello");
        set.add("ProminentPixel");
        set.add("513/514");
        set.add("Mota Varachha");
        set.add("Surat");

        ArrayList<String> arr3=new ArrayList<>(set);

        System.out.println(arr3);


    }

    public void myAdd(){

        //add(object o)
        ArrayList<Integer> arrayList=new ArrayList<>();

        System.out.println("Before Add method output "+arrayList);

        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(15);
        arrayList.add(20);
        arrayList.add(25);

        System.out.println("Add method output "+arrayList);



        //add(index i,object o)
        ArrayList<Integer> arrayList1=new ArrayList<>();

        System.out.println("Before Add(index,object) method output "+arrayList1);

        arrayList1.add(0,101);
        arrayList1.add(1,111);
        arrayList1.add(2,121);
        arrayList1.add(3,151);
        arrayList1.add(4,201);

        System.out.println("After Add(index,object) method output "+arrayList1);



        //addAll

        System.out.println("Before addAll method "+arrayList);

        arrayList.addAll(arrayList1);

        System.out.println("After addAll method "+arrayList);



        //addAll(index,collection)

        System.out.println("before add(index,collection) method "+arrayList1);

        arrayList1.addAll(2,arrayList);

        System.out.println("After add(index,collection) method "+arrayList1);

    }


    public void myClone(){

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);


        ArrayList<Integer> arrayList1= (ArrayList<Integer>) arrayList.clone();

        System.out.println("ArrayList clone output "+arrayList1);

    }


    public void myContains(){

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("contains method output "+arrayList.contains(4));
        System.out.println("contains method output "+arrayList.contains(15));


    }


    public void myClear(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Before clear method "+arrayList);

        arrayList.clear();

        System.out.println("After clear method "+arrayList);
    }


    public void myForEach(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.forEach(System.out::println);

    }

    public void myGet(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("get method output "+arrayList.get(4));
    }


    public void myIndexOf(){
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("indexof method output "+arrayList.indexOf(3));
        System.out.println("indexof method output "+arrayList.indexOf(15));
    }


    public void myRemove(){

        //remove(index)
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("before remove(index) method output "+arrayList);

        arrayList.remove(4);

        System.out.println("after remove(index) method output "+arrayList);




        //remove(object)
        ArrayList<Integer> arrayList1=new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);
        arrayList1.add(65);

        System.out.println("before remove(object) method output "+arrayList1);

        arrayList1.remove(Integer.valueOf(65));

        System.out.println("after remove(object) method output "+arrayList1);


        //removeIf(Predicate)

        System.out.println("Before remove(Predicate) method output "+arrayList1);

        arrayList1.removeIf(i->i%2==0);

        System.out.println("After remove(Predicate) method output "+arrayList1);


        //removeAll(Collection)

        System.out.println("Before removeAll method output "+arrayList);

        arrayList.removeAll(arrayList1);

        System.out.println("After removeAll method output "+arrayList);

    }


    public void myToArray(){

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Object[] arr= arrayList.toArray();

        System.out.println("List to array "+ Arrays.toString(arr));


        ArrayList<Integer> arrayList1=new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);

        Integer[] arr1= arrayList1.toArray(Integer[]::new);

        System.out.println("List to array "+ Arrays.toString(arr1));

    }


    public static void main(String[] args) {

        MyArrayList myArrayList=new MyArrayList();

        myArrayList.myAdd();
        myArrayList.arrayListConstructor();
        myArrayList.myClone();
        myArrayList.myContains();
        myArrayList.myClear();
        myArrayList.myForEach();
        myArrayList.myGet();
        myArrayList.myIndexOf();
        myArrayList.myRemove();
        myArrayList.myToArray();
    }

}
