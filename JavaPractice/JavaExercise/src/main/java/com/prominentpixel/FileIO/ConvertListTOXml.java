package com.prominentpixel.FileIO;

import javax.xml.stream.XMLStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConvertListTOXml {
    public static void main(String[] args) {

        List<ProminentTrainee> listOfTrainees=new ArrayList<>();

        listOfTrainees.add(new ProminentTrainee(1,"Amit","Bangalore",LocalDate.parse("1995-11-30"),LocalDate.parse("2023-01-01"),27));
        listOfTrainees.add(new ProminentTrainee(2,"Yash","Surat",LocalDate.parse("1993-08-26"),LocalDate.parse("2023-06-01"),29));
        listOfTrainees.add(new ProminentTrainee(3,"Ravi","Mumbai",LocalDate.parse("1993-01-01"),LocalDate.parse("2023-02-05"),30));
        listOfTrainees.add(new ProminentTrainee(4,"Deepak","Delhi",LocalDate.parse("1994-11-30"),LocalDate.parse("2023-03-21"),28));
        listOfTrainees.add(new ProminentTrainee(5,"Abhishek","Surat",LocalDate.parse("1996-12-24"),LocalDate.parse("2023-04-15"),26));



    }
}
