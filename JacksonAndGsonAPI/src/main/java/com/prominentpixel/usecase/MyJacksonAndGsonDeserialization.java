package com.prominentpixel.usecase;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prominentpixel.models.Address;
import com.prominentpixel.models.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyJacksonAndGsonDeserialization {

    public void readObjectFromTxtWithGson(){

        Gson gson=new GsonBuilder().setPrettyPrinting().create();

        try {
            BufferedReader bf=new BufferedReader(new FileReader("singleEmployeeDataWithGson.txt"));

            Employee employee=gson.fromJson(bf,Employee.class);

            bf.close();

            System.out.println("Inside read object of json file with the help of gson");

            printEmployeeObject(employee);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void readListOfObjectFromTxtWithGson(){

        Gson gson=new GsonBuilder().setPrettyPrinting().create();

        try {
            BufferedReader bf=new BufferedReader(new FileReader("listEmployeeDataWithGson.txt"));

            Employee[] employees=gson.fromJson(bf,Employee[].class);

            bf.close();

            System.out.println("Inside read list of object of json file with the help of gson");

            for (Employee emp:employees){
                printEmployeeObject(emp);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void readObjectFromTxtWithJackson(){

        ObjectMapper mapper=new ObjectMapper();

        try {
            BufferedReader br=new BufferedReader(new FileReader("singleEmployeeDataWithJackson.txt"));

            Employee employee=mapper.readValue(br,Employee.class);

            System.out.println("Inside read object of json file with the help of jackson");

            printEmployeeObject(employee);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void readListOfObjectFromTxtWithJackson(){

        ObjectMapper mapper=new ObjectMapper();

        try {
            BufferedReader br=new BufferedReader(new FileReader("listEmployeeDataWithJackson.txt"));

            Employee[] employees=mapper.readValue(br,Employee[].class);

            System.out.println("Inside read list of object of json file with the help of jackson");

            for (Employee emp:employees){
                printEmployeeObject(emp);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void printEmployeeObject(Employee employee){


        System.out.println("Employee id is "+employee.getId());
        System.out.println("Employee name is "+employee.getName());
        System.out.println("Employee department is "+employee.getDepartment());
        System.out.println("Employee street is "+employee.getAddress().getStreet());
        System.out.println("Employee city is "+employee.getAddress().getCity());
        System.out.println("Employee state is "+employee.getAddress().getState());
        System.out.println("Employee pin code is "+employee.getAddress().getPinCode());

    }

    public static void main(String[] args) {

        List<Employee> listOfEmployee=new ArrayList<>();
        listOfEmployee.add(new Employee(1,"Yati","Mern",new Address("Krishna Nagar","Junagadh","Gujarat","500321")));
        listOfEmployee.add(new Employee(2,"Nitin","Java",new Address("Sai Nagar","Pune","Maharashtra","758596")));
        listOfEmployee.add(new Employee(3,"Yash","Core Java",new Address("Mahadev Nagar","Surat","Gujarat","394327")));
        listOfEmployee.add(new Employee(4,"Amit","Processor",new Address("Adarsh Nagar","Bangalore","Karnataka","142536")));
        listOfEmployee.add(new Employee(5,"Ravi","Telecom",new Address("Ambika Nagar","Mumbai","Maharashtra","758510")));


        MyJacksonAndGsonDeserialization deserialization=new MyJacksonAndGsonDeserialization();
        deserialization.readObjectFromTxtWithGson();
        deserialization.readListOfObjectFromTxtWithGson();
        deserialization.readObjectFromTxtWithJackson();
        deserialization.readListOfObjectFromTxtWithJackson();



    }

}
