package com.project.programmingQuiz.Service;

import com.project.programmingQuiz.Entity.GenericResponse;
import com.project.programmingQuiz.Entity.QuestionWrapper;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {

    public ResponseEntity<GenericResponse> createQuiz(String category, int noOfQuestions, String quizTitle);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId);
}
