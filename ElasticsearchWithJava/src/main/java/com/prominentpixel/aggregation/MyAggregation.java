package com.prominentpixel.aggregation;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

            System.out.println(response);

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

    public void mySumAggregation(){

        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().size(0).query(QueryBuilders.matchAllQuery()).
                    aggregation(AggregationBuilders.sum("totalNetWorth").field("productPrice"));

            SearchRequest searchRequest=new SearchRequest().indices("products").source(searchSourceBuilder);

            SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);

            System.out.println(response);

            Sum sum=response.getAggregations().get("totalNetWorth");

            System.out.println("Total worth of company is "+sum.getValue());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void myAvgAggregation(){


        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).
                    aggregation(AggregationBuilders.avg("avgPriceOfAllProduct").field("productPrice"));


            SearchRequest searchRequest=new SearchRequest().indices("products").source(searchSourceBuilder);


            SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);

            Avg avg=response.getAggregations().get("avgPriceOfAllProduct");

            System.out.println("Average price of product is "+avg.getValue());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void myMinAggregation(){

        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).
                    aggregation(AggregationBuilders.min("minPrice").field("productPrice"));


            SearchRequest searchRequest=new SearchRequest().indices("products").source(searchSourceBuilder);


            SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);

            Min min=response.getAggregations().get("minPrice");

            System.out.println("Minimum price in all product is "+min.getValue());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void myMaxAggregation(){

        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).
                    aggregation(AggregationBuilders.max("maxPrice").field("productPrice"));

            SearchRequest searchRequest=new SearchRequest().indices("products").source(searchSourceBuilder);

            SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);

            Max max=response.getAggregations().get("maxPrice");

            System.out.println("Maximum price in products is "+max.getValue());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void myCardinality(){

        try (RestHighLevelClient client=getClient()){

            SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).
                    aggregation(AggregationBuilders.cardinality("distinctCountOfCategory").field("productCategory"));

            SearchRequest searchRequest=new SearchRequest().indices("products").source(searchSourceBuilder);

            SearchResponse response=client.search(searchRequest,RequestOptions.DEFAULT);

            Cardinality cardinality=response.getAggregations().get("distinctCountOfCategory");

            System.out.println("Distinct count of category is "+cardinality.getValue());

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
        System.out.println("***** Sum aggregation output *****");
        aggregation.mySumAggregation();
        System.out.println("***** Avg aggregation output *****");
        aggregation.myAvgAggregation();
        System.out.println("***** Min aggregation output *****");
        aggregation.myMinAggregation();
        System.out.println("***** Max aggregation output *****");
        aggregation.myMaxAggregation();
        System.out.println("***** Cardinality aggregation output *****");
        aggregation.myCardinality();
        System.out.println("***** Highlight output *****");
        aggregation.myHighlighter();
    }


}
