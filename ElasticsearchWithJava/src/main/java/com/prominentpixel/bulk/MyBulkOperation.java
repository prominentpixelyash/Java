package com.prominentpixel.bulk;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MyBulkOperation {

    public List<ProductData> getListOfProduct(){

        List<ProductData> products=new ArrayList<>();

        products.add(new ProductData(1,"T-shirts",1000,"Surat","Gujarat","India",2000,"Textile"));
        products.add(new ProductData(2,"Mobile Phones",11000,"City China-1","State China-1","China",20000,"Electronics"));
        products.add(new ProductData(3,"Gun",100000,"City America-1","State America-1","America",300,"Weapon"));
        products.add(new ProductData(4,"Diamond",250000,"City Africa-1","State Africa-1","Africa",450000,"Diamond"));
        products.add(new ProductData(5,"Petrol",5000,"City Russia-1","State Russia-1","Russia",800000,"Oil and Gas"));

        products.add(new ProductData(6,"Spices",4500,"Udaipur","Rajasthan","India",960000,"Food"));
        products.add(new ProductData(7,"Teddy",250,"City China-2","State China-2","China",22500,"Toys"));
        products.add(new ProductData(8,"Iphone",75000,"City America-2","State America-2","America",1560,"Electronics"));
        products.add(new ProductData(9,"Bearing",25111,"City Japan-1","State Japan-1","Japan",142536,"Mach-Industries"));
        products.add(new ProductData(10,"Cars",7120,"City Korea-1","State Korea-1","Korea",500,"Vehicle Industries"));


        products.add(new ProductData(11,"Gens",7500,"Surat","Gujarat","India",142536,"Textile"));
        products.add(new ProductData(12,"laptop",45000,"City China-1","State China-1","China",1596,"Electronics"));
        products.add(new ProductData(13,"Tanks",5555555,"City America-1","State America-1","America",55,"Weapon"));
        products.add(new ProductData(14,"Tea",2500,"City Africa-1","State Africa-1","Africa",450000,"Food"));
        products.add(new ProductData(15,"Natural Gas",750,"City Russia-1","State Russia-1","Russia",80000000,"Oil and Gas"));

        return  products;
    }


    public RestHighLevelClient getClient(){
        URI uri;
        try {
            uri=new URI("http://127.0.0.1:9200/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return new RestHighLevelClient(RestClient.builder(new HttpHost(uri.getHost(),uri.getPort(),uri.getScheme())));

    }

    public void myBulkIndexing(){

        BulkRequest bulkRequest=new BulkRequest();

        IndexRequest indexRequest;

        List<ProductData> listOfProducts=getListOfProduct();

        for (ProductData product:listOfProducts){

            try {
                indexRequest=new IndexRequest("products").id(String.valueOf(product.getProductId())).source(new ObjectMapper().writeValueAsString(product), XContentType.JSON);

                bulkRequest.add(indexRequest);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (RestHighLevelClient client=getClient()) {
             BulkResponse responses=client.bulk(bulkRequest, RequestOptions.DEFAULT);

             for (BulkItemResponse response:responses){
                 IndexResponse indexResponse=response.getResponse();
                 System.out.println(indexResponse);
             }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void bulkMultiGet(){

        MultiGetRequest multiGetRequest=new MultiGetRequest().add("products",String.valueOf(1)).add("products",String.valueOf(2));

        try (RestHighLevelClient client=getClient()){

            MultiGetResponse multiGetItemResponses=client.mget(multiGetRequest,RequestOptions.DEFAULT);

            for (MultiGetItemResponse response:multiGetItemResponses){
                GetResponse response1=response.getResponse();
                System.out.println(response1);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void getMultiSearch(){

        MultiSearchRequest msr=new MultiSearchRequest();

        SearchRequest sr1=new SearchRequest().indices("products").source(new SearchSourceBuilder().query(QueryBuilders.matchQuery("productCategory","Textile")));

        msr.add(sr1);

        SearchRequest sr2=new SearchRequest().indices("products").source(new SearchSourceBuilder().query(QueryBuilders.matchQuery("madeInCountry","India")));

        msr.add(sr2);

        try (RestHighLevelClient client=getClient()){

            MultiSearchResponse response=client.msearch(msr,RequestOptions.DEFAULT);

            for (MultiSearchResponse.Item item:response.getResponses()){
                System.out.println(item.getResponse());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        MyBulkOperation bulkOperation=new MyBulkOperation();
        bulkOperation.myBulkIndexing();
        bulkOperation.bulkMultiGet();
        bulkOperation.getMultiSearch();

    }


}
