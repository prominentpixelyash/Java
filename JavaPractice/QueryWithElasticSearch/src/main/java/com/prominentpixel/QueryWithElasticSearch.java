package com.prominentpixel;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class QueryWithElasticSearch {

    public static Map<Integer, String> queryWithUserId = new HashMap<>();
    public static Map<Integer, String> queryWithUserId2 = new HashMap<>();

    public RestHighLevelClient getClient() {
        URI uri;
        try {
            uri = new URI("http://127.0.0.1:9200/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new RestHighLevelClient(RestClient.builder(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme())));
    }

    public void readCsvFilterQuery() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("query.csv"));
        String line;
        StringBuilder sb;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (queryWithUserId.containsKey(Integer.valueOf(data[0]))) {
                String query = queryWithUserId.get(Integer.valueOf(data[0]));
                sb = new StringBuilder();
                sb.append(query + "&" + data[1]);
                queryWithUserId.put(Integer.valueOf(data[0]), sb.toString());
            } else {
                queryWithUserId.put(Integer.valueOf(data[0]), data[1]);
            }
        }

    }


    public void myNestedShould(List<String> textQuery,List<String>  filter1,List<String>  filter2) {

        try (RestHighLevelClient client = getClient()) {


            BoolQueryBuilder main =QueryBuilders.boolQuery();

            for (int i=0;i<textQuery.size();i++){
                BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
                MatchQueryBuilder mqb1=QueryBuilders.matchQuery("lang",textQuery.get(i));
                MatchPhraseQueryBuilder mqb2=QueryBuilders.matchPhraseQuery("topic",filter1.get(i));
                MatchPhraseQueryBuilder mqb3=QueryBuilders.matchPhraseQuery("Statement",filter2.get(i));
                boolQueryBuilder.must(mqb1);
                boolQueryBuilder.must(mqb2);
                boolQueryBuilder.must(mqb3);

                main.should(boolQueryBuilder);
            }

            SearchResponse response = client.search(new SearchRequest().source(new SearchSourceBuilder().query(main)), RequestOptions.DEFAULT);
            printSearchResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void myNestedMust(List<String> textQuery,List<String>  filter1,List<String>  filter2) {

        try (RestHighLevelClient client = getClient()) {


            BoolQueryBuilder main =QueryBuilders.boolQuery();

            for (int i=0;i<textQuery.size();i++){
                BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
                MatchQueryBuilder mqb1=QueryBuilders.matchQuery("lang",textQuery.get(i));
                MatchPhraseQueryBuilder mqb2=QueryBuilders.matchPhraseQuery("topic",filter1.get(i));
                MatchPhraseQueryBuilder mqb3=QueryBuilders.matchPhraseQuery("Statement",filter2.get(i));
                boolQueryBuilder.should(mqb1);
                boolQueryBuilder.should(mqb2);
                boolQueryBuilder.should(mqb3);

                main.must(boolQueryBuilder);
            }

            SearchResponse response = client.search(new SearchRequest().source(new SearchSourceBuilder().query(main)), RequestOptions.DEFAULT);
            printSearchResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void printSearchResponse(SearchResponse response) {

        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

    }

    public List<String> getTextFromArray(String[] filterArray) {
        List<String> listOfText = new ArrayList<>();
        StringBuilder sb;
        for (int i=0;i<filterArray.length;i++){
            if(i>0){
                String str=filterArray[i];
                sb=new StringBuilder();
                for (int j=0;j<str.length();j++){
                    char c=str.charAt(j);
                    if(c=='&'){
                        break;
                    }
                    else{
                        sb.append(c);
                    }
                }
                listOfText.add(sb.toString());
            }
        }
        return listOfText;
    }


    public static void main(String[] args) throws IOException {

        QueryWithElasticSearch qwe = new QueryWithElasticSearch();
        qwe.readCsvFilterQuery();
        for (Map.Entry<Integer, String> entry : queryWithUserId.entrySet()) {

            String[] searchQuery = entry.getValue().split("q=");
            String[] searchFilter1 = entry.getValue().split("1=");
            String[] searchFilter2 = entry.getValue().split("2=");

            List<String> listOfQuery = qwe.getTextFromArray(searchQuery);
            List<String> listOfFilter1 = qwe.getTextFromArray(searchFilter1);
            List<String> listOfFilter2 = qwe.getTextFromArray(searchFilter2);

            qwe.myNestedShould(listOfQuery,listOfFilter1,listOfFilter2);
            qwe.myNestedMust(listOfQuery,listOfFilter1,listOfFilter2);
        }


    }
}
