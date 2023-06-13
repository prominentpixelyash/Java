package com.prominentpixel;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadHyperlinkUsingHttpClient {

    public void readAndWriteHyperlinkInFileUsingHttpClient() throws IOException {

        CloseableHttpClient client=HttpClients.createDefault();

        HttpGet httpGet=new HttpGet("https://en.wikipedia.org/wiki/Hyperlink");

        CloseableHttpResponse response=client.execute(httpGet);

        System.out.println(response.getStatusLine().getStatusCode());

        System.out.println(response.getEntity().getContent());

        Scanner sc=new Scanner(response.getEntity().getContent());


        Pattern p=Pattern.compile("https://[[a-z_-][.]]+/[a-zA-Z0-9/]*");


        PrintWriter pw=new PrintWriter("HyperLinks.txt");

        int count=0;

        while (sc.hasNext()){

            String line=sc.nextLine().trim();

            String[] data=line.split("\"");

            for (String str:data){
                Matcher m=p.matcher(str);
                if (m.find() && m.group().equals(str)){
                    count++;
                    pw.println(str);
                }

            }
        }
        pw.flush();
        pw.close();
        sc.close();

        System.out.println("Number of match found "+count);

    }

    public static void main(String[] args) throws IOException {

        ReadHyperlinkUsingHttpClient readHyperlinkUsingHttpClient=new ReadHyperlinkUsingHttpClient();

        readHyperlinkUsingHttpClient.readAndWriteHyperlinkInFileUsingHttpClient();

    }

}
