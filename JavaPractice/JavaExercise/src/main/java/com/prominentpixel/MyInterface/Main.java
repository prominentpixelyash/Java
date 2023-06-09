package com.prominentpixel.MyInterface;

public class Main {

    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.name="Yash";
        employee.age=29;
        employee.phoneNumber="9033757101";
        employee.address="Kadodara";
        employee.salary=50000;
        employee.specialization="Java";

        System.out.println("Employee->"+employee);


        Manager manager=new Manager();
        manager.name="Yash";
        manager.age=29;
        manager.phoneNumber="9033757101";
        manager.address="Kadodara";
        manager.salary=50000;
        manager.department="IT";

        System.out.println("Manager->"+manager);

    }

}
