package com.prominentpixel;

import org.apache.solr.client.solrj.beans.Field;

public class TvShow {

    @Field("sNo")
    public Integer sNo;
    @Field("NameOfTheShow")
    public String NameOfTheShow;
    @Field("YearOfRelease")
    public Integer YearOfRelease;
    @Field("NoOfSeasonsAvailable")
    public Integer NoOfSeasonsAvailable;
    @Field("Language")
    public String Language;
    @Field("Genre")
    public String Genre;
    @Field("IMDbRating")
    public double IMDbRating;
    @Field("AgeOfViewers")
    public String AgeOfViewers;

    public TvShow() {

    }

    public TvShow(Integer sNo, String nameOfTheShow, Integer yearOfRelease, Integer noOfSeasonsAvailable, String language, String genre, double IMDbRating, String ageOfViewers) {
        this.sNo = sNo;
        NameOfTheShow = nameOfTheShow;
        YearOfRelease = yearOfRelease;
        NoOfSeasonsAvailable = noOfSeasonsAvailable;
        Language = language;
        Genre = genre;
        this.IMDbRating = IMDbRating;
        AgeOfViewers = ageOfViewers;
    }


}
