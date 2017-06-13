package com.birse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 09/06/2017.
 */
public abstract class BaseController {

    protected RestTemplate restTemplate = new RestTemplate();

    @Value("${person.data.service.url}")
    private String serviceName;

    protected String getBaseUrl() {
        return "http://" + serviceName + ":8080";
    }
}
