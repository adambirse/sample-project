package com.birse.person;

import com.birse.service.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/person")
public class PersonController extends BaseRestService {

    @Autowired
    PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonResource>> people() {
        return service.getPeople();
    }
}
