package com.prominentpixel;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyHttpResponse implements ResponseHandler<String> {


    @Override
    public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {

        int code=httpResponse.getStatusLine().getStatusCode();

        if(code>=200 && code<300){


            if (httpResponse.getEntity()==null){
                return "";
            }
            else{
                return EntityUtils.toString(httpResponse.getEntity());
            }

        }
        else {
            return code+"";
        }
    }

    public void myResponseHandler() throws IOException {

        ResponseHandler<String> responseHandler =new MyHttpResponse();

        CloseableHttpClient client=HttpClients.createDefault();

        HttpGet httpGet=new HttpGet("http://www.tutorialspoint.com/");

        String response=client.execute(httpGet,responseHandler);

        System.out.println(response);
    }

    public void myHttpGet() throws IOException {

        CloseableHttpClient client=HttpClients.createDefault();

        HttpGet httpGet=new HttpGet("http://www.tutorialspoint.com/");

        HttpResponse response=client.execute(httpGet);

        System.out.println("Method type->"+httpGet.getMethod());

        System.out.println("Response->"+response);

        System.out.println("Status code->"+response.getStatusLine().getStatusCode());

        System.out.println("Response content->"+response.getEntity().getContent());

        System.out.println("Response status line->"+response.getStatusLine());

        Scanner sc=new Scanner(response.getEntity().getContent());

        while (sc.hasNext()){
            System.out.println(sc.nextLine());
        }

    }

    public void myHttpPost(){

        List<EmailPasswordPair> listOfEmailPassword=new ArrayList<>();
        listOfEmailPassword.add(new EmailPasswordPair("nitin123@gmail.com","nitin123"));
        listOfEmailPassword.add(new EmailPasswordPair("yati123@gmail.com","yati123"));
        listOfEmailPassword.add(new EmailPasswordPair("yash123@gmail.com","yash123"));
        listOfEmailPassword.add(new EmailPasswordPair("amit123@gmail.com","amit123"));
        listOfEmailPassword.add(new EmailPasswordPair("ravi123@gmail.com","ravi123"));


    }

    public static void main(String[] args) throws Exception{

        MyHttpResponse myHttpResponse=new MyHttpResponse();

        myHttpResponse.myHttpGet();

        myHttpResponse.myResponseHandler();


    }


}
