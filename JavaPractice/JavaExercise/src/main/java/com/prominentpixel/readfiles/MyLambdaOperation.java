package com.prominentpixel.readfiles;

import com.prominentpixel.readfiles.ProminentTrainee;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLambdaOperation {

    public void countNumberOfTraineeUsingLambda(List<ProminentTrainee> listOfTrainees){

        long countNumberOfTrainee=listOfTrainees.stream().count();

        System.out.println("Number of trainee->"+countNumberOfTrainee);

    }

    public void getTraineeFromSecondIndex(List<ProminentTrainee> listOfTrainees){

        listOfTrainees.add(1,new ProminentTrainee(5,"Abhishek","Pune",LocalDate.parse("1994-11-01"),LocalDate.parse("2017-03-21"),28));

        System.out.println("Trainee object is added to 2nd index");

        listOfTrainees.stream().forEach(System.out::println);
    }

    public void getTraineeAtIndexThird(List<ProminentTrainee> listOfTrainees){

        ProminentTrainee traineeAtThirdIndex=listOfTrainees.get(3);

        System.out.println("Trainee at 3rd index "+traineeAtThirdIndex);

    }


    public void findTraineeWithIdFive(List<ProminentTrainee> listOfTrainees){

        List<ProminentTrainee> listOfTraineeWithIdFive= listOfTrainees.stream().filter(t->t.TraineeId==5).collect(Collectors.toList());

        System.out.println("List of trainee with  traineeId 5");

        listOfTraineeWithIdFive.stream().forEach(System.out::println);

    }


    public void convertListToSetUsingLambda(List<ProminentTrainee> listOfTrainees){

        Set<ProminentTrainee> setOfTrainee=listOfTrainees.stream().collect(Collectors.toSet());

        long totalNumberOfTrainee=setOfTrainee.stream().count();

        System.out.println("Total number of trainee "+totalNumberOfTrainee);

    }


    public void sortListOfTrainees(List<ProminentTrainee> listOfTrainees){

        //sort based on traineeId
        Collections.sort(listOfTrainees,(t1,t2)->t1.TraineeId>t2.TraineeId?+1:t1.TraineeId<t2.TraineeId?-1:0);

        System.out.println("Sort based on traineeId");

        listOfTrainees.stream().forEach(System.out::println);

        //sort based on traineeName
        Collections.sort(listOfTrainees,(t1,t2)->t1.TraineeName.compareTo(t2.TraineeName));

        System.out.println("Sort based on traineeName");

        listOfTrainees.stream().forEach(System.out::println);

        //sort based on traineeAge
        Collections.sort(listOfTrainees,(t1,t2)->t1.TraineeAge>t2.TraineeAge?+1:t1.TraineeAge<t2.TraineeAge?-1:0);

        System.out.println("Sort based on traineeAge");

        listOfTrainees.stream().forEach(System.out::println);


        //sort based on traineeJoiningDate
        Collections.sort(listOfTrainees,(t1,t2)->t1.TraineeJoiningDate.compareTo(t2.TraineeJoiningDate));

        System.out.println("Sort based on traineeJoiningDate");

        listOfTrainees.stream().forEach(System.out::println);

    }

    public void convertListToMapUsingLambda(List<ProminentTrainee> listOfTrainees){

        Map<Integer,String> mapOfTraineeWithNameAndId=listOfTrainees.stream().collect(Collectors.toMap(t->t.TraineeId,ProminentTrainee::toString));

        System.out.println("List to map key as traineeId and Value as trainee");

        for (Map.Entry<Integer,String> entry:mapOfTraineeWithNameAndId.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

    }

    public void writeAllRecordInPlainTextFile(List<ProminentTrainee> listOfTrainees) throws IOException {

        System.out.println("List to pain text file");

        FileWriter fw=new FileWriter("traineeList.txt");

        for (ProminentTrainee trainee:listOfTrainees){
            fw.write(trainee+System.lineSeparator());
        }

        fw.flush();

        fw.close();

    }

    public void readTxtAndConvertInList() throws IOException {

        System.out.println("Read pain text of list of trainee");

        BufferedReader br=new BufferedReader(new FileReader("traineeList.txt"));

        String trainee;

        while ((trainee=br.readLine())!=null){
            System.out.println(trainee);
        }

    }

    public static void main(String[] args) throws IOException {

        List<ProminentTrainee> listOfTrainees=new ArrayList<>();

        listOfTrainees.add(new ProminentTrainee(1,"Amit","Bangalore", LocalDate.parse("1995-11-30"),LocalDate.parse("2023-01-01"),27));
        listOfTrainees.add(new ProminentTrainee(2,"Yash","Surat",LocalDate.parse("1993-08-26"),LocalDate.parse("2023-06-01"),29));
        listOfTrainees.add(new ProminentTrainee(3,"Ravi","Mumbai",LocalDate.parse("1993-01-01"),LocalDate.parse("2023-02-05"),30));
        listOfTrainees.add(new ProminentTrainee(4,"Deepak","Delhi",LocalDate.parse("1994-11-30"),LocalDate.parse("2023-03-21"),28));

        listOfTrainees.stream().forEach(System.out::println);

        MyLambdaOperation mlo=new MyLambdaOperation();

        mlo.countNumberOfTraineeUsingLambda(listOfTrainees);
        mlo.getTraineeFromSecondIndex(listOfTrainees);
        mlo.getTraineeAtIndexThird(listOfTrainees);
        mlo.findTraineeWithIdFive(listOfTrainees);
        mlo.convertListToSetUsingLambda(listOfTrainees);
        mlo.sortListOfTrainees(listOfTrainees);
        mlo.convertListToMapUsingLambda(listOfTrainees);
        mlo.writeAllRecordInPlainTextFile(listOfTrainees);
        mlo.readTxtAndConvertInList();


    }
}
