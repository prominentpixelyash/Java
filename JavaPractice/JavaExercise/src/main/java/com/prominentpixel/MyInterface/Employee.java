package com.prominentpixel.MyInterface;

public class Employee extends Member{

    String specialization;

    @Override
    public String toString() {
        return "Employee{" +
                "specialization='" + specialization + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
