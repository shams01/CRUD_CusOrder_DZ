package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.net.URI;

@Service
public class WebService {
    private final RestTemplate restTemplate;

    private final URI uri = URI.create("https://webhook.site/1aa107c7-7cd8-4f69-a3e1-632f240225c3");

    @Autowired
    public WebService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public void send(Object request){
        restTemplate.postForEntity(uri, request, String.class);
    }
}
