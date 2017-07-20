package com.birse.person;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private static final Log LOG = LogFactory.getLog(PersonController.class);

    @Autowired
    PersonService service;

    @HystrixCommand(fallbackMethod = "reliable")
    @GetMapping()
    public String people(Model model) {
        LOG.info("Loading all the people");
        model.addAttribute("persons", service.getPeople().getBody());
        return "pages/person";
    }

    public String reliable(Model model) {
        return "pages/person-reliable";
    }

    @GetMapping("/add")
    public String addPerson(Model model) {
        LOG.info("Loading Add page");
        model.addAttribute("person", new PersonResource());
            return "pages/person-add";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute PersonResource person) {
        LOG.info("Adding person: " + person.toString());
        service.add(person);
        return "redirect:/person";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        LOG.info("Deleting person with id = " + id);
        service.delete(id);
        return "redirect:/person";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        LOG.info("Loading Edit page for person with id = " + id);
        model.addAttribute("person", service.getPerson(id).getBody());
        return "pages/person-edit";
    }

    @PostMapping("/edit")
    public String editPerson(@ModelAttribute PersonResource person) {
        LOG.info("Editing person: " + person.toString());
        service.update(person);
        return "redirect:/person";
    }
}
