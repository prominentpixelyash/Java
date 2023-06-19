package com.prominentpixel;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MyElasticSearchWithJava {


    public RestHighLevelClient getClient(){

        try {
            URI uri=new URI("http://127.0.0.1:9200/");
            return new RestHighLevelClient(RestClient.builder(new HttpHost(uri.getHost(),uri.getPort(),uri.getScheme())));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }


    public void singleIndexingOfDocument(){

        Product product=new Product(2,"Mi-Note 20",51000,"China",100,"Electronics");

        try (RestHighLevelClient client=getClient()){

            IndexRequest indexRequest=new IndexRequest("products").id("1").source(new ObjectMapper().writeValueAsString(product), XContentType.JSON);

            IndexResponse response=client.index(indexRequest, RequestOptions.DEFAULT);

            System.out.println(response);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void getDocument(){

        try (RestHighLevelClient client=getClient()){

            GetRequest getRequest=new GetRequest("products","1");


            GetResponse response=client.get(getRequest,RequestOptions.DEFAULT);

            System.out.println(response.getSourceAsString());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void updateDocument(){

        Product product=new Product(2,"Mi-Note 51",51000,"China",100,"Electronics");


        try (RestHighLevelClient client=getClient()){

            UpdateRequest updateRequest=new UpdateRequest("products","1").doc(new ObjectMapper().writeValueAsString(product),XContentType.JSON);
            UpdateResponse update= client.update(updateRequest,RequestOptions.DEFAULT);
            System.out.println(update);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void deleteDocument(){

        DeleteRequest deleteRequest=new DeleteRequest("products","1");

        try (RestHighLevelClient client=getClient()){
            DeleteResponse response= client.delete(deleteRequest,RequestOptions.DEFAULT);
            System.out.println(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) throws IOException, URISyntaxException {

       MyElasticSearchWithJava myElasticSearchWithJava=new MyElasticSearchWithJava();
       myElasticSearchWithJava.singleIndexingOfDocument();
       myElasticSearchWithJava.getDocument();
       myElasticSearchWithJava.updateDocument();
       myElasticSearchWithJava.getDocument();
       myElasticSearchWithJava.deleteDocument();
       myElasticSearchWithJava.getDocument();
    }

}
