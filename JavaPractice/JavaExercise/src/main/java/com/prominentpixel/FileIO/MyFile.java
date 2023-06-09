package com.prominentpixel.FileIO;

import java.io.*;
import java.util.Scanner;

public class MyFile {

    public void differentOperationOnFile() throws IOException {

        File file=new File("words.txt");

        System.out.println("exist method->"+file.exists());

        System.out.println("createFile->"+file.createNewFile());

        System.out.println("canExecute method->"+file.canExecute());

        System.out.println("getAbsoluteFile->"+file.getAbsoluteFile());

        System.out.println("getAbsolutePath->"+file.getAbsolutePath());

        System.out.println("getCanonicalFile->"+file.getCanonicalFile());

        System.out.println("getCanonicalPath->"+file.getCanonicalPath());

        System.out.println("getFreeSpace->"+file.getFreeSpace());

        System.out.println("getParent->"+file.getParent());

        System.out.println("getPath->"+file.getPath());

        System.out.println("getTotalSpace->"+file.getTotalSpace());

        System.out.println("isHidden->"+file.isHidden());

        System.out.println("renameTo->"+file.renameTo(new File("data.txt")));

        System.out.println("File name->"+file.getName());

        System.out.println("canRead method->"+file.canRead());

        System.out.println("exist method->"+file.exists());

        file.delete();

        System.out.println("exist method->"+file.exists());
    }

    public void fileOperation() throws IOException {
        File file=new File("file.txt");

        System.out.println("File Exist->"+file.exists());

        System.out.println("createNewFile->"+file.createNewFile());

        System.out.println("file Exist->"+file.exists());

        FileWriter fw=new FileWriter(file);

        fw.write("Hello ProminentPixel");

        fw.close();

        Scanner scanner=new Scanner(file);

        while (scanner.hasNextLine()){
            scanner.hasNext();
            String data=scanner.nextLine();
            System.out.println(data);
        }
    }


    public void utfOperation() throws IOException {

        FileOutputStream fos=new FileOutputStream(new File("utfdata.txt"));

        DataOutputStream dos=new DataOutputStream(fos);

        dos.writeUTF("Зарегистрируйтесь сейчас на Десятую Международную Конференцию по");

        dos.flush();

        dos.close();

        BufferedReader br=new BufferedReader(new FileReader("utfdata.txt"));

        System.out.println(br.readLine());

    }

    public static void main(String[] args) throws IOException {

        MyFile myfile=new MyFile();

        myfile.differentOperationOnFile();

        System.out.println("*************************");

        myfile.fileOperation();

        System.out.println("**************************");

        myfile.utfOperation();

        System.out.println("**************************");


    }

}
