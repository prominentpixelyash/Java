package com.prominentpixel.serialization;

import java.io.*;

public class MySerializationWithInheritance {

    public static void main(String[] args) {

        Juniors jr=new Juniors(5,"jj");

        try {
            FileOutputStream fos=new FileOutputStream(".\\juniorobject.ser");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(jr);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis=new FileInputStream(".\\juniorobject.ser");
            ObjectInputStream ois=new ObjectInputStream(fis);
            System.out.println((Juniors)ois.readObject());
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
