package com.project.programmingQuiz.Controller;

import com.project.programmingQuiz.Entity.GenericResponse;
import com.project.programmingQuiz.Entity.QuestionWrapper;
import com.project.programmingQuiz.Entity.UserResponse;
import com.project.programmingQuiz.Service.QuizServiceImplementation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<UserResponse> userResponses){
        return quizService.calculateResult(id, userResponses);
    }

    @PostMapping("correctAnswer/{id}")
    public ResponseEntity<List<UserResponse>> findCorrectAnswers(@PathVariable Integer id, @RequestBody List<UserResponse> userResponses){
        return quizService.findCorrectAnswers(id, userResponses);
    }
}
