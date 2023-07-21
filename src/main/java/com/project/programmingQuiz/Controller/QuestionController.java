package com.project.programmingQuiz.Controller;

import com.project.programmingQuiz.Entity.GenericResponse;
import com.project.programmingQuiz.Entity.Question;
import com.project.programmingQuiz.Entity.ResponseStatus;
import com.project.programmingQuiz.ExceptionHandler.NegativeQuestionId;
import com.project.programmingQuiz.Service.QuestionServiceImplementation;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    private QuestionServiceImplementation questionService;

    public QuestionController(QuestionServiceImplementation newQuestionService){
        questionService = newQuestionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/all/{selectedCategory}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String selectedCategory){
        return new ResponseEntity<>(questionService.getQuestionsByCategory(selectedCategory), HttpStatus.OK);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<GenericResponse> getQuestionById(@PathVariable int questionId){
        return new ResponseEntity<>(questionService.getQuestionById(questionId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GenericResponse> addQuestionToTable(@RequestBody Question requestedQuestion){
        if(requestedQuestion.getId() < 0)
            throw new NegativeQuestionId("");

        return new ResponseEntity<>(questionService.addQuestion(requestedQuestion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<GenericResponse> deleteQuestionFromDB(@PathVariable int questionId){
        return new ResponseEntity<>(questionService.deleteQuestion(questionId), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<GenericResponse> updateQuestion(@RequestBody Question requestedQuestion){
        if(requestedQuestion.getId() < 0)
            throw new NegativeQuestionId("");

        return new ResponseEntity<>(questionService.updateQuestion(requestedQuestion), HttpStatus.OK) ;
    }
}
