package com.birse.person;

import com.birse.BaseService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created on 12/06/2017.
 */
@Component
public class PersonService extends BaseService {

    @GetMapping
    public ResponseEntity<List<PersonResource>> getPeople() {
        return restTemplate.exchange(getBaseUrl() + "/person",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonResource>>() {
                });
    }
}
