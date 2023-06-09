package org.prominentpixel;

import java.util.List;

public class Employee {

    int id;
    String name;
    double salary;
    List<String> address;

    public Employee() {
    }

    public Employee(int id, String name, double salary, List<String> address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}
