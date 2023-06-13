package com.prominentpixel.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true)


@JsonSubTypes({
        @JsonSubTypes.Type(value = HR.class, name = "HR"),
        @JsonSubTypes.Type(value = Manager.class, name = "MANAGER")
})
public class Employee2 {

    private int id;
    private String name;
    private String department;
    private Address address;
    private EmpType type;

    public Employee2() {
    }

    public Employee2(int id, String name, String department, Address address, EmpType type) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmpType getType() {
        return type;
    }

    public void setType(EmpType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return id == employee2.id && Objects.equals(name, employee2.name) && Objects.equals(department, employee2.department) && Objects.equals(address, employee2.address) && Objects.equals(type, employee2.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, address, type);
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", address=" + address +
                ", type='" + type + '\'' +
                '}';
    }
}
