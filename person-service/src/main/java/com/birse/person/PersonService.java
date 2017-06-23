package com.birse.person;

import com.birse.service.BaseRestService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService extends BaseRestService {

    public ResponseEntity<List<PersonResource>> getPeople() {
        return restTemplate.exchange(getBaseUrl() + "/person/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonResource>>() {
                });
    }
}
