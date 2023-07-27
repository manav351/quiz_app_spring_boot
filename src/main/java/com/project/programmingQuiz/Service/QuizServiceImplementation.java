package com.project.programmingQuiz.Service;

import com.project.programmingQuiz.DAO.QuestionDAO;
import com.project.programmingQuiz.DAO.QuestionDAOImplementation;
import com.project.programmingQuiz.DAO.QuizDAO;
import com.project.programmingQuiz.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImplementation implements QuizService{

    QuizDAO quizDAO;
    QuestionDAOImplementation questionDAO;

    @Autowired
    public QuizServiceImplementation(QuizDAO quizDAO, QuestionDAOImplementation questionDAO) {
        this.quizDAO = quizDAO;
        this.questionDAO = questionDAO;
    }

    public ResponseEntity<GenericResponse> createQuiz(String category, int noOfQuestions, String quizTitle) {

        List<Question> questions = questionDAO.findRandomQuestionsByCategory(category, noOfQuestions);

        Quiz quizObject = new Quiz();
        quizObject.setTitle(quizTitle);
        quizObject.setQuestions(questions);

        quizDAO.save(quizObject);

        return new ResponseEntity<>(
                new GenericResponse(
                        new ResponseStatus(true,"Operation Successful",""),
                        null),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {

        Optional<Quiz> quizObject = quizDAO.findById(quizId);
        List<Question> questionFromDB = quizObject.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(Question q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),
                    q.getQuestion(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            );

            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }
}
