package com.project.programmingQuiz.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class quizRestController {

    @GetMapping("/")
    public String printHelloWorld(){
        return "Hello World";
    }

}
