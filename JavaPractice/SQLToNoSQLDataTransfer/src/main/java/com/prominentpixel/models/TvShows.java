package com.prominentpixel.models;

import java.util.Objects;

public class TvShows {

    private int sNo;
    private String nameOfTheShow;
    private double imdbRating;
    private int ageOfViewers;
    private String language;
    private String genre;
    private int noOfSeasonsAvailable;
    private String yearOfRelease;
    private String madeInCountry;

    public TvShows() {

    }

    public TvShows(int sNo, String nameOfTheShow, double imdbRating, int ageOfViewers, String language, String genre, int noOfSeasonsAvailable, String yearOfRelease, String madeInCountry) {
        this.sNo = sNo;
        this.nameOfTheShow = nameOfTheShow;
        this.imdbRating = imdbRating;
        this.ageOfViewers = ageOfViewers;
        this.language = language;
        this.genre = genre;
        this.noOfSeasonsAvailable = noOfSeasonsAvailable;
        this.yearOfRelease = yearOfRelease;
        this.madeInCountry = madeInCountry;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getNameOfTheShow() {
        return nameOfTheShow;
    }

    public void setNameOfTheShow(String nameOfTheShow) {
        this.nameOfTheShow = nameOfTheShow;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getAgeOfViewers() {
        return ageOfViewers;
    }

    public void setAgeOfViewers(int ageOfViewers) {
        this.ageOfViewers = ageOfViewers;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNoOfSeasonsAvailable() {
        return noOfSeasonsAvailable;
    }

    public void setNoOfSeasonsAvailable(int noOfSeasonsAvailable) {
        this.noOfSeasonsAvailable = noOfSeasonsAvailable;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getMadeInCountry() {
        return madeInCountry;
    }

    public void setMadeInCountry(String madeInCountry) {
        this.madeInCountry = madeInCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvShows tvShows = (TvShows) o;
        return sNo == tvShows.sNo && Double.compare(tvShows.imdbRating, imdbRating) == 0 && ageOfViewers == tvShows.ageOfViewers && noOfSeasonsAvailable == tvShows.noOfSeasonsAvailable && Objects.equals(nameOfTheShow, tvShows.nameOfTheShow) && Objects.equals(language, tvShows.language) && Objects.equals(genre, tvShows.genre) && Objects.equals(yearOfRelease, tvShows.yearOfRelease) && Objects.equals(madeInCountry, tvShows.madeInCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sNo, nameOfTheShow, imdbRating, ageOfViewers, language, genre, noOfSeasonsAvailable, yearOfRelease, madeInCountry);
    }

    @Override
    public String toString() {
        return "TvShows{" +
                "sNo=" + sNo +
                ", nameOfTheShow='" + nameOfTheShow + '\'' +
                ", imdbRating=" + imdbRating +
                ", ageOfViewers=" + ageOfViewers +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", noOfSeasonsAvailable=" + noOfSeasonsAvailable +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", madeInCountry='" + madeInCountry + '\'' +
                '}';
    }
}
