package com.prominentpixel.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prominentpixel.models.TvShows;
import com.prominentpixel.utils.MyConnectionClass;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<TvShows> listOfTvShows=new ArrayList<>();


    public void getDataOfTvShowsFromDatabase(){

        List<TvShows> listOfShows=new ArrayList<>();

        MyConnectionClass myConnectionClass=new MyConnectionClass();
        Connection conn=myConnectionClass.getConnection();

        Statement state=null;

        int count=0;

        try {
            state= conn.createStatement();
            ResultSet rs=state.executeQuery("SELECT * FROM tvshows");

            while (rs.next()){
                count++;
                int sNo=rs.getInt("sNo");
                String nameOfTheShow=rs.getString("nameOfTheShow");
                double imdbRating=rs.getDouble("imdbRating");
                int ageOfViewers=rs.getInt("ageOfViewers");
                String language=rs.getString("language");
                String genre=rs.getString("genre");
                int noOfSeasonsAvailable=rs.getInt("noOfSeasonsAvailable");
                String yearOfRelease=rs.getString("yearOfRelease");
                String madeInCountry=rs.getString("madeInCountry");
                TvShows tvShow=new TvShows(sNo,nameOfTheShow,imdbRating,ageOfViewers,language,genre,noOfSeasonsAvailable,yearOfRelease,madeInCountry);
                listOfShows.add(tvShow);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listOfTvShows=listOfShows;
        System.out.println("******************************************");
        System.out.println("Total number of shows in database is "+count);
        System.out.println("******************************************");
    }


    public RestHighLevelClient getRestHighLevelClient(){

        URI uri;
        try {
            uri=new URI("http://127.0.0.1:9200/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new RestHighLevelClient(RestClient.builder(new HttpHost(uri.getHost(), uri.getPort(),uri.getScheme())));

    }


    public void bulkIndexing(){

        BulkRequest bulkRequest=new BulkRequest();

        IndexRequest indexRequest=null;

        for (TvShows show:listOfTvShows){
            try {
                indexRequest=new IndexRequest("tvshows").id(String.valueOf(show.getsNo())).source(new ObjectMapper().writeValueAsString(show), XContentType.JSON);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            bulkRequest.add(indexRequest);
        }

        BulkResponse response;

        try (RestHighLevelClient client=getRestHighLevelClient()){
            response=client.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int count=1;

        for (BulkItemResponse indexResponse:response){
            IndexResponse finalResponse=indexResponse.getResponse();
            System.out.println("Response "+ count +" --> "+ finalResponse);
            count++;
        }

    }


    public static void main(String[] args) {


        Main main=new Main();
        main.getDataOfTvShowsFromDatabase();
        System.out.println("All data from Postgres Database");
        listOfTvShows.stream().forEach(ts->{
            System.out.println("Sno of show is "+ts.getsNo());
            System.out.println("Name of show is "+ts.getNameOfTheShow());
            System.out.println("Imdb rating of show is "+ts.getImdbRating());
            System.out.println("Age of viewer tv show is "+ts.getAgeOfViewers());
            System.out.println("Language of show is "+ts.getLanguage());
            System.out.println("Genre of show is "+ts.getGenre());
            System.out.println("Number of session available of show is "+ts.getNoOfSeasonsAvailable());
            System.out.println("Year of release of show is "+ts.getYearOfRelease());
            System.out.println("Made of of show is "+ts.getMadeInCountry());
            System.out.println("**********************************************************************");

        });
        main.bulkIndexing();

    }
}
