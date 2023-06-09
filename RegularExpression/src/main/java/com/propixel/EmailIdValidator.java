package com.propixel;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailIdValidator {

    public static void main(String[] args) {

        Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@gmail[.]com");

        Scanner scanner=new Scanner(System.in);

        while (true){

            System.out.println("Enter email to validate or 'N' for exit the programme");

            String emailId=scanner.next();

            if(emailId.equals("N")){
                break;
            }
            else{

                Matcher m=p.matcher(emailId);

                if(m.find() && m.group().equals(emailId)){
                    System.out.println("Email id is correct");
                }
                else{
                    System.out.println("Email id is incorrect");
                }

            }

        }

        System.out.println("Thanks for using email validator");

    }

}
