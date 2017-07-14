package com.birse.person;

import com.birse.service.BaseRestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController()
@RequestMapping("/person")
public class PersonController {

    private static final Log LOG = LogFactory.getLog(PersonController.class);

    @Autowired
    PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonResource>> people() {
        LOG.info("Getting people");
        return service.getPeople();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResource> getPerson(@PathVariable("id") Long id) {
        LOG.info("Getting person with id: " + id);
        return service.getPerson(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody PersonResource person) {
      LOG.info("updating person:" + person.toString());
      return service.update(id,person);
    }

    @PostMapping()
    public ResponseEntity<PersonResource> save(@RequestBody PersonResource person) {
        LOG.info("updating person:" + person.toString());
        return service.save(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
        LOG.info("Deleting person with id: " + id);
        return service.delete(id);
    }
}
