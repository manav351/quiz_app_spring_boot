package com.project.programmingQuiz.DAO;

import com.project.programmingQuiz.Entity.Question;
import com.project.programmingQuiz.Service.QuestionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImplementation implements QuestionDAO{

    private EntityManager entityManager;

    @Autowired
    public QuestionDAOImplementation(EntityManager newEntityManager){
        entityManager = newEntityManager;
    }

    @Override
    public List<Question> findAll() {
        TypedQuery<Question> findAllQuery = entityManager.createQuery("from Question", Question.class);
        List<Question> allQuestions = findAllQuery.getResultList();

        return allQuestions;
    }

    @Override
    public List<Question> findByCategory(String selectedCategory) {
        TypedQuery<Question> findByCategory = entityManager.createQuery("FROM Question WHERE category=:theCategory", Question.class);
        findByCategory.setParameter("theCategory", selectedCategory);

        List<Question> selectedQuestions = findByCategory.getResultList();

        return selectedQuestions;
    }

}
