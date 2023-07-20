package com.project.programmingQuiz.Service;

import com.project.programmingQuiz.DAO.QuestionDAOImplementation;
import com.project.programmingQuiz.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService{

    private QuestionDAOImplementation questionDAO;

    @Autowired
    public QuestionServiceImplementation(QuestionDAOImplementation newQuestionDAO){
        questionDAO = newQuestionDAO;
    }

    public List<Question> getAllQuestions(){
        return questionDAO.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(String selectedCategory) {
        return questionDAO.findByCategory(selectedCategory);
    }

}
