package com.birse.person;

import com.birse.service.BaseRestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonService extends BaseRestService {

    @HystrixCommand(fallbackMethod = "getPeopleReliable")
    public ResponseEntity<List<PersonResource>> getPeople() {
        return restTemplate.exchange(getBaseUrl() + "/person",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonResource>>() {
                });
    }

    public ResponseEntity<List<PersonResource>> getPeopleReliable() {
        return ResponseEntity.ok(new ArrayList<PersonResource>());
    }

    public ResponseEntity<Void> delete(Long id) {
        restTemplate.delete(getBaseUrl() + "/person/" + id);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<PersonResource> getPerson(Long id) {
        return restTemplate.exchange(getBaseUrl() + "/person/" + id,
                HttpMethod.GET, null, new ParameterizedTypeReference<PersonResource>() {
                });
    }

    public ResponseEntity<Void> update(Long id, PersonResource person) {
        //TODO change to exchange so we can process the result.
        restTemplate.put(getBaseUrl() + "/person/" + id, person);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<PersonResource> save(PersonResource person) {
        return restTemplate.postForEntity(getBaseUrl() + "/person", person, PersonResource.class);
    }
}
