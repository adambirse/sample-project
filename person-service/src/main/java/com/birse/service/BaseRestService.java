package com.birse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;


public abstract class BaseRestService {

    @Autowired
    protected RestTemplate restTemplate;

    @Value("${person.data.service.url}")
    private String serviceName;

    protected String getBaseUrl() {
        return "http://" + serviceName + ":8080";
    }
}
