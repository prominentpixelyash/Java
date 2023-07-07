package com.prominentpixel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/solr")
public class MySolrService {

    @Autowired
    private RestTemplate template;

    @CircuitBreaker(name = "solrCircuitBreaker", fallbackMethod = "solrFallback")
    @GetMapping("/response/{sNo}")
    public String getResponseWithSolr(@PathVariable Integer sNo) {
        System.out.println("Inside response of sno.");
        String url ="http://localhost:8983/solr/tvshows/select?indent=true&q.op=OR&q=sNo:"+sNo;
        System.out.println();
        String response=template.getForObject(url, String.class);
        System.out.println(response);
        return response;
    }

    public String solrFallback(Integer sNo, Exception e){
        System.out.println("Outside of response of sno.");
        e.printStackTrace();
        return "Solr system is down";
    }

}
