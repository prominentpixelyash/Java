package com.propixel;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberValidator {

    public static void main(String[] args) {

        Pattern p=Pattern.compile("(0|91)?[7-9][0-9]{9}");

        Scanner scanner=new Scanner(System.in);

        while (true){
            System.out.println("Enter mobile number for validate or 'N' for exit the app");

            String mobileNumber=scanner.next();

            if (mobileNumber.equals("N")){
                break;
            }
            else {
                Matcher m=p.matcher(mobileNumber);

                if(m.find() && m.group().equals(mobileNumber)){
                    System.out.println("Valid mobile number");
                }
                else {
                    System.out.println("Invalid mobile number");
                }
            }

        }

        System.out.println("Thanks for using mobile number validator app");

    }

}
