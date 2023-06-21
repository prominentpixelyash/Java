package com.prominentpixel.searching;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class MySearchingOperation {

    public RestHighLevelClient getClient() {
        URI uri;
        try {
            uri = new URI("http://127.0.0.1:9200/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return new RestHighLevelClient(RestClient.builder(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme())));

    }

    public void myMatchAllQuery() {

        try (RestHighLevelClient client = getClient()) {

            SearchResponse response = client.search(new SearchRequest().indices("products").source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()).size(20)), RequestOptions.DEFAULT);

            SearchHit[] hits = response.getHits().getHits();

            for (SearchHit hit : hits) {

                Map<String, Object> map = hit.getSourceAsMap();

                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " --> " + entry.getValue());
                }

                System.out.println("************************************");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void myMatchQuery() {

        try (RestHighLevelClient client = getClient()) {

            SearchResponse response = client.search(new SearchRequest().indices("products").source(new SearchSourceBuilder().query(QueryBuilders.matchQuery("madeInCountry", "Africa"))), RequestOptions.DEFAULT);

            SearchHit[] hits = response.getHits().getHits();

            for (SearchHit hit : hits) {
                System.out.println(hit.getSourceAsString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void myMatchPhrase() {


        try (RestHighLevelClient client = getClient()) {

            SearchResponse response = client.search(new SearchRequest().indices("products").source(new SearchSourceBuilder().query(QueryBuilders.matchPhraseQuery("productName", "Mobile phones"))), RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            printSearchHitArray(hits);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void myMultiMatchQuery() {

        try (RestHighLevelClient client = getClient()) {

            SearchResponse response = client.search(new SearchRequest().source(new SearchSourceBuilder().query(QueryBuilders.multiMatchQuery("America", "madeCity", "madeState", "madeInCountry"))), RequestOptions.DEFAULT);


            SearchHit[] hits = response.getHits().getHits();

            printSearchHitArray(hits);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void myRangeQuery() {

        try (RestHighLevelClient client = getClient()) {

            SearchResponse response = client.search(new SearchRequest().source(new SearchSourceBuilder().query(QueryBuilders.rangeQuery("numberOfProducts").gte(10000).lte(50000))), RequestOptions.DEFAULT);

            SearchHit[] hits = response.getHits().getHits();

            printSearchHitArray(hits);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void myFilterQuery() {

        try (RestHighLevelClient client = getClient()) {

            BoolQueryBuilder query = QueryBuilders.boolQuery().filter(QueryBuilders.rangeQuery("productPrice").lte(1100).gte(200));

            SearchResponse response = client.search(new SearchRequest().source(new SearchSourceBuilder().query(query)), RequestOptions.DEFAULT);

            SearchHit[] hits = response.getHits().getHits();

            printSearchHitArray(hits);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void myMustQuery() {

        try (RestHighLevelClient client = getClient()) {

            BoolQueryBuilder q = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("productName", "Phone").fuzziness(2));

            SearchResponse response = client.search(new SearchRequest().source(new SearchSourceBuilder().query(q)), RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            printSearchHitArray(hits);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void myShouldQuery() {
        try (RestHighLevelClient client = getClient()) {

            BoolQueryBuilder q = QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("madeCity", "Surat"));

            SearchResponse response = client.search(new SearchRequest().source(new SearchSourceBuilder().query(q)), RequestOptions.DEFAULT);

            SearchHit[] hits = response.getHits().getHits();

            printSearchHitArray(hits);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void myMustNotQuery(){

        try (RestHighLevelClient client=getClient()){

            BoolQueryBuilder q= QueryBuilders.boolQuery().mustNot(QueryBuilders.matchQuery("productPrice","1000"));

            SearchResponse response=client.search(new SearchRequest().source(new SearchSourceBuilder().query(q)),RequestOptions.DEFAULT);

            System.out.println(q);

            SearchHit[] hits=response.getHits().getHits();

            System.out.println(q);

//            printSearchHitArray(hits);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    public void myMustShouldAndMustNotQuery(){

        try (RestHighLevelClient client=getClient()){

            BoolQueryBuilder q=new BoolQueryBuilder();

            q.must(QueryBuilders.matchQuery("madeInCountry","India"));

            q.should(QueryBuilders.matchQuery("productCategory","Textile"));

            q.mustNot(QueryBuilders.matchQuery("productPrice","1000"));

            SearchResponse response=client.search(new SearchRequest().source(new SearchSourceBuilder().query(q)),RequestOptions.DEFAULT);

            SearchHit[] hits=response.getHits().getHits();

            printSearchHitArray(hits);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void printSearchHitArray(SearchHit[] hits) {

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

    }


    public static void main(String[] args) {

        MySearchingOperation searchingOperation = new MySearchingOperation();
        System.out.println("***** Match All Query Output *****");
        searchingOperation.myMatchAllQuery();
        System.out.println("***** Match Query Output *****");
        searchingOperation.myMatchQuery();
        System.out.println("***** Match Query Phrase Output *****");
        searchingOperation.myMatchPhrase();
        System.out.println("***** Multi Match Query Output *****");
        searchingOperation.myMultiMatchQuery();
        System.out.println("***** Range Query Output *****");
        searchingOperation.myRangeQuery();
        System.out.println("***** Filter Query Output *****");
        searchingOperation.myFilterQuery();
        System.out.println("***** Must Query Output *****");
        searchingOperation.myMustQuery();
        System.out.println("***** Should Query Output *****");
        searchingOperation.myShouldQuery();
        System.out.println("***** Must Not Query Output *****");
        searchingOperation.myMustNotQuery();
        System.out.println("***** Must, Should and Must Not Query Output *****");
        searchingOperation.myMustShouldAndMustNotQuery();

    }

}
