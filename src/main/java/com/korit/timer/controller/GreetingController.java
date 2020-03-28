package com.korit.timer.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @GetMapping("/{person}")
    public String greetPerson(@PathVariable(name = "person") Optional<String> maybePerson){
        String person = "";
        if (maybePerson.isPresent()){
            person += maybePerson.get();
        } else {
            person += "unknown person";
        }
        return person;
    }

}
