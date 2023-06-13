package com.prominentpixel.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prominentpixel.models.Address;
import com.prominentpixel.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class MyJacksonAndGson {

    public void getJsonDataWithGson(Employee employee){

        Gson gson=new Gson();

        String json=gson.toJson(employee);

        System.out.println("***** Inside Json with gson *****");

        System.out.println(json);

        //get employee object from gson json
        getEmployeeFromJsonWithGson(json);

    }

    public void getEmployeeFromJsonWithGson(String json){

        Gson gson=new Gson();
        Employee emp=gson.fromJson(json,Employee.class);

        System.out.println("***** Json to Java Employee Object In Gson *****");

        printEmployeeObject(emp);

    }

    public void prettyPrintingWithGson(Employee employee){

        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(employee);

        System.out.println("***** Inside Pretty Printing of Gson *****");

        System.out.println(json);
    }

    public void getJsonDataWithJackson(Employee employee){

        ObjectMapper mapper=new ObjectMapper();

        try {
            String json=mapper.writeValueAsString(employee);

            System.out.println("***** Inside json with jackson *****");

            System.out.println(json);

            //get employee from jackson json
            getEmployeeFromJsonWithJackson(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public void getEmployeeFromJsonWithJackson(String jackson){

        ObjectMapper mapper=new ObjectMapper();

        try {
            Employee emp=mapper.readValue(jackson,Employee.class);

            System.out.println("***** Inside in json to Java Object form Jackson *****");

            printEmployeeObject(emp);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public void prettyPrintingWithJackson(Employee employee){

        ObjectMapper mapper=new ObjectMapper();

        try {
            String json= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

            System.out.println("***** Inside pretty printing of jackson *****");

            System.out.println(json);

        } catch (JsonProcessingException e) {
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


        MyJacksonAndGson myJacksonAndGson=new MyJacksonAndGson();

        // converting employee to json with gson
        listOfEmployee.stream().forEach(employee -> {
            myJacksonAndGson.getJsonDataWithGson(employee);
        });


        // pretty printing json from employee with gson
        listOfEmployee.stream().forEach(employee -> {
            myJacksonAndGson.prettyPrintingWithGson(employee);
        });


        // converting employee to json with jackson
        listOfEmployee.stream().forEach(employee -> {
            myJacksonAndGson.getJsonDataWithJackson(employee);
        });

        // pretty printing json from employee with jackson
        listOfEmployee.stream().forEach(employee -> {
            myJacksonAndGson.prettyPrintingWithJackson(employee);
        });


    }

}
