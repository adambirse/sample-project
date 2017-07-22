package com.birse.person;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Log LOG = LogFactory.getLog(PersonController.class);

    @Autowired
    private PersonRepository repo;

    @Autowired
    private PersonResourcePersonMapper mapper;

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
    public ResponseEntity<Iterable<PersonResource>> all() {
        return ResponseEntity.ok(mapper.sourceToDestination(repo.findAll()));
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
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
