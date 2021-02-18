package by.hunar.kubik.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(path = "/hello")
    public String greet() {
        return "Vitaju";
    }
}
