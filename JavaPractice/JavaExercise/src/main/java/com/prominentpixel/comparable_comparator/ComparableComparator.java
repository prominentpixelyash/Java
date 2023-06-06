package com.prominentpixel.comparable_comparator;

import java.util.*;

public class ComparableComparator {

    public List<String> getUniqueListOfStudentName(List<Student> studentList){
        HashSet<String> uniqueNameOfStudents=new HashSet<>();

        for (Student student:studentList){
            uniqueNameOfStudents.add(student.getName());
        }

        return new ArrayList<>(uniqueNameOfStudents);
    }

    public List<String> getUniqueListOfCollageName(List<Student> studentList){
        HashSet<String> uniqueNameOfCollages=new HashSet<>();

        for (Student student:studentList){
            uniqueNameOfCollages.add(student.getCollage());
        }

        return new ArrayList<>(uniqueNameOfCollages);
    }

    public void uniqueNameOfStudents(List<Student> studentList){

        List<String> listOfUniqueStudentsName=getUniqueListOfStudentName(studentList);

        for (String studentName:listOfUniqueStudentsName){
            System.out.println(studentName);
        }

    }


    public void collageWiseCount(List<Student> studentList){

        List<String> listOfUniqueCollage=getUniqueListOfCollageName(studentList);

        for (int i=0;i<listOfUniqueCollage.size();i++){
            int noOFStudentsInCollage=0;

            for (Student student:studentList){
                if (listOfUniqueCollage.get(i).equals(student.getCollage())){
                    noOFStudentsInCollage++;
                }
            }

            System.out.println("Collage->"+listOfUniqueCollage.get(i)+" Count->"+noOFStudentsInCollage);

        }

    }


    public void getCollageWiseStudentList(List<Student> studentList){

        List<String> listOfUniqueCollage=getUniqueListOfCollageName(studentList);

        for (int i=0;i<listOfUniqueCollage.size();i++){

            List<Student> collageWiseStudents=new ArrayList<>();

            for (Student student:studentList){
                if (student.getCollage().equals(listOfUniqueCollage.get(i))){
                    collageWiseStudents.add(student);
                }
            }

            System.out.println("Collage->"+listOfUniqueCollage.get(i));

            System.out.println("#####################");

            for (Student student:collageWiseStudents){
                System.out.println("Student id is "+student.getId());
                System.out.println("Student collage is "+student.getCollage());
                System.out.println("Student name is "+student.getName());
                System.out.println("Student grade is "+student.getGrade());
                System.out.println("*************************");
            }

        }

    }

    public void getCollageWiseGradeAndCount(List<Student> studentList){

        List<String> listOfUniqueCollage=getUniqueListOfCollageName(studentList);

        for (int i=0;i<listOfUniqueCollage.size();i++){

            Set<String> uniqueGrade=new HashSet<>();

            int noOFStudentsInCollage=0;

            for (Student student:studentList){
                if (listOfUniqueCollage.get(i).equals(student.getCollage())){
                    uniqueGrade.add(student.getGrade());
                    noOFStudentsInCollage++;
                }
            }

            System.out.println("Collage->"+listOfUniqueCollage.get(i)+" Count->"+noOFStudentsInCollage);
            System.out.println("Grade in collage is");
            List<String> listOfGrade=new ArrayList<>(uniqueGrade);
            for (String grade:listOfGrade){
                System.out.println(grade);
            }
        }

    }

    public void sortByStudentName(List<Student> studentList){

        Collections.sort(studentList,(s1,s2)->s1.getCollage().compareTo(s2.getName()));

        studentList.stream().forEach(System.out::println);

    }

    public void sortByStudentNameAndCollage(List<Student> studentList){

        Collections.sort(studentList,(s1,s2)->{
            if (s1.getName().equals(s2.getName())){
                return s1.getCollage().compareTo(s2.getCollage());
            }
            else {
                return s1.getName().compareTo(s2.getName());
            }
        });

        studentList.stream().forEach(System.out::println);

    }

    public static void main(String[] args) {

        List<Student> listOfStudent=new ArrayList<>();

        listOfStudent.add(new Student(1,"GTU","Yash","First Class"));
        listOfStudent.add(new Student(2,"GTU","Ravi","Second Class"));
        listOfStudent.add(new Student(3,"NIT","Amit","Second Class"));
        listOfStudent.add(new Student(4,"MTU","Vivek","Third Class"));
        listOfStudent.add(new Student(5,"UUT","Jitendra","Third Class"));
        listOfStudent.add(new Student(6,"JNU","Deepak","Second Class"));
        listOfStudent.add(new Student(7,"MTU","Vivek","Third Class"));
        listOfStudent.add(new Student(8,"UUT","Jitendra","Third Class"));
        listOfStudent.add(new Student(9,"HU","Deepak","Second Class"));


        ComparableComparator compComp=new ComparableComparator();

        compComp.uniqueNameOfStudents(listOfStudent);
        System.out.println("*************************");
        compComp.collageWiseCount(listOfStudent);
        System.out.println("*************************");
        compComp.getCollageWiseStudentList(listOfStudent);
        System.out.println("*************************");
        compComp.sortByStudentName(listOfStudent);
        System.out.println("*************************");
        compComp.sortByStudentNameAndCollage(listOfStudent);
        System.out.println("*************************");
        compComp.getCollageWiseGradeAndCount(listOfStudent);

    }
}