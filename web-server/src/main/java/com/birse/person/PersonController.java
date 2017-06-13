package com.birse.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping("/person")
    public String person(Model model) {
        ResponseEntity<List<PersonResource>> people = service.getPeople();
        model.addAttribute("persons", people.getBody());
        return "pages/person";
    }
}