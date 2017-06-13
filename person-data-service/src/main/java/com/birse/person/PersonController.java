package com.birse.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository repo;


    @GetMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName,
                                           @RequestParam String lastName) {

        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        repo.save(p);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Person> all() {
        return repo.findAll();
    }
}
