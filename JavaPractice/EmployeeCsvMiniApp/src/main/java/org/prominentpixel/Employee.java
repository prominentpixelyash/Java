package org.prominentpixel;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Employee {

    private int employeeId;
    private String userName;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private double salary;
    private double bonus;
    private LocalDate salaryDate;

    public Employee() {
    }

    public Employee(int employeeId, String userName, String firstName, String lastName, String address, String mobileNumber, double salary, double bonus, LocalDate salaryDate) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.salary = salary;
        this.bonus = bonus;
        this.salaryDate = salaryDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public LocalDate getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(LocalDate salaryDate) {
        this.salaryDate = salaryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Double.compare(employee.salary, salary) == 0 && Double.compare(employee.bonus, bonus) == 0 && Objects.equals(userName, employee.userName) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(address, employee.address) && Objects.equals(mobileNumber, employee.mobileNumber) && Objects.equals(salaryDate, employee.salaryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, userName, firstName, lastName, address, mobileNumber, salary, bonus, salaryDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", salaryDate=" + salaryDate +
                '}';
    }
}
