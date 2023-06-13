package com.prominentpixel.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prominentpixel.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyJacksonInheritance {


    public  void serializationOfObjectWithJackson(List<Employee2> employeeList){

        ObjectMapper mapper=new ObjectMapper();

        try {
            PrintWriter pw=new PrintWriter("listOfEmployee.txt");

            mapper.writerWithDefaultPrettyPrinter().writeValue(pw,employeeList);

            pw.flush();
            pw.close();

            System.out.println("Serialization of list of employee is done with the help of jackson");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void deserializationOfObjectWithJackson(){

        ObjectMapper mapper=new ObjectMapper();

        try {

            BufferedReader br=new BufferedReader(new FileReader("listOfEmployee.txt"));

            Employee2[] employees=mapper.readValue(br,Employee2[].class);

            System.out.println("Inside deserialization of object with Jackson");

            System.out.println(Arrays.toString(employees));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        List<Employee2> listOfEmployee=new ArrayList<>();

        listOfEmployee.add(new Manager(1,"Yati","Node",null, EmpType.MANAGER,"node js code"));
        listOfEmployee.add(new HR(2,"Nitin","Spring Boot",null,EmpType.HR,"8956231471","nitin123@gmail.com"));


        MyJacksonInheritance inheritance=new MyJacksonInheritance();
        inheritance.serializationOfObjectWithJackson(listOfEmployee);
        inheritance.deserializationOfObjectWithJackson();


    }

}
