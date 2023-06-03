package org.prominentpixel;

import com.sun.source.tree.UsesTree;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static List<Employee> listOfEmployee=new ArrayList<>();


    //Method to read CSV file
    public void readCSVFile(){
        try {
            BufferedReader br=new BufferedReader(new FileReader(".\\employee.csv"));
            String line;

            while((line= br.readLine())!=null){
                String[] stringFormatEmployee=line.split(",");
                Employee employee=new Employee();
                employee.setEmployeeId(Integer.valueOf(stringFormatEmployee[0]));
                employee.setUserName(stringFormatEmployee[1]);
                employee.setFirstName(stringFormatEmployee[2]);
                employee.setLastName(stringFormatEmployee[3]);
                employee.setAddress(stringFormatEmployee[4]);
                employee.setMobileNumber(stringFormatEmployee[5]);
                employee.setSalary(Double.valueOf(stringFormatEmployee[6]));
                employee.setBonus(Double.valueOf(stringFormatEmployee[7]));
                employee.setSalaryDate(LocalDate.parse(stringFormatEmployee[8]));
                listOfEmployee.add(employee);
            }

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Method for find the minimum salary from the given employee CSV File
    public void getMinimumEmployeeSalary(){

        Collections.sort(listOfEmployee,(e1,e2)->e1.getSalary()>e2.getSalary()?+1:e1.getSalary()<e2.getSalary()?-1:0);

        List<Employee> minimumEmployeeSalary=new ArrayList<>();

        double minSalary=listOfEmployee.get(0).getSalary();

        for(int i=0;i<listOfEmployee.size();i++){
            if(minSalary==listOfEmployee.get(i).getSalary()){
                minimumEmployeeSalary.add(listOfEmployee.get(i));
            }
            else{
                break;
            }
        }

        minimumEmployeeSalary.stream().forEach(e1->{
            System.out.println("Employee first name is "+e1.getFirstName());
            System.out.println("Employee last name is "+e1.getLastName());
            System.out.println("Employee salary date is "+ e1.getSalaryDate());
            System.out.println("Employee salary is "+e1.getSalary());
        });

    }


    //Sorting list of employee based on employee id
    public void sortEmployeeListBasedOnId(){
        Collections.sort(listOfEmployee,(e1,e2)->e1.getEmployeeId()>e2.getEmployeeId()?+1:e1.getEmployeeId()<e2.getEmployeeId()?-1:0);
    }


    //Method to find all employee id list
    public List<Integer> getAllEmployeeIdList(){

        Set<Integer> employeeIdHashSet=new HashSet<>();

        for (Employee emp:listOfEmployee){
            employeeIdHashSet.add(emp.getEmployeeId());
        }

        return new ArrayList<>(employeeIdHashSet);
    }


    //Method to find average salary of employee each year
    public void getAvgSalaryEachYear(){

        sortEmployeeListBasedOnId();

        int[] years={2021,2022,2023};

        List<Integer> employeeIdList=getAllEmployeeIdList();

        int e=0;

        int j=0;

        while(employeeIdList.get(e)<employeeIdList.size()){

            for (int i=0;i<years.length;i++){

                double totalSalary=0.0;

                double monthCount=0.0;

                String employeeName=listOfEmployee.get(j).getFirstName();

                while (j<listOfEmployee.size()){

                    if(employeeIdList.get(e)==listOfEmployee.get(j).getEmployeeId() && years[i]==listOfEmployee.get(j).getSalaryDate().getYear()) {
                        totalSalary += listOfEmployee.get(j).getSalary();
                        monthCount++;
                    }
                    else{
                        break;
                    }
                    j++;
                }

                System.out.println(employeeName+" "+"Year->"+years[i]+" average salary->"+String.format("%.2f",totalSalary/monthCount));

            }

            e++;

        }

    }


    //Method to find minimum and maximum salary of employee of every year
    public void getMinimumAndMaximumSalaryOfEmployee(){

        sortEmployeeListBasedOnId();

        List<Integer> employeeIdList=getAllEmployeeIdList();

        int j=0;

        for (int i=0;i<employeeIdList.size();i++){

            double minimumSalary=Double.MAX_VALUE;
            double maximumSalary=Double.MIN_VALUE;

            String employeeName=listOfEmployee.get(j).getFirstName();

            LocalDate minimumSalaryDate=null;

            LocalDate maximumSalaryDate=null;

            while(j<listOfEmployee.size()){
                if(employeeIdList.get(i)==listOfEmployee.get(j).getEmployeeId() && minimumSalary>listOfEmployee.get(j).getSalary()){
                    minimumSalary=listOfEmployee.get(j).getSalary();
                    minimumSalaryDate=listOfEmployee.get(j).getSalaryDate();
                }
                if(employeeIdList.get(i)==listOfEmployee.get(j).getEmployeeId() && maximumSalary<listOfEmployee.get(j).getSalary()){
                    maximumSalary=listOfEmployee.get(j).getSalary();
                    maximumSalaryDate=listOfEmployee.get(j).getSalaryDate();
                }
                else{
                    break;
                }
                j++;
            }

            System.out.println("Employee->"+employeeName+" Date->"+minimumSalaryDate+" Minimum Salary->"+minimumSalary);
            System.out.println("Employee->"+employeeName+" Date->"+maximumSalaryDate+" Maximum Salary->"+maximumSalary);

        }



    }


    public static void main(String[] args){

        Main main=new Main();

        main.readCSVFile();

        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter your choice :");
        System.out.println("1.To get the minimum salary person in company");
        System.out.println("2.To get the average salary of each year");
        System.out.println("3.To get minimum salary and maximum salary of each employee");

        int choice=scanner.nextInt();

        if(choice==1){
            main.getMinimumEmployeeSalary();
        }
        else if(choice==2){
            main.getAvgSalaryEachYear();
        }
        else if (choice==3) {
            main.getMinimumAndMaximumSalaryOfEmployee();
        }
        else{
            System.out.println("Invalid choice");
        }

    }
}