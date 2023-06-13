package com.prominentpixel.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prominentpixel.models.Address;
import com.prominentpixel.models.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MyJacksonAndGsonSerialization {

    public void gsonToJsonWithSerialization(Employee employee){

        Gson gson=new GsonBuilder().setPrettyPrinting().create();

        try {
            PrintWriter pw=new PrintWriter("singleEmployeeDataWithGson.txt");

            gson.toJson(employee,pw);

            pw.flush();
            pw.close();

            System.out.println("Employee object store in json with the help of gson");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void gsonToJsonWithSerialization(List<Employee> employeeList){

        Gson gson=new GsonBuilder().setPrettyPrinting().create();

        try {
            PrintWriter pw=new PrintWriter("listEmployeeDataWithGson.txt");

            gson.toJson(employeeList,pw);

            pw.flush();
            pw.close();

            System.out.println("Employee list is store in json with the help of gson");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void jacksonToJsonWithSerialization(Employee employee){

        ObjectMapper mapper=new ObjectMapper();

        try {
            PrintWriter pw=new PrintWriter("singleEmployeeDataWithJackson.txt");
            mapper.writerWithDefaultPrettyPrinter().writeValue(pw,employee);

            pw.flush();
            pw.close();

            System.out.println("Employee object store in json with the help of jackson");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void jacksonToJsonWithSerialization(List<Employee> employeeList){

        ObjectMapper mapper=new ObjectMapper();

        try {
            PrintWriter pw=new PrintWriter("listEmployeeDataWithJackson.txt");

            mapper.writerWithDefaultPrettyPrinter().writeValue(pw,employeeList);

            pw.flush();
            pw.close();

            System.out.println("Employee list is store in json with the help of jackson");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        List<Employee> listOfEmployee=new ArrayList<>();
        listOfEmployee.add(new Employee(1,"Yati","Mern",new Address("Krishna Nagar","Junagadh","Gujarat","500321")));
        listOfEmployee.add(new Employee(2,"Nitin","Java",new Address("Sai Nagar","Pune","Maharashtra","758596")));
        listOfEmployee.add(new Employee(3,"Yash","Core Java",new Address("Mahadev Nagar","Surat","Gujarat","394327")));
        listOfEmployee.add(new Employee(4,"Amit","Processor",new Address("Adarsh Nagar","Bangalore","Karnataka","142536")));
        listOfEmployee.add(new Employee(5,"Ravi","Telecom",new Address("Ambika Nagar","Mumbai","Maharashtra","758510")));


        MyJacksonAndGsonSerialization serializationJson=new MyJacksonAndGsonSerialization();

        serializationJson.gsonToJsonWithSerialization(listOfEmployee.get(0));

        serializationJson.gsonToJsonWithSerialization(listOfEmployee);

        serializationJson.jacksonToJsonWithSerialization(listOfEmployee.get(2));

        serializationJson.jacksonToJsonWithSerialization(listOfEmployee);

    }
}
