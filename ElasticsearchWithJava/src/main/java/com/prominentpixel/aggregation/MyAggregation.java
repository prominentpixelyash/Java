package com.prominentpixel.aggregation;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class MyAggregation {

    public RestHighLevelClient getClient(){

        try {
            URI uri=new URI("http://127.0.0.1:9200/");
            return new RestHighLevelClient(RestClient.builder(new HttpHost(uri.getHost(),uri.getPort(),uri.getScheme())));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    public void singleAggregation(){

        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().size(0).query(QueryBuilders.matchAllQuery()).
                    aggregation(AggregationBuilders.terms("countCountry").field("madeInCountry"));

            SearchRequest searchRequest=new SearchRequest().indices("products").source(sourceBuilder);

            SearchResponse response=client.search(searchRequest, RequestOptions.DEFAULT);

            Aggregations aggregations=response.getAggregations();

            Terms aggregation= aggregations.get("countCountry");

            List<? extends Terms.Bucket> countCountry= aggregation.getBuckets();

            for (Terms.Bucket buket:countCountry){
                System.out.println(buket.getKey()+" -> "+buket.getDocCount());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void subAggregation(){

        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).
                    aggregation(AggregationBuilders.terms("countCountry").field("madeInCountry").
                            subAggregation(AggregationBuilders.terms("countCity").field("madeCity")));

            SearchRequest searchRequest=new SearchRequest().indices("products").source(sourceBuilder);

            SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);

            Aggregations aggregation=response.getAggregations();

            Terms aggregations=aggregation.get("countCountry");

            List<? extends Terms.Bucket> buckets=aggregations.getBuckets();

            for (Terms.Bucket buket:buckets){

                System.out.println(buket.getKeyAsString()+" -> "+buket.getDocCount());

                Aggregations aggregations1= buket.getAggregations();

                Terms terms= aggregations1.get("countCity");

                List<? extends Terms.Bucket> childBuckets= terms.getBuckets();

                for (Terms.Bucket childBuket:childBuckets){
                    System.out.println(childBuket.getKeyAsString()+" -> "+childBuket.getDocCount());
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void myHighlighter(){

        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder sourceBuilder=new SearchSourceBuilder().query(QueryBuilders.matchQuery("productCategory","Textile")).
                    highlighter(SearchSourceBuilder.highlight().field("productCategory").preTags("<em>").postTags("</em>"));

            SearchRequest searchRequest=new SearchRequest().indices("products").source(sourceBuilder);

            SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);

            System.out.println();

            SearchHit[] hits=response.getHits().getHits();

            for (SearchHit hit:hits){
                System.out.println(hit.getHighlightFields());
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        MyAggregation aggregation=new MyAggregation();
        System.out.println("***** Single aggregation output *****");
        aggregation.singleAggregation();
        System.out.println("***** Sub aggregation output *****");
        aggregation.subAggregation();
        System.out.println("***** Highlight output *****");
        aggregation.myHighlighter();
    }


}
