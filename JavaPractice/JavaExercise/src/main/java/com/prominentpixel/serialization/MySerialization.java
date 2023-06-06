package com.prominentpixel.serialization;


import java.io.*;

public class MySerialization {
    public static void main(String[] args) {

        Student student=new Student(1,"GTU","Yash","First Class");

        try {
            FileOutputStream fos=new FileOutputStream(".\\objectstore.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fis=new FileInputStream(".\\objectstore.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            try {
                System.out.println((Student)ois.readObject());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
