package com.birse.person;

import com.birse.BaseController;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/person")
public class PersonController extends BaseController {

    @GetMapping
    public ResponseEntity<List<PersonResource>> sayHello() {
        return restTemplate.exchange(getBaseUrl() + "/person/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonResource>>() {
                });
    }
}
