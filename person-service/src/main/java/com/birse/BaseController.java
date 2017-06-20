package com.birse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 09/06/2017.
 */
public abstract class BaseController {

    @Autowired
    protected RestTemplate restTemplate;

    @Value("${person.data.service.url}")
    private String serviceName;

    protected String getBaseUrl() {
        return "http://" + serviceName + ":8080";
    }
}
