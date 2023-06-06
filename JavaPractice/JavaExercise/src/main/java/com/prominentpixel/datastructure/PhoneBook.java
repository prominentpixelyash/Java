package com.prominentpixel.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        HashMap<String,String> friendsBook=new HashMap<>();

        friendsBook.put("Amit","8584263574");
        friendsBook.put("Nitin","6358749562");
        friendsBook.put("Yati","1234567891");
        friendsBook.put("Ravi","8797646531");
        friendsBook.put("Vipul","7531598523");


        String personName=null;

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 10 digit mobile number to find in my friend book");
        String mobileNumber=scanner.next();

        for (Map.Entry<String,String> entry:friendsBook.entrySet()){
            if(entry.getValue().equals(mobileNumber)){
                personName=entry.getKey();
                break;
            }
        }

        if (personName!=null){
            System.out.println("Person found with name "+personName+" mobile number is "+mobileNumber);
        }
        else{
            System.out.println("No person found with mobile number "+mobileNumber);
        }

    }

}
