package com.project.programmingQuiz.DAO;

import com.project.programmingQuiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {
}
