package com.birse.person;

import com.birse.BaseService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService extends BaseService {

    public ResponseEntity<List<PersonResource>> getPeople() {
        return restTemplate.exchange(getBaseUrl() + "/person",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonResource>>() {
                });
    }

    public void delete(Long id) {
        restTemplate.delete(getBaseUrl() + "/person/" + id);
    }

    public ResponseEntity<PersonResource> getPerson(Long id) {
        return restTemplate.exchange(getBaseUrl() + "/person/" + id,
                HttpMethod.GET, null, new ParameterizedTypeReference<PersonResource>() {
                });
    }

    public void update(PersonResource person) {
        restTemplate.postForObject(getBaseUrl() + "/person/" + person.getId(), person, PersonResource.class);
    }

    public void add(PersonResource person) {
        restTemplate.postForObject(getBaseUrl() + "/person/", person, PersonResource.class);

    }
}
