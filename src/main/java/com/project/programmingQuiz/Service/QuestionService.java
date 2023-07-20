package com.project.programmingQuiz.Service;

import com.project.programmingQuiz.Entity.Question;

import javax.swing.*;
import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    List<Question> getQuestionsByCategory(String selectedCategory);

}
