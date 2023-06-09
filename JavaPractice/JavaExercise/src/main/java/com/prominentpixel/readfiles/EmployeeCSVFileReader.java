package com.prominentpixel.readfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeCSVFileReader {

    public static List<String> listOfName=new ArrayList<>();

    public static List<Integer> listOfSalary=new ArrayList<>();

    public void readCsvFile() throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("employee.csv"));

        String lineWiseData;

        while ((lineWiseData=br.readLine())!=null){

            String[] employeeData=lineWiseData.split(",");

            listOfName.add(employeeData[0]);

            listOfSalary.add(Integer.valueOf(employeeData[1]));

        }

        System.out.println(listOfName);

        System.out.println(listOfSalary);
    }

    public void wordsWithLenThree(){

        // word with less 3 length in csv file
        List<String> wordLenLessThree=listOfName.stream().filter(str->str.length()<3).collect(Collectors.toList());

        wordLenLessThree.stream().forEach(System.out::println);
    }


    public void numberOfWordsAndNumbers(){

        //Number of word and numbers in csv file
        System.out.println("Number of words in csv file "+listOfName.size());

        System.out.println("number of numbers in csv file "+listOfSalary.size());

    }


    public void numberOfUniqueWordsAndNumbers(){

        HashSet<String> uniqueWords=new HashSet<>();

        HashSet<Integer> uniqueNumbers=new HashSet<>();

        for(String name:listOfName){
            uniqueWords.add(name);
        }

        for (Integer number:listOfSalary){
            uniqueNumbers.add(number);
        }

        //Number of unique words and numbers in csv file
        System.out.println("Number of unique Words in csv file "+uniqueWords.size());

        System.out.println("Number of unique numbers in csv file "+uniqueNumbers.size());

    }


    public void lengthWiseUniqueCount(){

        HashMap<Integer,Integer> lengthWiseUniqueCount=new HashMap<>();

        for(String name:listOfName){
            lengthWiseUniqueCount.put(name.length(),lengthWiseUniqueCount.getOrDefault(name.length(),0)+1);
        }

        //Length wise number of words in the csv file
        for (Map.Entry<Integer,Integer> entry:lengthWiseUniqueCount.entrySet()){
            System.out.println("Length of word "+entry.getKey()+" number of count "+entry.getValue());
        }

    }

    public void wordWithLowerUpperCaseStart(){
        String lower="abcdefghijklmnopqrstuvwxyz";

        String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        HashMap<Character,Integer> startWithLower=new HashMap<>();
        HashMap<Character,Integer> startWithUpper=new HashMap<>();

        for (int i=0;i<lower.length();i++){
            startWithLower.put(lower.charAt(i),0);
            startWithUpper.put(upper.charAt(i),0);
        }

        for (String name:listOfName){
            char ch=name.charAt(0);
            if (startWithLower.containsKey(ch)){
                startWithLower.put(ch,startWithLower.get(ch)+1);
            }
            else if (startWithUpper.containsKey(ch)) {
                startWithUpper.put(ch,startWithUpper.get(ch)+1);
            }
        }

        //Start with lowercase words
        for (Map.Entry<Character,Integer> entry:startWithLower.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

        //Start with uppercase
        for (Map.Entry<Character,Integer> entry:startWithUpper.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }


    public void maximumCharacterWord(){

        //Maximum character word
        Collections.sort(listOfName,(s1,s2)->s1.length()>s2.length()?-1:s1.length()<s2.length()?+1:0);

        if (listOfName.size()>0){
            System.out.println("Maximum character words is "+listOfName.get(0));
        }

    }

    public void listWithMinToMaxAndMaxToMinChar(){
        //Min to max character in words list in csv file
        Collections.sort(listOfName,(s1,s2)->s1.length()>s2.length()?+1:s1.length()<s2.length()?-1:0);

        listOfName.stream().forEach(System.out::println);


        //Max to min character in words in csv file
        Collections.sort(listOfName,(s1,s2)->s1.length()>s2.length()?-1:s1.length()<s2.length()?+1:0);

        listOfName.stream().forEach(System.out::println);
    }

    public void getWordsFromUser(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter words here.......");
        String str=scanner.nextLine();
        String[] inputWords=str.split(" ");
        System.out.println(Arrays.toString(inputWords));
        System.out.println("Total number of words "+inputWords.length);

        HashSet<String> uniqueWords= (HashSet<String>) Arrays.stream(inputWords).collect(Collectors.toSet());

        System.out.println("Number of unique words "+uniqueWords.size());

        String[] numberOfCharInUserIp=str.split("");

        System.out.println(Arrays.toString(numberOfCharInUserIp));

        long countOfSpace=Arrays.stream(numberOfCharInUserIp).filter(c->c.equals(" ")).count();

        int numberOfChar=numberOfCharInUserIp.length-(int)countOfSpace;

        System.out.println("Number of character in user input "+numberOfChar);

    }

    public static void main(String[] args) throws Exception{

        EmployeeCSVFileReader employeeCSVFileReader=new EmployeeCSVFileReader();

        employeeCSVFileReader.readCsvFile();

        employeeCSVFileReader.wordsWithLenThree();

        employeeCSVFileReader.numberOfWordsAndNumbers();

        employeeCSVFileReader.numberOfUniqueWordsAndNumbers();

        employeeCSVFileReader.lengthWiseUniqueCount();

        employeeCSVFileReader.wordWithLowerUpperCaseStart();

        employeeCSVFileReader.maximumCharacterWord();

        employeeCSVFileReader.listWithMinToMaxAndMaxToMinChar();

        employeeCSVFileReader.getWordsFromUser();
    }
}
