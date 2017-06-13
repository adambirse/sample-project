package com.birse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 12/06/2017.
 */
public abstract class BaseService {

    protected RestTemplate restTemplate = new RestTemplate();

    @Value("${person.service.url}")
    private String serviceName;

    protected String getBaseUrl() {
        return "http://" + serviceName + ":8080";
    }
}
