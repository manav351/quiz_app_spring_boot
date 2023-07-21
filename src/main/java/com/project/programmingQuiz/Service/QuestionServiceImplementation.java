package com.project.programmingQuiz.Service;

import com.project.programmingQuiz.DAO.QuestionDAOImplementation;
import com.project.programmingQuiz.Entity.GenericResponse;
import com.project.programmingQuiz.Entity.Question;
import com.project.programmingQuiz.Entity.ResponseStatus;
import com.project.programmingQuiz.ExceptionHandler.QuestionNotFound;
import jakarta.transaction.Transactional;
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

    @Override
    public GenericResponse getQuestionById(int questionId) {
        Question requestedQuestion = questionDAO.findById(questionId);
        if(requestedQuestion == null){
           throw new QuestionNotFound("Not Found");
        }

        return new GenericResponse(
                new ResponseStatus(true, "Operation Successful", ""),
                requestedQuestion
        );
    }

    @Override
    @Transactional
    public GenericResponse addQuestion(Question requestedQuestion) {
        requestedQuestion.setId(0);
        Question savedQuestion = questionDAO.save(requestedQuestion);
        GenericResponse responseBody = new GenericResponse(
                new ResponseStatus(true, "Operation Successful", ""),
                savedQuestion
        );
        return responseBody;
    }

    @Override
    @Transactional
    public GenericResponse deleteQuestion(int questionId) {
        Question requestedQuestion = questionDAO.findById(questionId);
        if(requestedQuestion == null){
            throw new QuestionNotFound("Not Found");
        }

        questionDAO.deleteByQuestion(requestedQuestion);
        return new GenericResponse(
                new ResponseStatus(true, "Operation Successful", ""),
                requestedQuestion
        );
    }

    @Override
    @Transactional
    public GenericResponse updateQuestion(Question requestedQuestion) {
        Question updatedQuestion = questionDAO.updateByQuestion(requestedQuestion);
        return new GenericResponse(
                new ResponseStatus(true, "Operation Successful", ""),
                updatedQuestion
        );
    }
}
