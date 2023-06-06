package com.prominentpixel.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalaryExceptionWithTryCatch {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter salary : ");

        try {
            double salary=scanner.nextDouble();
            if(salary>87000.0){
                try {
                    throw new SalaryException("Salary is more than 87000");
                } catch (SalaryException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Salary is under the range of 87000");
            }
        }catch (InputMismatchException ipe){
            System.out.println("Please enter a valid input");
        }
        finally {
            scanner.close();
        }
    }
}
