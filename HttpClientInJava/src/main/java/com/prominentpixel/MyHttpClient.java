package com.prominentpixel;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    public static void main(String[] args) throws Exception {

        HttpClient client=HttpClient.newHttpClient();

        HttpRequest request= HttpRequest.newBuilder(new URI("https://en.wikipedia.org/wiki/Java_(programming_language)")).GET().build();

        HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: "+response.statusCode());

        System.out.println(response.body());

    }

}
