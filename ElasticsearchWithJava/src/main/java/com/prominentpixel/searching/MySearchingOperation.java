package com.prominentpixel.searching;

import org.apache.http.HttpHost;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MySearchingOperation {

    public RestHighLevelClient getClient(){
        URI uri;
        try {
            uri=new URI("http://127.0.0.1:9200/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return new RestHighLevelClient(RestClient.builder(new HttpHost(uri.getHost(),uri.getPort(),uri.getScheme())));

    }

    public void myMatchAllQuery(){

        try (RestHighLevelClient client=getClient()){

            SearchResponse response=client.search(new SearchRequest().indices("products").source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()).size(20)), RequestOptions.DEFAULT);

            SearchHit[] hits= response.getHits().getHits();

            for (SearchHit hit:hits){
                System.out.println(hit.getSourceAsString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void myMatchQuery(){

        try(RestHighLevelClient client=getClient()){

            SearchResponse response=client.search(new SearchRequest().indices("products").source(new SearchSourceBuilder().query(QueryBuilders.matchQuery("madeInCountry","Africa"))),RequestOptions.DEFAULT);

            SearchHit[] hits=response.getHits().getHits();

            for (SearchHit hit:hits){
                System.out.println(hit.getSourceAsString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void myMatchPhrase(){


        try (RestHighLevelClient client=getClient()) {

            SearchResponse response=client.search(new SearchRequest().indices("products").source(new SearchSourceBuilder().query(QueryBuilders.matchPhraseQuery("productName","Mobile phones"))),RequestOptions.DEFAULT);
            SearchHit[] hits=response.getHits().getHits();
            for (SearchHit hit:hits){
                System.out.println(hit.getSourceAsString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        MySearchingOperation searchingOperation=new MySearchingOperation();
        System.out.println("***** Match All Query Output *****");
        searchingOperation.myMatchAllQuery();
        System.out.println("***** Match Query Output *****");
        searchingOperation.myMatchQuery();
        System.out.println("***** Match Query Phrase Output *****");
        searchingOperation.myMatchPhrase();


    }


}
