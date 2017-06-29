package com.birse.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository repo;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        Person p = repo.findOne(id);
        if (p == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(p);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> all() {
        return ResponseEntity.ok(repo.findAll());
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(repo.save(new Person(person.getFirstName(), person.getLastName())));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        Person existingPerson = repo.findOne(id);
        if (existingPerson == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            repo.save(existingPerson);
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
        if (repo.findOne(id) != null) {
            repo.delete(id);
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
}
