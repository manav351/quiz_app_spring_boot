package com.project.programmingQuiz.Controller;

import com.project.programmingQuiz.Entity.GenericResponse;
import com.project.programmingQuiz.Entity.Question;
import com.project.programmingQuiz.Entity.QuestionWrapper;
import com.project.programmingQuiz.Service.QuizServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    QuizServiceImplementation quizService;

    @Autowired
    public QuizController(QuizServiceImplementation newQuizService) {
        quizService = newQuizService;
    }

    @PostMapping("create")
    public ResponseEntity<GenericResponse> createQuiz(
            @RequestParam String category,
            @RequestParam int noOfQuestions,
            @RequestParam String quizTitle
    ){
        return quizService.createQuiz(category,noOfQuestions,quizTitle);
    }

    @GetMapping("{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId){
        return quizService.getQuizQuestions(quizId);
    }
}
