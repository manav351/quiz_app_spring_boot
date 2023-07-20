package com.project.programmingQuiz.Controller;

import com.project.programmingQuiz.Entity.Question;
import com.project.programmingQuiz.Service.QuestionServiceImplementation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    private QuestionServiceImplementation questionService;

    public QuestionController(QuestionServiceImplementation newQuestionService){
        questionService = newQuestionService;
    }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/allQuestions/{selectedCategory}")
    public List<Question> getQuestionsByCategory(@PathVariable String selectedCategory){
        return questionService.getQuestionsByCategory(selectedCategory);
    }
}
