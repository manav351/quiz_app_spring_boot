package com.project.programmingQuiz.DAO;

import com.project.programmingQuiz.Entity.Question;

import java.util.List;

public interface QuestionDAO{

    List<Question> findAll();

    List<Question> findByCategory(String selectedCategory);

    Question save(Question requestedQuestion);

    Question findById(int questionId);

    void deleteByQuestion(Question questionObject);

    Question updateByQuestion(Question requestedQuestion);

    List<Question> findRandomQuestionsByCategory(String category, int noOfQuestions);
}
