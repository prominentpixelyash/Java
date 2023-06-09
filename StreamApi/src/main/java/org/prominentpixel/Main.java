package org.prominentpixel;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> listOfEmployee=new ArrayList<>();

        listOfEmployee.add(new Employee(1,"Amit",150000,Arrays.asList("Bangalore","Chalthan","Haryana")));
        listOfEmployee.add(new Employee(2,"Akash",170000,Arrays.asList("Vareli","Tathithaya","Gorakhpur")));
        listOfEmployee.add(new Employee(3,"Abhishek",50000,Arrays.asList("Pune","Vadodara","Gorakhpur")));
        listOfEmployee.add(new Employee(4,"Ravi",40000,Arrays.asList("Bihar","Bardoli","Valsad")));
        listOfEmployee.add(new Employee(5,"Yash",51000,Arrays.asList("Kadodara","Surat","Mathura")));


        //map use
        List<List<String>> mapEmployee=listOfEmployee.stream().map(e->e.address).collect(Collectors.toList());

        System.out.println(mapEmployee);


        //flatMap use
        List<String> flatMapEmployee=listOfEmployee.stream().flatMap(e->e.address.stream()).collect(Collectors.toList());

        System.out.println(flatMapEmployee);




    }
}