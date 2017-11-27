package com.example.SentenceService.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class NounServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    public String callNounService()
    {

        String response = restTemplate.exchange("http://NounService/",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, "").getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
