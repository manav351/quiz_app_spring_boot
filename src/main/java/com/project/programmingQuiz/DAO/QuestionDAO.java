package com.project.programmingQuiz.DAO;

import com.project.programmingQuiz.Entity.Question;

import java.util.List;

public interface QuestionDAO{

    List<Question> findAll();

    List<Question> findByCategory(String selectedCategory);

}
