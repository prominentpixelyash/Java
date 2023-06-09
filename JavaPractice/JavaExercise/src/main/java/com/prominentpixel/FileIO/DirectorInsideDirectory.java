package com.prominentpixel.FileIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DirectorInsideDirectory {

    public static void main(String[] args) throws Exception{

        List<Path> paths=Files.walk(Paths.get("C:\\Dir-1")).filter(Files::isRegularFile).collect(Collectors.toList());

        paths.stream().forEach(f->{

            try {
                BufferedReader br=new BufferedReader(new FileReader(f.toFile()));
                System.out.println("File name is "+f.toFile().getName());
                String line;

                while ((line= br.readLine())!=null){
                    System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });


    }
}
