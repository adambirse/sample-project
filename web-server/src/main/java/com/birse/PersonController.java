package com.birse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @RequestMapping("/person")
    public String person() {
        return "pages/person";
    }
}