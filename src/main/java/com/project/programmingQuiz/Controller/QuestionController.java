package com.project.programmingQuiz.Controller;

import com.project.programmingQuiz.Entity.GenericResponse;
import com.project.programmingQuiz.Entity.Question;
import com.project.programmingQuiz.Entity.ResponseStatus;
import com.project.programmingQuiz.ExceptionHandler.NegativeQuestionId;
import com.project.programmingQuiz.Service.QuestionServiceImplementation;
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
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/allQuestions/{selectedCategory}")
    public List<Question> getQuestionsByCategory(@PathVariable String selectedCategory){
        return questionService.getQuestionsByCategory(selectedCategory);
    }

    @GetMapping("/{questionId}")
    public GenericResponse getQuestionById(@PathVariable int questionId){
        return questionService.getQuestionById(questionId);
    }

    @PostMapping("")
    public GenericResponse addQuestionToTable(@RequestBody Question requestedQuestion){
        if(requestedQuestion.getId() < 0)
            throw new NegativeQuestionId("");

        return questionService.addQuestion(requestedQuestion);
    }

    @DeleteMapping("/{questionId}")
    public GenericResponse deleteQuestionFromDB(@PathVariable int questionId){
        return questionService.deleteQuestion(questionId);
    }

    @PutMapping("")
    public GenericResponse updateQuestion(@RequestBody Question requestedQuestion){
        if(requestedQuestion.getId() < 0)
            throw new NegativeQuestionId("");

        return questionService.updateQuestion(requestedQuestion);
    }
}
